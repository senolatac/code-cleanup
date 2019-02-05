package com.sha.conditional;

import com.sha.model.*;

import java.util.List;

public class ConditionalLoopClass {

    private int maxSuccessfulOperation;

    public Doctor findMostTrustedDoctor(final List<Doctor> doctorList, final SpecialtyType specialtyType,
                                        final TitleType titleType){
        maxSuccessfulOperation = 0;
        Doctor resultDoctor = null;
        for(final Doctor doctor : doctorList){
            resultDoctor = getBestDoctorFromTitle(specialtyType, titleType, resultDoctor, doctor);
        }
        return resultDoctor;
    }

    private Doctor getBestDoctorFromTitle(SpecialtyType specialtyType, TitleType titleType, Doctor resultDoctor, Doctor doctor) {
        if(titleType.equals(doctor.getTitle())){
            int localMax = 0;
            localMax = getLocalMaxAsSpecialty(specialtyType, doctor, localMax);
            resultDoctor = getDoctorFromLocalMax(resultDoctor, doctor, localMax);
        }
        return resultDoctor;
    }

    private int getLocalMaxAsSpecialty(SpecialtyType specialtyType, Doctor doctor, int localMax) {
        if(doctor.getSpecialties().contains(specialtyType)){
            localMax = getLocalMaxFromOperation(doctor);
        }
        return localMax;
    }

    private Doctor getDoctorFromLocalMax(Doctor resultDoctor, Doctor doctor, int localMax) {
        if(localMax > maxSuccessfulOperation){
            maxSuccessfulOperation = localMax;
            resultDoctor = doctor;
        }
        return resultDoctor;
    }

    private int getLocalMaxFromOperation(Doctor doctor) {
        int localMax = 0;
        for(final IModel operation : doctor.getOperations()){
            if(((Operation)operation).isSucceed()){
                ++localMax;
            }else{
                localMax = 0;
            }
        }
        return localMax;
    }
}
