package com.sha.model;

public class Contact extends BaseModel {

    private IModel address;
    private IModel phone;

    public IModel getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public IModel getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
