package apap.tutorial.haidokter.service;

import java.util.List;
import apap.tutorial.haidokter.model.ResepModel;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ResepInMemoryService implements ResepService{
    private List<ResepModel> listResep;

    // Constructor
    public ResepInMemoryService(){
        listResep = new ArrayList<>();
    }

    @Override
    public void addResep(ResepModel resep){
        listResep.add(resep);
    }

    @Override
    public List<ResepModel> getResepList(){
        return listResep;
    }

    @Override
    public ResepModel getResepByNomorResep(String noResep){
        for (ResepModel resep : listResep){
            if(resep.getNoResep().equals(noResep)){
                return resep;
            }
        }
        return null;
    }

    @Override
    public void deleteAll(){
        //Mendapatkan semua ResepModel
        List<ResepModel> listResep = getResepList();

        //Menghapus resep
        listResep.clear();
    }
}
