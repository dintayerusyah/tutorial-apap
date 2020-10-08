package apap.tutorial.haidokter.controller;
import apap.tutorial.haidokter.service.ResepService;
import apap.tutorial.haidokter.model.ResepModel;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ListIterator;


@Controller
public class ResepController {
    @Autowired
    private ResepService resepService;

    //Routing URL yang diinginkan
    @RequestMapping("/resep/add")
    public String addResep(
        //Request parameter yang ingin dibawa
        @RequestParam(value = "noResep", required = true) String noResep,
        @RequestParam(value = "namaDokter", required = true) String namaDokter,
        @RequestParam(value = "namaPasien" ,required = true) String namaPasien,
        @RequestParam(value = "catatan", required = true) String catatan,
        Model model
    ){
        //Membuat objek ResepModel
        ResepModel resep = new ResepModel(noResep, namaDokter, namaPasien, catatan);

        //Memanggil service addResep
        resepService.addResep(resep);

        //Add variabel nomor resep ke 'nomorResep' untuk dirender pada Thymeleaf
        model.addAttribute("nomorResep", noResep);

        //Return view template yang ingin digunakan
        return "add-resep";
    }

    @RequestMapping("/resep/viewall")
    public String listResep(Model model){
        //Mendapatkan semua ResepModel
        List<ResepModel> listResep = resepService.getResepList();

        //Add variabel semua ResepModel ke 'listResep' untuk dirender pada thymeleaf
        model.addAttribute("listResep", listResep);

        //Return view template yang ingin digunakan
        return "viewall-resep";
    }

    //Routing URL untuk melihat detail resep
    @RequestMapping("/resep/view")
    public String detailResep(
        @RequestParam(value="noResep") String noResep, Model model
    ){
        //Mendapatkan ResepModel sesuai nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
        model.addAttribute("resep", resep);

        //Return view template yang ingin digunakan
        return "view-resep";
    }

    //LATIHAN NOMOR 1
    @RequestMapping("/resep/view/no-resep/{noResep}")
    public String detailResepPathVariable(
        @PathVariable(value="noResep") String noResep, Model model
    ){
        //Mendapatkan ResepModel sesuai nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
        model.addAttribute("resep", resep);

        //Return view template yang ingin digunakan
        return "view-resep";
    }

    //LATIHAN NOMOR 2
    @RequestMapping("/resep/update/no-resep/{noResep}/catatan/{catatan}")
    public String updateResep(
        @PathVariable(value="noResep") String noResep, 
        @PathVariable(value="catatan") String catatan,
        Model model
    ){
        //Mendapatkan ResepModel sesuai nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        //Mengubah catatan resep
        resep.setCatatan(catatan);

        //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
        model.addAttribute("resep", resep);

        //Return view template yang ingin digunakan
        return "update-resep-success";

    }

    //LATIHAN NO 3
    @RequestMapping("/resep/delete/no-resep/{noResep}")
    public String deleteResep(
        @PathVariable(value="noResep") String noResep,
        Model model
    ){
        //Mendapatkan ResepModel sesuai nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        
        //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
        model.addAttribute("resep", resep);

        if (resep == null){
            return "delete-not-found";
        }
        else{
            //Mendapatkan semua ResepModel
            List<ResepModel> listResep = resepService.getResepList();

            //Menghapus resep
            ListIterator<ResepModel> iter = listResep.listIterator();
            while(iter.hasNext()){
                if(iter.next().getNoResep().equals(noResep)){
                    iter.remove();
                }
            }

            //Return view template yang ingin digunakan
            return "delete-resep";
        }
    }
}
