package com.sha.pattern;

import com.sha.model.Patient;

import java.util.Arrays;
import java.util.List;

public class BuilderDesignPattern {

    public List<Patient> buildPatientList(String firstName, String lastName, String email, int count){
        return Arrays.asList(createPatient(firstName, lastName),
                createPatient(firstName, lastName, email),
                createPatient(firstName, lastName, count));
    }

    private Patient createPatient(String firstName, String lastName){
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        return patient;
    }

    private Patient createPatient(String firstName, String lastName, String email){
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setEmail(email);
        return patient;
    }

    private Patient createPatient(String firstName, String lastName, int count){
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setOperationCount(count);
        return patient;
    }
}
