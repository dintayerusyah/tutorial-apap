package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;

import java.util.List;

public interface ResepService {
    //Method untuk menambahkan resep
    void addResep(ResepModel resep);

    //Method untuk mendapatkan semua data resep yang telah tersimpan
    List<ResepModel> getResepList();

    //Method untuk mendapatkan data sebuah resep berdasarkan nomor resep
    ResepModel getResepByNomorResep(String noResep);

    void updateCatatanResep(ResepModel resep, String catatan);

    void deleteResepByNoResep(String noResep);
}