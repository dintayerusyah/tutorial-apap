package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.repository.ObatDb;
import apap.tutorial.haidokter.rest.Setting;
import apap.tutorial.haidokter.rest.ObatDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ObatRestServiceImpl implements ObatRestService{
    private final WebClient webClient;

    @Autowired
    private ObatDb obatDb;

    @Override
    public ObatModel createObat(ObatModel obat){
        return obatDb.save(obat);
    }

    @Override
    public List<ObatModel> retrieveListObat(){
        return obatDb.findAll();
    }

    @Override
    public ObatModel getObatByIdObat(Long idObat){
        Optional<ObatModel> obat = obatDb.findById(idObat);
        if(obat.isPresent()){
            return obat.get();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public ObatModel changeObat(Long idObat, ObatModel obatUpdate){
        ObatModel obat = getObatByIdObat(idObat);
        obat.setNama(obatUpdate.getNama());
        obat.setBentuk(obatUpdate.getBentuk());
        obat.setKuantitas(obatUpdate.getKuantitas());
        return obatDb.save(obat);
    }
    @Override
    public void deleteObat(Long idObat){
        ObatModel obat = getObatByIdObat(idObat);
        obatDb.delete(obat);
    }

    public ObatRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.obatUrl).build();
    }

    @Override
    public Mono<String> getStatus(Long idObat){
        return this.webClient.get().uri("/rest/obat/"+idObat+"/status").retrieve().bodyToMono(String.class);
    }

    @Override
    public Mono<ObatDetail> postStatus(){
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("nama", "Antibiotik");
        data.add("bentuk", "1");
        data.add("kuantitas", "10");
        return this.webClient.post().uri("/rest/resep/full").syncBody(data).retrieve().bodyToMono(ObatDetail.class);
    }
}
