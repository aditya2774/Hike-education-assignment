package com.assignment.manipal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class EnquireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String name;

    @Email(message = "Please provide valid email address !")
    private String email;

    @NotEmpty
    private String countryCode;

    @NotEmpty
    @Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$" , message = "Please provide valid mobile number!")
    private String mobile;

    @NotEmpty
    private String state;

    @NotEmpty
    private String city;

    @NotEmpty
    private String program;

    @NotEmpty
    private String elective;

    @NotNull
    private boolean agreement;

    public @NotEmpty String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(@NotEmpty String countryCode) {
        this.countryCode = countryCode;
    }

    @NotNull
    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(@NotNull boolean agreement) {
        this.agreement = agreement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getElective() {
        return elective;
    }

    public void setElective(String elective) {
        this.elective = elective;
    }





}
