package com.sha.pattern;

import com.sha.model.Patient;

import java.util.Arrays;
import java.util.List;

public class BuilderDesignPattern {

    public List<Patient> buildPatientList(String firstName, String lastName, String email, int count){
        return Arrays.asList(
                Patient.builder().setFirstName(firstName).setLastName(lastName).build(),
                Patient.builder().setFirstName(firstName).setLastName(lastName).setEmail(email).build(),
                Patient.builder().setFirstName(firstName).setLastName(lastName).setOperationCount(count).build());
    }
}
