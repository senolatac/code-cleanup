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

    public void execute(Runnable runnable){
        preSet();
        runnable.run();
        postSet();
    }

    public void save(Patient patient){
        execute(new Runnable() {
            @Override
            public void run() {
                patientList.add(patient);
            }
        });
    }

    public void delete(Patient patient){
        execute(()-> patientList.remove(patient));
    }

    public void update(Patient patient){
        execute(()-> patientList.set(patientList.indexOf(patient), patient));
    }
}
