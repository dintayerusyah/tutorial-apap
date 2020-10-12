package apap.tutorial.haidokter.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "apotek")
public class ApotekModel implements Serializable{
    @Id
    @Column(name = "apotek_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "nama_apotek", nullable = false)
    private String nama_apotek;

    @NotNull
    @Size(max = 50)
    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Size(max = 5)
    @Column(name = "kode_pos", nullable = true)
    private Integer kode_pos;

    @OneToMany(mappedBy = "apotekModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ObatModel> listObat;

    public List<ObatModel> getListObat() {
        return this.listObat;
    }

    public void setListObat(List<ObatModel> listObat) {
        this.listObat = listObat;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_apotek() {
        return this.nama_apotek;
    }

    public void setNama_apotek(String nama_apotek) {
        this.nama_apotek = nama_apotek;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getKode_pos() {
        return this.kode_pos;
    }

    public void setKode_pos(Integer kode_pos) {
        this.kode_pos = kode_pos;
    }

}
