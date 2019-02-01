package com.sha.conditional;

import com.sha.model.Doctor;
import com.sha.model.Patient;
import com.sha.model.SpecialtyType;
import com.sha.model.TitleType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class ConditionalNestedClassTest {

    private ConditionalNestedClass conditionalNestedClass;

    @Before
    public void setUp(){
        conditionalNestedClass = new ConditionalNestedClass();
    }

    @Test
    public void testNestedMethodForDr(){
        Doctor doctor = createDoctor(TitleType.DR, 100);
        Patient patient = createPatient(1);

        double value = conditionalNestedClass.nestedMethod(doctor, patient);

        Assert.assertEquals(101, value, 1);
    }

    @Test
    public void testNestedMethodForAssoc(){
        Doctor doctor = createDoctor(TitleType.ASSOC, 200);
        Patient patient = createPatient(3);

        double value = conditionalNestedClass.nestedMethod(doctor, patient);

        Assert.assertEquals(150, value, 1);
    }

    @Test
    public void testNestedMethodForProf(){
        Doctor doctor = createDoctor(TitleType.PROF, 200);
        Patient patient = createPatient(3);

        double value = conditionalNestedClass.nestedMethod(doctor, patient);

        Assert.assertEquals(200, value, 1);
    }

    @Test
    public void testNestedMethodForProfLittleReputation(){
        Doctor doctor = createDoctor(TitleType.PROF, 501);
        Patient patient = createPatient(11);

        double value = conditionalNestedClass.nestedMethod(doctor, patient);

        Assert.assertEquals(270, value, 1);
    }

    @Test
    public void testNestedMethodForProfHighReputation(){
        Doctor doctor = createDoctor(TitleType.PROF, 1001);
        Patient patient = createPatient(6);

        double value = conditionalNestedClass.nestedMethod(doctor, patient);

        Assert.assertEquals(380, value, 1);
    }

    private Doctor createDoctor(TitleType type, int reputation){
        Doctor doctor = new Doctor();
        doctor.setFirstName("Test Doctor");
        doctor.setLastName("Last");
        doctor.setGraduationYear(2005);
        doctor.setReputation(reputation);
        doctor.setTitle(type);
        doctor.setSpecialties(EnumSet.of(SpecialtyType.EYE));
        return doctor;
    }

    private Patient createPatient(int operationCount){
        Patient patient = new Patient();
        patient.setFirstName("Patient Name");
        patient.setLastName("Last Patient");
        patient.setEmail("patient@xmail.com");
        patient.setOperationCount(operationCount);
        return patient;
    }

}
