package apap.tutorial.haidokter.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObatDetail {
    private String status;

    @JsonProperty("obat-license")
    private Integer obatLicense;

    @JsonProperty("valid-until")
    private Date validUntil;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getObatLicense() {
        return this.obatLicense;
    }

    public void setObatLicense(Integer obatLicense) {
        this.obatLicense = obatLicense;
    }

    public Date getValidUntil() {
        return this.validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

}
