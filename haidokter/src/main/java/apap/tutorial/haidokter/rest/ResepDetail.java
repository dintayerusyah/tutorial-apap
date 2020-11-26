package apap.tutorial.haidokter.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResepDetail {
    private String status;

    @JsonProperty("resep-license")
    private Integer resepLicense;

    @JsonProperty("valid-until")
    private Date validUntil;

    public Date getValidUntil() {
        return this.validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Integer getResepLicense() {
        return this.resepLicense;
    }

    public void setResepLicense(Integer resepLicense) {
        this.resepLicense = resepLicense;
    }
}
