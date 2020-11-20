package apap.tutorial.haidokter.restcontroller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.rest.ObatDetail;
import apap.tutorial.haidokter.service.ObatRestService;
import apap.tutorial.haidokter.service.ResepRestService;

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


@RestController
@RequestMapping("/api/v1")
public class ObatRestController {
    @Autowired
    private ObatRestService obatRestService;

    @Autowired
    private ResepRestService resepRestService;

    @PostMapping(value = "/obat")
    private ObatModel addObat(@Valid @RequestBody ObatModel obat, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else{
            ResepModel resep = resepRestService.getResepByNoResep((long)2);
            obat.setResepModel(resep);
            return obatRestService.createObat(obat);
        }
    }

    @DeleteMapping(value = "/obat/{idObat}")
    private ResponseEntity<String> deleteObat(@PathVariable("idObat") Long idObat){
        try{
            obatRestService.deleteObat(idObat);
            return ResponseEntity.ok("Obat with Id " + String.valueOf(idObat) + " has been deleted!");
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Obat with Id " + String.valueOf(idObat) + " not found!"
            );
        }
    }

    @PutMapping(value = "/obat/{idObat}")
    private ObatModel updateObat(@PathVariable(value = "idObat") Long idObat, @RequestBody ObatModel obat){
        try{
            return obatRestService.changeObat(idObat, obat);
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Obat with Id " + String.valueOf(idObat) + " not found!"
            );
        }
    }

    @GetMapping(value="/obat-all")
    private List<ObatModel> retrieveListObat() {return obatRestService.retrieveListObat();}

    @GetMapping(value = "/obat/{idObat}")
    private ObatModel getObat(@PathVariable("idObat") Long idObat){
        try{
            return obatRestService.getObatByIdObat(idObat);
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Obat with Id " + String.valueOf(idObat) + " not found!"
            );
        }
    }


    @GetMapping(value = "/obat/{idObat}/status")
    private Mono<String> getStatus(@PathVariable Long idObat){
        return obatRestService.getStatus(idObat);
    }

    @GetMapping(value = "/obat/full")
    private Mono<ObatDetail> postStatus(){
        return obatRestService.postStatus();
    }
}
