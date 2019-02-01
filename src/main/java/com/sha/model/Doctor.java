package com.sha.model;

import java.util.HashSet;
import java.util.Set;

public class Doctor {

    private static final long serialVersionUID = 1L;

    private Long id;

    private int version;

    private TitleType title;

    private int reputation;

    private String firstName;

    private String lastName;

    private Integer graduationYear;

    private Doctor boss;

    private Set<Doctor> members = new HashSet<>();

    private Set<SpecialtyType> specialties = new HashSet<>();

    private Set<Operation> operations = new HashSet<>();

    public Set<SpecialtyType> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<SpecialtyType> specialties) {
        this.specialties = specialties;
    }

    public Integer getGraduationYear() {
        return this.graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TitleType getTitle() {
        return title;
    }

    public void setTitle(TitleType title) {
        this.title = title;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Doctor getBoss() {
        return boss;
    }

    public void setBoss(Doctor boss) {
        this.boss = boss;
    }

    public Set<Doctor> getMembers() {
        return members;
    }

    public void setMembers(Set<Doctor> members) {
        this.members = members;
    }
}
