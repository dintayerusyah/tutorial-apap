package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;

import java.util.List;

public interface ResepService {
    //Method untuk menambahkan resep
    void addResep(ResepModel resep);

    //Method untuk mendapatkan semua data resep yang telah tersimpan
    List<ResepModel> getResepList();

    //Method untuk mendapatkan data sebuah resep berdasarkan nomor resep
    ResepModel getResepByNomorResep(Long noResep);

    //Method untuk update resep
    ResepModel updateResep(ResepModel resepModel);

    //Method untuk menghapus resep
    void deleteResepByNoResep(ResepModel resepModel);

    // Tutorial 2
    // void updateCatatanResep(ResepModel resep, String catatan);

    // void deleteResepByNoResep(String noResep);
}