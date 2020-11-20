package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.rest.HospitalDetail;
import reactor.core.publisher.Mono;

public interface HospitalRestService {
    Mono<HospitalDetail> getHospitalByState(String state);
}
