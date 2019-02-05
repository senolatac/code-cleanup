package com.sha.model;

import java.util.HashSet;
import java.util.Set;

public class Patient extends Person implements  IOccupation{

    private static final long serialVersionUID = 1L;

    private int version;

    private String email;

    private int operationCount;

    private boolean live;

    private Set<BaseModel> operations = new HashSet<>();

    private IModel address;

    public Patient(){
        super();
    }

    public Patient(final String firstName, final String lastName){
        super(firstName, lastName);
    }

    public IModel getAddress() {
        return address;
    }

    public void setAddress(IModel address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getOperationCount() {
        return operationCount;
    }

    public void setOperationCount(int operationCount) {
        this.operationCount = operationCount;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Set<BaseModel> getOperations() {
        return operations;
    }

    public void setOperations(Set<BaseModel> operations) {
        this.operations = operations;
    }

    @Override
    public String occupation() {
        return "Patient";
    }

    @Override
    public String currentTitle() {
        return getGenre();
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        Patient patient;
        public Builder(){
            patient = new Patient();
        }

        public Builder setFirstName(String firstName){
            patient.setFirstName(firstName);
            return this;
        }

        public Builder setLastName(String lastName){
            patient.setLastName(lastName);
            return this;
        }

        public Builder setEmail(String email){
            patient.setEmail(email);
            return this;
        }

        public Builder setOperationCount(int operationCount){
            patient.setOperationCount(operationCount);
            return this;
        }

        public Patient build(){
            return patient;
        }
    }
}

