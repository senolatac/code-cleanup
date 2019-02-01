package com.sha.pattern;

import com.sha.model.Doctor;
import com.sha.model.Manager;
import com.sha.model.SpecialtyType;
import com.sha.model.TitleType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class VisitorDesignPatternTest {

    private VisitorDesignPattern visitorDesignPattern;

    @Before
    public void setUp(){
        visitorDesignPattern = new VisitorDesignPattern();
    }

    @Test
    public void hierarchyShouldBeDisplayed(){
        Manager manager = createManager();

        String actual = visitorDesignPattern.writeHierarchyOfHospital(manager).toString();
        String expected = "Test Manager Last\n" +
                "    PROF 0 Doctor Last\n" +
                "        PROF 00 Doctor Last\n" +
                "            ASSOC 000 Doctor Last\n" +
                "                DR 0000 Doctor Last\n" +
                "        ASSOC 01 Doctor Last\n" +
                "        DR 02 Doctor Last\n" +
                "    PROF 3 Doctor Last\n" +
                "    ASSOC 1 Doctor Last\n" +
                "    DR 2 Doctor Last";

        Assert.assertEquals(expected, actual);
    }

    private Manager createManager(){
        Manager manager = new Manager();
        manager.setFirstName("Test Manager");
        manager.setLastName("Last");
        Doctor doctor_0 = createDoctor(TitleType.PROF, "0");
        Doctor doctor_0_0 = createDoctor(TitleType.PROF, "00");
        Doctor doctor_0_0_0 = createDoctor(TitleType.ASSOC, "000");
        Doctor doctor_0_0_0_0 = createDoctor(TitleType.DR, "0000");
        Set<Doctor> members_0_0_0 = new HashSet<>();
        members_0_0_0.add(doctor_0_0_0_0);
        doctor_0_0_0.setMembers(members_0_0_0);
        Set<Doctor> members_0_0 = new HashSet<>();
        members_0_0.add(doctor_0_0_0);
        doctor_0_0.setMembers(members_0_0);
        Doctor doctor_0_1 = createDoctor(TitleType.ASSOC, "01");
        Doctor doctor_0_2 = createDoctor(TitleType.DR, "02");
        Set<Doctor> members_0 = new HashSet<>();
        members_0.add(doctor_0_0);
        members_0.add(doctor_0_1);
        members_0.add(doctor_0_2);
        doctor_0.setMembers(members_0);
        Doctor doctor_1 = createDoctor(TitleType.ASSOC, "1");
        Doctor doctor_2 = createDoctor(TitleType.DR, "2");
        Doctor doctor_3 = createDoctor(TitleType.PROF, "3");
        Set<Doctor> members = new HashSet<>();
        members.add(doctor_0);
        members.add(doctor_1);
        members.add(doctor_2);
        members.add(doctor_3);
        manager.setDoctors(members);
        return manager;
    }

    private Doctor createDoctor(TitleType type, String pre) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(pre + " Doctor");
        doctor.setLastName("Last");
        doctor.setGraduationYear(2005);
        doctor.setTitle(type);
        return doctor;
    }
}
