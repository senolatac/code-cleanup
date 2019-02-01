package com.sha.conditional;

import com.sha.model.Doctor;
import com.sha.model.Operation;
import com.sha.model.SpecialtyType;
import com.sha.model.TitleType;

import java.util.List;

public class ConditionalLoopClass {

    public Doctor findBestSafeDoctor(List<Doctor> doctorList, SpecialtyType specialtyType, TitleType type){
        int max = 0;
        Doctor result = null;
        for(Doctor doctor : doctorList){
            if(type.equals(doctor.getTitle())){
                int localMax = 0;
                if(doctor.getSpecialties().contains(specialtyType)){
                    for(Operation operation : doctor.getOperations()){
                        if(operation.isSucceed()){
                            ++localMax;
                        }else{
                            localMax = 0;
                        }
                    }
                }
                if(localMax > max){
                    max = localMax;
                    result = doctor;
                }
            }
        }
        return result;
    }
}
