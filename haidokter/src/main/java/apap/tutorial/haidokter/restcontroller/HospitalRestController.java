package apap.tutorial.haidokter.restcontroller;

import apap.tutorial.haidokter.rest.HospitalDetail;
import apap.tutorial.haidokter.service.HospitalRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1")
public class HospitalRestController {
    @Autowired
    private HospitalRestService hospitalRestService;

    @RequestMapping(value="/hospitals/find", method=RequestMethod.GET)
    private Mono<String> getHospitalByState(@RequestParam(value = "state") String state){
        return hospitalRestService.getHospitalByState(state);
    }
    
}