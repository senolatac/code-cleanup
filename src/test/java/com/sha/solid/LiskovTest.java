package com.sha.solid;

import com.sha.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LiskovTest {

    @Test
    public void testLiskovPrinciple(){
        Doctor doctor = new Doctor("TD", "LD");
        Manager manager = new Manager("TM", "LM");
        Patient patient = new Patient("TP", "LP");

        List<Person> personList = new ArrayList<>();
        personList.add(doctor);
        personList.add(manager);
        personList.add(patient);

        Assert.assertEquals(3, personList.size());
    }
}
