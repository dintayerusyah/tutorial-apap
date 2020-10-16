package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ObatController {
    @Qualifier("resepServiceImpl")
    @Autowired
    ResepService resepService;

    @Autowired
    ObatService obatService;
    
    //Temporary list for obat rows
    // List<ObatModel> obatRows = new ArrayList<ObatModel>();

    // Form Add Obat
    @GetMapping("/obat/add/{noResep}")
    private String addObatFormPage(
        @PathVariable Long noResep,
        Model model
    ){
        ObatModel obat = new ObatModel();
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        obat.setResepModel(resep);
        model.addAttribute("obat", obat);

        return "form-add-obat";
    }

    // Submit Form Add Obat
    @PostMapping("/obat/add")
    private String addObatSubmit(
        @ModelAttribute ObatModel obat,
        Model model
    ){
        obatService.addObat(obat);
        model.addAttribute("nama", obat.getNama());

        return "add-obat";
    }

    // Form Add Multiple Obat
    @GetMapping("/obat/add-multiple/{noResep}")
    private String addMultipleObatFormPage(
        @PathVariable Long noResep,
        Model model
    ){
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        List<ObatModel> obatList = new ArrayList<>();
        obatList.add(new ObatModel());
        resep.setListObat(obatList);
        
        // ObatModel obat = new ObatModel();
        // resep.getListObat().add(obat);
        // System.out.println(resep.getListObat().size());
        model.addAttribute("resep", resep);

        return "form-addmultiple-obat";
    }

    // Submit Form Add Multiple Obat
    @RequestMapping(value="obat/add-multiple/{noResep}", params={"simpan"}, method=RequestMethod.POST)
    private String addMultipleObatSubmit(
        @ModelAttribute ResepModel resep,
        Model model
    ){
        ResepModel resepModel = resepService.getResepByNomorResep(resep.getNoResep());
        List<ObatModel> listObat = resep.getListObat();
        // System.out.println("Submission size : " + resep.getListObat().size());
        for(ObatModel obat : listObat){
            obat.setResepModel(resepModel);
            obatService.addObat(obat);
        }
        model.addAttribute("obatCount", listObat.size());
        System.out.println("Submission size : " + listObat.size());
        return "addmultiple-obat";
    }

    // Add row to add multiple obat form
    @RequestMapping(value="obat/add-multiple/{noResep}", params={"addRow"}, method=RequestMethod.POST)
    private String addRow(
        @ModelAttribute ResepModel resep, Model model
    ){
        if (resep.getListObat() == null || resep.getListObat().size() == 0) {
            resep.setListObat(new ArrayList<>());
        }
        resep.getListObat().add(new ObatModel());
        // ObatModel obat = new ObatModel();
        // resep.getListObat().add(obat);
        // obat.setResepModel(resep);
        // resepService.updateResep(resep);
        model.addAttribute("resep", resep);
        System.out.println(resep.getListObat().size());
        return "form-addmultiple-obat";
    }

    //Remove row from add multiple obat form
    @RequestMapping(value="obat/add-multiple/{noResep}", params={"hapusRow"}, method=RequestMethod.POST)
    private String removeRow(
        @ModelAttribute ResepModel resep, Model model, HttpServletRequest req
    ){
        Integer rowId = Integer.valueOf(req.getParameter("hapusRow"));
        resep.getListObat().remove(rowId.intValue());
        // resepService.updateResep(resep);
        model.addAttribute("resep", resep);
        System.out.println(resep.getListObat().size());
        return "form-addmultiple-obat";
    }

    // Form Update Obat
    @GetMapping("/obat/change/{id}")
    private String changeObatFormPage(
        @PathVariable Long id,
        Model model
    ){
        ObatModel obat = obatService.getObatByIdObat(id);
        model.addAttribute("obat", obat);

        return "form-update-obat";
    }

    // Submit Form Update Obat
    @PostMapping("/obat/change")
    private String changeObatFormSubmit(
        @ModelAttribute ObatModel obat,
        Model model
    ){
        ObatModel updatedObat = obatService.updateObat(obat);
        model.addAttribute("obat", updatedObat);

        return "update-obat";
    }

    // @GetMapping("/obat/delete/{id}")
    // private String deleteObat(
    //     @PathVariable Long id,
    //     Model model
    // ){
    //     ObatModel obat = obatService.getObatByIdObat(id);
    //     obatService.deleteObat(obat);
    //     return "delete-obat";
    // }
    
    // Delete Obat
    @PostMapping(value = "/obat/delete")
    public String deleteObatFormSubmit(@ModelAttribute ResepModel resep, Model model){
        model.addAttribute("obatCount", resep.getListObat().size());
        for (ObatModel obat : resep.getListObat()){
            obatService.deleteObatById(obat.getId());
        }
        return "delete-obat";
    }
}
