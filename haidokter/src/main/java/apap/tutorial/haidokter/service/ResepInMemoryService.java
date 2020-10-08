package apap.tutorial.haidokter.service;

import java.util.List;
import apap.tutorial.haidokter.model.ResepModel;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.util.ListIterator;

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
    public void updateCatatanResep(ResepModel resep, String catatan){
        resep.setCatatan(catatan);
    }

    @Override
    public void deleteResepByNoResep(String noResep){
        //Mendapatkan semua ResepModel
        List<ResepModel> listResep = this.getResepList();

        //Menghapus resep
        ListIterator<ResepModel> iter = listResep.listIterator();
        while(iter.hasNext()){
            if(iter.next().getNoResep().equals(noResep)){
                iter.remove();
            }
        }
    }
}
