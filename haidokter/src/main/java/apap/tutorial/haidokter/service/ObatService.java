package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;

import java.util.List;

public interface ObatService {
    void addObat(ObatModel obat);

    ObatModel getObatByIdObat(Long id);

    ObatModel updateObat(ObatModel obat);

    // void deleteObat(ObatModel obat);

    void deleteObatById(Long idObat);
}
