package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;


import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ListIterator;
import java.util.Comparator;


@Controller
public class ResepController {
    @Qualifier("resepServiceImpl")
    @Autowired
    private ResepService resepService;

    @Autowired
    private ObatService obatService;

    // @GetMapping("/")
    // private String home(){return "home";}

    @GetMapping("/resep/add")
    public String addResepFormPage(Model model){
        model.addAttribute("resep", new ResepModel());

        return "form-add-resep";
    }

    @PostMapping("/resep/add")
    public String addResepSubmit(
        @ModelAttribute ResepModel resep,
        Model model
    ){
        resepService.addResep(resep);
        model.addAttribute("nomorResep", resep.getNoResep());
        
        return "add-resep";
    }

    @GetMapping("/resep/change/{noResep}")
    private String changeResepFormPage(
        @PathVariable Long noResep,
        Model model
    ){
        try {
            ResepModel resep = resepService.getResepByNomorResep(noResep);
        model.addAttribute("resep", resep);
        
        return "form-update-resep";
        }
        catch(Exception NoSuchElementException){
            return "resep-not-found";
        }
    }

    @PostMapping("/resep/change")
    private String changeResepFormSubmit(
        @ModelAttribute ResepModel resep,
        Model model
    ){
        ResepModel updatedResep = resepService.updateResep(resep);
        model.addAttribute("resep", updatedResep);

        return "update-resep";
    }   
    
    @GetMapping("/resep/view/{noResep}")
    public String viewDetailResep(
        @PathVariable Long noResep,
        Model model
    ){
        try{
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            List<ObatModel> listObat = resep.getListObat();

            model.addAttribute("resep", resep);
            model.addAttribute("listObat", listObat);

            return "view-resep";
        }
        catch(Exception NoSuchElementException){
            return "resep-not-found";
        }
        
    }

    //Latihan nomor 1
    //Method view all resep
    @GetMapping("/resep/viewall")
    public String viewAllResep(
        Model model
    ){
        List<ResepModel> listResep = resepService.getResepList();
        listResep.sort(Comparator.comparing(ResepModel::getNoResep).reversed());
        model.addAttribute("listResep", listResep);
        return "viewall-resep";
    }

    //Latihan no 4
    @GetMapping("/resep/delete/{noResep}")
    public String deleteResep(
        @PathVariable Long noResep,
        Model model
    ){
        try{
            //Memeriksa apakah resep memiliki obat
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            List<ObatModel> listObat = resep.getListObat();
            //Jika tidak ada obat, hapus resep
            if(listObat.isEmpty()){
                model.addAttribute("resep", resep);
                resepService.deleteResepByNoResep(resep);
                return "delete-resep";
            }
            //Gagal menghapus resep
            else{
                return "delete-resep-failed";
            }
        }
        catch(Exception NoSuchElementException){
            return "resep-not-found";
        }
    }
}
