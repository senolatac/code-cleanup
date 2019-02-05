package com.sha.model;

import com.sha.pattern.IUnit;
import com.sha.pattern.IVisitor;

import java.util.*;

//like surgeon general
public class Manager extends Person implements  IOccupation, ILeaderShip, IUnit {
    private Set<Person> doctors = new HashSet<>();
    private Set<Person> patients = new HashSet<>();

    public Manager(){
        super();
    }

    public Manager(final String firstName, final String lastName){
        super(firstName, lastName);
    }

    public Set<Person> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Person> doctors) {
        this.doctors = doctors;
    }

    public Set<Person> getPatients() {
        return patients;
    }

    public void setPatients(Set<Person> patients) {
        this.patients = patients;
    }

    @Override
    public String occupation() {
        return "Manager";
    }

    @Override
    public String currentTitle() {
        return "Boss";
    }

    @Override
    public int numberOfMembers() {
        return doctors.size();
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void acceptMembers(IVisitor visitor) {
        List<Person> sortedList = new ArrayList<>(doctors);
        Collections.sort(sortedList);
        sortedList.forEach(member -> ((Doctor) member).accept(visitor));
    }
}
