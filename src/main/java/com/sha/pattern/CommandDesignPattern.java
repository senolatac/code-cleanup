package com.sha.pattern;

import com.sha.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class CommandDesignPattern {
    List<Patient> patientList;

    public void preSet(){
        if(patientList==null){
            patientList = new ArrayList<>();
        }
    }

    public void postSet(){
        System.out.println("Operation is completed successfully.");
    }

    public void save(Patient patient){
        preSet();
        patientList.add(patient);
        postSet();
    }

    public void delete(Patient patient){
        preSet();
        patientList.remove(patient);
        postSet();
    }

    public void update(Patient patient){
        preSet();
        patientList.set(patientList.indexOf(patient), patient);
        postSet();
    }
}
