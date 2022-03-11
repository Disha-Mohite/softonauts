package com.gwebcircle.softonauts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {


    @JsonProperty("id")
    public int id;

    @JsonProperty("fk_user_type_id")
    public int fkusertypeid;

    @JsonProperty("fk_org_id")
    public int fkorgid;

    @JsonProperty("fk_branch_id")
    public int fkbranchid;

    @JsonProperty("primary_fk_org_id")
    public int primaryfkorgid;

    @JsonProperty("first_name")
    public String firstname;

    @JsonProperty("middle_name")
    public String middlename;

    @JsonProperty("last_name")
    public String lastname;

    @JsonProperty("dob")
    public String dob;

    @JsonProperty("gender")
    public String gender;

    @JsonProperty("contact")
    public String contact;

    @JsonProperty("contact_email")
    public String email;

    @JsonProperty("address_one")
    public String addressone;

    @JsonProperty("adderss_two")
    public String addresstwo;

    @JsonProperty("city")
    public String city;

    @JsonProperty("state")
    public String state;

    @JsonProperty("zipcode")
    public int zipcode;

    @JsonProperty("password")
    public String password;

    @JsonProperty("login_type")
    public String logintype;

    @JsonProperty("ssn_digits")
    public int ssndigits;
}
