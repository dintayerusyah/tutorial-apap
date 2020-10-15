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

    @GetMapping("/")
    private String home(){return "home";}

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
    
    @GetMapping("/resep/view")
    public String viewDetailResep(
        @RequestParam(value = "noResep") Long noResep,
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

    // TUTORIAL 2
    // @Autowired
    // private ResepService resepService;

    // //Routing URL yang diinginkan
    // @RequestMapping("/resep/add")
    // public String addResep(
    //     //Request parameter yang ingin dibawa
    //     @RequestParam(value = "noResep", required = true) String noResep,
    //     @RequestParam(value = "namaDokter", required = true) String namaDokter,
    //     @RequestParam(value = "namaPasien" ,required = true) String namaPasien,
    //     @RequestParam(value = "catatan", required = true) String catatan,
    //     Model model
    // ){
    //     //Membuat objek ResepModel
    //     ResepModel resep = new ResepModel(noResep, namaDokter, namaPasien, catatan);

    //     //Memanggil service addResep
    //     resepService.addResep(resep);

    //     //Add variabel nomor resep ke 'nomorResep' untuk dirender pada Thymeleaf
    //     model.addAttribute("nomorResep", noResep);

    //     //Return view template yang ingin digunakan
    //     return "add-resep";
    // }

    // @RequestMapping("/resep/viewall")
    // public String listResep(Model model){
    //     //Mendapatkan semua ResepModel
    //     List<ResepModel> listResep = resepService.getResepList();

    //     //Add variabel semua ResepModel ke 'listResep' untuk dirender pada thymeleaf
    //     model.addAttribute("listResep", listResep);

    //     //Return view template yang ingin digunakan
    //     return "viewall-resep";
    // }

    // //Routing URL untuk melihat detail resep
    // @RequestMapping("/resep/view")
    // public String detailResep(
    //     @RequestParam(value="noResep") String noResep, Model model
    // ){
    //     //Mendapatkan ResepModel sesuai nomor resep
    //     ResepModel resep = resepService.getResepByNomorResep(noResep);

    //     //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
    //     model.addAttribute("resep", resep);

    //     //Return view template yang ingin digunakan
    //     return "view-resep";
    // }

    // //LATIHAN NOMOR 1
    // @RequestMapping("/resep/view/no-resep/{noResep}")
    // public String detailResepPathVariable(
    //     @PathVariable(value="noResep") String noResep, Model model
    // ){
    //     //Mendapatkan ResepModel sesuai nomor resep
    //     ResepModel resep = resepService.getResepByNomorResep(noResep);

    //     //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
    //     model.addAttribute("resep", resep);

    //     //Return view template yang ingin digunakan
    //     return "view-resep";
    // }

    // //LATIHAN NOMOR 2
    // @RequestMapping("/resep/update/no-resep/{noResep}/catatan/{catatan}")
    // public String updateResep(
    //     @PathVariable(value="noResep") String noResep, 
    //     @PathVariable(value="catatan") String catatan,
    //     Model model
    // ){
    //     //Mendapatkan ResepModel sesuai nomor resep
    //     ResepModel resep = resepService.getResepByNomorResep(noResep);

    //     //Mengubah catatan resep
    //     resepService.updateCatatanResep(resep, catatan);

    //     //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
    //     model.addAttribute("resep", resep);

    //     //Return view template yang ingin digunakan
    //     return "update-resep-success";

    // }

    // //LATIHAN NO 3
    // @RequestMapping("/resep/delete/no-resep/{noResep}")
    // public String deleteResep(
    //     @PathVariable(value="noResep") String noResep,
    //     Model model
    // ){
    //     //Mendapatkan ResepModel sesuai nomor resep
    //     ResepModel resep = resepService.getResepByNomorResep(noResep);
        
    //     //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
    //     model.addAttribute("resep", resep);

    //     if (resep == null){
    //         return "delete-not-found";
    //     }
    //     else{
    //         //Menghapus resep
    //         resepService.deleteResepByNoResep(noResep);

    //         //Return view template yang ingin digunakan
    //         return "delete-resep";
    //     }
    // }
}
