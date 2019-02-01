package com.sha.inner;

import com.sha.model.Doctor;
import com.sha.model.Patient;
import com.sha.model.SpecialtyType;
import com.sha.model.TitleType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LongAnonymousClassTest {

    private LongAnonymousClass longAnonymousClass;

    @Before
    public void setUp(){
        longAnonymousClass = new LongAnonymousClass();
    }

    @Test
    public void assignmentShouldBeSucceed(){
        longAnonymousClass.setOperationDate(new Date());
        longAnonymousClass.setPatient(createPatient(0));
        longAnonymousClass.setSpecialtyType(SpecialtyType.EYE);
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(createDoctor(TitleType.PROF, "0"));
        doctors.add(createDoctor(TitleType.ASSOC, "1"));
        doctors.add(createDoctor(TitleType.DR, "2"));
        doctors.add(createDoctor(TitleType.DR, "3"));
        doctors.add(createDoctor(TitleType.DR, "4"));
        longAnonymousClass.setAvailableDoctors(doctors);

        longAnonymousClass.assignJob();
        String actual = longAnonymousClass.getNeededDoctors();

        Assert.assertEquals("No need anymore!", actual);
    }

    private Doctor createDoctor(TitleType type, String pre) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(pre + " Doctor");
        doctor.setLastName("Last");
        doctor.setGraduationYear(2005);
        doctor.setTitle(type);
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
