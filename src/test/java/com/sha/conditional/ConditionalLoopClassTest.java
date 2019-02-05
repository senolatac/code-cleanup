package com.sha.conditional;

import com.sha.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ConditionalLoopClassTest {

    private ConditionalLoopClass conditionalLoopClass;

    @Before
    public void setUp() {
        conditionalLoopClass = new ConditionalLoopClass();
    }

    @Test
    public void bestDoctorShouldReturn() {
        List<Doctor> doctorList = new ArrayList<>();
        TitleType[] titleTypes = TitleType.values();
        SpecialtyType[] specialtyTypes = SpecialtyType.values();
        for (int i = 0; i < 30; i++) {
            doctorList.add(createDoctor(titleTypes[i % titleTypes.length], 100, specialtyTypes[i % specialtyTypes.length], i));
        }
        Doctor doctor = conditionalLoopClass.findMostTrustedDoctor(doctorList, SpecialtyType.HEART, TitleType.DR);
        Assert.assertEquals("Test Doctor 21" , doctor.getFirstName());
    }

    private Doctor createDoctor(TitleType type, int reputation, SpecialtyType specialtyType, int count) {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Test Doctor " + count);
        doctor.setLastName("Last");
        doctor.setGraduationYear(2005);
        doctor.setReputation(reputation);
        doctor.setTitle(type);
        doctor.setSpecialties(EnumSet.of(specialtyType));
        doctor.setOperations(createOperation(count));
        return doctor;
    }

    private Set<IModel> createOperation(int count) {
        Set<IModel> operations = new HashSet<>();
        for (int i = 0; i < count; i++) {
            Operation operation = new Operation();
            operation.setSucceed(count%6==0?false:true);
            operation.setOperationDate(new Date());
            operations.add(operation);
        }
        return operations;
    }
}
