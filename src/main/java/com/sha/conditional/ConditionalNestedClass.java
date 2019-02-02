package com.sha.conditional;

import com.sha.model.Doctor;
import com.sha.model.Patient;
import com.sha.model.SpecialtyType;
import com.sha.model.TitleType;

public class ConditionalNestedClass {

    public double nestedMethod(Doctor doctor, Patient patient){
        double value = 100;
        double multiply = 0;
        if(doctor != null){
            TitleType title = doctor.getTitle();
            if(TitleType.PROF.equals(title)){
                multiply = 2;
                if(doctor.getReputation()>1000){
                    multiply *=2;
                }else if(doctor.getReputation()>500){
                    multiply *=1.5;
                }
            }else if(TitleType.ASSOC.equals(title)){
                multiply = 1.5;
            }else{
                multiply = 1;
            }
            for(SpecialtyType specialty : doctor.getSpecialties()){
                if(TitleType.DR.equals(title)){
                    multiply *= 1.01;
                }
            }
        }
        if(patient !=null){
            if(patient.getOperationCount()>10){
                multiply *= 0.90;
            }else if(patient.getOperationCount()>5){
                multiply *= 0.95;
            }
        }else{
            multiply = 0;
        }
        return value * multiply;
    }
}
