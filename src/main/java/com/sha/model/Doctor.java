package com.sha.model;

import com.sha.pattern.IUnit;
import com.sha.pattern.IVisitor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Doctor extends Person implements IOccupation, IExperience, IUnit {

    private static final long serialVersionUID = 1L;

    private int version;

    private TitleType title;

    private int reputation;

    private Integer graduationYear;

    private Person boss;

    private Set<Person> members = new HashSet<>();

    private Set<SpecialtyType> specialties = new HashSet<>();

    private Set<IModel> operations = new HashSet<>();

    public Doctor(){
        super();
    }

    public Doctor(final String firstName, final String lastName){
        super(firstName, lastName);
    }

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public Set<IModel> getOperations() {
        return operations;
    }

    public void setOperations(Set<IModel> operations) {
        this.operations = operations;
    }

    public Person getBoss() {
        return boss;
    }

    public void setBoss(Doctor boss) {
        this.boss = boss;
    }

    public Set<Person> getMembers() {
        return members;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }

    @Override
    public String occupation() {
        return "DR.";
    }

    @Override
    public String currentTitle() {
        return title.toString();
    }

    @Override
    public Long yearOfExperience() {
        return ChronoUnit.YEARS.between(LocalDate.of(graduationYear, 1,1),LocalDate.now());
    }

    @Override
    public String profession() {
        return specialties.isEmpty() ? null : specialties.iterator().next().toString();
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void acceptMembers(IVisitor visitor) {
        List<Person> sortedList = new ArrayList<>(members);
        Collections.sort(sortedList);
        sortedList.forEach(member -> ((Doctor) member).accept(visitor));
    }

    @Override
    public int compareTo(Person o) {
        return this.getTitle().order().compareTo(((Doctor)o).getTitle().order());
    }
}
