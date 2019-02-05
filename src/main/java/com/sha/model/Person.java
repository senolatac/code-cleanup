package com.sha.model;

public abstract class Person extends BaseModel implements IPerson, IResume, Comparable<Person> {

    private String firstName;

    private String lastName;

    private String genre;

    public Person(){
    }

    public Person(final String firstName, final String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
