package com.sha.model;

public enum SpecialtyType {
    LIVER("01"),
    HEART("02"),
    EYE("03"),
    EAR("04"),
    BRAIN("05");

    private String code;

    SpecialtyType(String code){
        this.code = code;
    }
    public String code(){
        return code;
    }
}
