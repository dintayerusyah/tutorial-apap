package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.rest.Setting;
import apap.tutorial.haidokter.rest.HospitalDetail;

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
public class HospitalRestServiceImpl implements HospitalRestService{
    private final WebClient webClient;

    public HospitalRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.hospitalUrl).build();
    }

    @Override
    public Mono<HospitalDetail> getHospitalByState(String state){
        return this.webClient.get().uri(uriBuilder -> uriBuilder
        .queryParam("state", state).build()).retrieve().bodyToMono(HospitalDetail.class);
    }
}