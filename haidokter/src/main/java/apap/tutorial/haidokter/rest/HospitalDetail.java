package apap.tutorial.haidokter.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HospitalDetail {
    @JsonProperty("apiKey")
    private String apiKey;

    @JsonProperty("query")
    private String query;

    @JsonProperty("hospital_id")
    private Integer hospital_id;

    @JsonProperty("hospital_system_id")
    private Integer hospital_system_id;

    @JsonProperty("hospital_org_id")
    private Integer hospital_org_id;

    @JsonProperty("ein")
    private Integer ein;

    @JsonProperty("name")
    private String name;

    @JsonProperty("name2")
    private String name2;

    @JsonProperty("name3")
    private String name3;

    @JsonProperty("street_address")
    private String street_address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zip_code")
    private Integer zip_code;

    @JsonProperty("american_association_id")
    private Integer american_association_id;

    @JsonProperty("medicare_provider_number")
    private Integer medicare_provider_number;

    @JsonProperty("fips_state_and_county_code")
    private Integer fips_state_and_county_code;

    @JsonProperty("hospital_bed_count")
    private Integer hospital_bed_count;

    @JsonProperty("chrch_affl_f")
    private String chrch_affl_f;

    @JsonProperty("memb_counc_teach_hosps_f")
    private String memb_counc_teach_hosps_f;

    @JsonProperty("urban_location_f")
    private String urban_location_f;

    @JsonProperty("children_hospital_f")
    private String children_hospital_f;

    @JsonProperty("county")
    private String county;

    @JsonProperty("hospital_bed_size")
    private String hospital_bed_size;

    @JsonProperty("updated_dt")
    private String updated_dt;

    public Integer getHospital_id() {
        return this.hospital_id;
    }

    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }

    public Integer getHospital_system_id() {
        return this.hospital_system_id;
    }

    public void setHospital_system_id(Integer hospital_system_id) {
        this.hospital_system_id = hospital_system_id;
    }

    public Integer getHospital_org_id() {
        return this.hospital_org_id;
    }

    public void setHospital_org_id(Integer hospital_org_id) {
        this.hospital_org_id = hospital_org_id;
    }

    public Integer getEin() {
        return this.ein;
    }

    public void setEin(Integer ein) {
        this.ein = ein;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return this.name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return this.name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getStreet_address() {
        return this.street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip_code() {
        return this.zip_code;
    }

    public void setZip_code(Integer zip_code) {
        this.zip_code = zip_code;
    }

    public Integer getAmerican_association_id() {
        return this.american_association_id;
    }

    public void setAmerican_association_id(Integer american_association_id) {
        this.american_association_id = american_association_id;
    }

    public Integer getMedicare_provider_number() {
        return this.medicare_provider_number;
    }

    public void setMedicare_provider_number(Integer medicare_provider_number) {
        this.medicare_provider_number = medicare_provider_number;
    }

    public Integer getFips_state_and_county_code() {
        return this.fips_state_and_county_code;
    }

    public void setFips_state_and_county_code(Integer fips_state_and_county_code) {
        this.fips_state_and_county_code = fips_state_and_county_code;
    }

    public Integer getHospital_bed_count() {
        return this.hospital_bed_count;
    }

    public void setHospital_bed_count(Integer hospital_bed_count) {
        this.hospital_bed_count = hospital_bed_count;
    }

    public String getChrch_affl_f() {
        return this.chrch_affl_f;
    }

    public void setChrch_affl_f(String chrch_affl_f) {
        this.chrch_affl_f = chrch_affl_f;
    }

    public String getMemb_counc_teach_hosps_f() {
        return this.memb_counc_teach_hosps_f;
    }

    public void setMemb_counc_teach_hosps_f(String memb_counc_teach_hosps_f) {
        this.memb_counc_teach_hosps_f = memb_counc_teach_hosps_f;
    }

    public String getUrban_location_f() {
        return this.urban_location_f;
    }

    public void setUrban_location_f(String urban_location_f) {
        this.urban_location_f = urban_location_f;
    }

    public String getChildren_hospital_f() {
        return this.children_hospital_f;
    }

    public void setChildren_hospital_f(String children_hospital_f) {
        this.children_hospital_f = children_hospital_f;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getHospital_bed_size() {
        return this.hospital_bed_size;
    }

    public void setHospital_bed_size(String hospital_bed_size) {
        this.hospital_bed_size = hospital_bed_size;
    }

    public String getUpdated_dt() {
        return this.updated_dt;
    }

    public void setUpdated_dt(String updated_dt) {
        this.updated_dt = updated_dt;
    }
    
    public String getApiKey() {
        return this.apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
