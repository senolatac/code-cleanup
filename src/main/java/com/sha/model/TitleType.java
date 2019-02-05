package com.sha.model;

public enum TitleType {
    DR(3), ASSOC(2), PROF(1);

    private Integer order;
    TitleType(Integer order){
        this.order = order;
    }

    public Integer order(){
        return order;
    }
}
