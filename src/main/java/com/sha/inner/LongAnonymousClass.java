package com.sha.inner;

import com.sha.model.Doctor;
import com.sha.model.Patient;
import com.sha.model.SpecialtyType;
import com.sha.model.TitleType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LongAnonymousClass {

    private Patient patient;
    private Date operationDate;
    private SpecialtyType specialtyType;
    private List<Doctor> availableDoctors;
    private Assignee assignee;

    public void assignJob(){
        Surgery surgery = new Surgery();
        surgery.setDate(operationDate);
        surgery.setDone(false);
        surgery.setOperationType(specialtyType);
        surgery.setPatient(patient);
        EnumSurgery enumSurgery = getSurgeryTypeFromSpecialty();
        surgery.setRoom(enumSurgery.getRoom());
        Task task = new Task();
        task.setSurgery(surgery);
        task.setNeededAssoc(enumSurgery.getAssocCount());
        task.setNeededProf(enumSurgery.getProfCount());
        task.setNeededDr(enumSurgery.getDrCount());
        assignDoctors(enumSurgery);
        assignee.setTask(task);
        task.setTaskState(assignee.isAssignCompleted() ? TaskState.READY : TaskState.NOT_READY);
    }

    public String getNeededDoctors(){
        if(isJobReady()){
            return "No need anymore!";
        }
        StringBuilder builder = new StringBuilder();
        if(assignee.getTask().getNeededProf()>assignee.getAssignedProfCount()){
            builder.append(assignee.getTask().getNeededProf() - assignee.getAssignedProfCount() + "prof needed ");
        }
        if(assignee.getTask().getNeededAssoc()>assignee.getAssignedAssocCount()){
            builder.append(assignee.getTask().getNeededAssoc() - assignee.getAssignedAssocCount() + "assoc needed ");
        }
        if(assignee.getTask().getNeededDr()>assignee.getAssignedDrCount()){
            builder.append(assignee.getTask().getNeededDr() - assignee.getAssignedDrCount() + "dr needed ");
        }
        return builder.toString();
    }

    private void assignDoctors(EnumSurgery enumSurgery){
        assignee = new Assignee();
        int i = enumSurgery.getProfCount(), counter = 0;
        for(Doctor d : availableDoctors){
            if(i!=0 && TitleType.PROF.equals(d.getTitle())){
                assignee.getAssignedDoctors().add(d);
                ++counter;
            }
            if(counter == i){
                break;
            }
        }
        assignee.setAssignedProfCount(counter);
        i = enumSurgery.getAssocCount();
        counter = 0;
        for(Doctor d : availableDoctors){
            if(i!=0 && TitleType.ASSOC.equals(d.getTitle())){
                assignee.getAssignedDoctors().add(d);
                ++counter;
            }
            if(counter == i){
                break;
            }
        }
        assignee.setAssignedAssocCount(counter);
        i = enumSurgery.getDrCount();
        counter = 0;
        for(Doctor d : availableDoctors){
            if(i!=0 && TitleType.DR.equals(d.getTitle())){
                assignee.getAssignedDoctors().add(d);
                ++counter;
            }
            if(counter == i){
                break;
            }
        }
        assignee.setAssignedDrCount(counter);
    }

    private EnumSurgery getSurgeryTypeFromSpecialty(){
        return EnumSurgery.valueOf(specialtyType.name());
    }

    public boolean isJobReady(){
        return TaskState.READY.equals(assignee.getTask().getTaskState());
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public SpecialtyType getSpecialtyType() {
        return specialtyType;
    }

    public void setSpecialtyType(SpecialtyType specialtyType) {
        this.specialtyType = specialtyType;
    }

    public List<Doctor> getAvailableDoctors() {
        if(availableDoctors == null){
            return new ArrayList<>();
        }
        return availableDoctors;
    }

    public void setAvailableDoctors(List<Doctor> availableDoctors) {
        this.availableDoctors = availableDoctors;
    }

    private static class Assignee {
        private List<Doctor> assignedDoctors;
        private int assignedProfCount;
        private int assignedAssocCount;
        private int assignedDrCount;
        private Task task;

        public boolean isAssignCompleted(){
            return task.getNeededProf() == assignedProfCount && task.getNeededAssoc() == assignedAssocCount
                    && task.getNeededDr() == assignedDrCount;
        }

        public List<Doctor> getAssignedDoctors() {
            if(assignedDoctors == null){
                return new ArrayList<>();
            }
            return assignedDoctors;
        }

        public void setAssignedDoctors(List<Doctor> assignedDoctors) {
            this.assignedDoctors = assignedDoctors;
        }

        public Task getTask() {
            return task;
        }

        public void setTask(Task task) {
            this.task = task;
        }

        public int getAssignedProfCount() {
            return assignedProfCount;
        }

        public void setAssignedProfCount(int assignedProfCount) {
            this.assignedProfCount = assignedProfCount;
        }

        public int getAssignedAssocCount() {
            return assignedAssocCount;
        }

        public void setAssignedAssocCount(int assignedAssocCount) {
            this.assignedAssocCount = assignedAssocCount;
        }

        public int getAssignedDrCount() {
            return assignedDrCount;
        }

        public void setAssignedDrCount(int assignedDrCount) {
            this.assignedDrCount = assignedDrCount;
        }
    }

    private static enum EnumSurgery {
        LIVER("101", 1, 1, 1),
        HEART("102", 2, 0, 2),
        EYE("103", 1, 1, 3),
        EAR("104",0, 1, 1),
        BRAIN("105",2 ,2 ,2 );

        private String room;
        private int profCount;
        private int assocCount;
        private int drCount;

        EnumSurgery(String room, int profCount, int assocCount, int drCount){
            this.room = room;
            this.profCount = profCount;
            this.assocCount = assocCount;
            this.drCount = drCount;
        }

        public String getRoom() {
            return room;
        }

        public int getProfCount() {
            return profCount;
        }

        public int getAssocCount() {
            return assocCount;
        }

        public int getDrCount() {
            return drCount;
        }
    }

    private static enum TaskState {
        NOT_READY,
        READY,
        DONE,
        TERMINATED;
    }

    private static class Task {
        private Surgery surgery;
        private int neededProf;
        private int neededAssoc;
        private int neededDr;
        private TaskState taskState;

        public Surgery getSurgery() {
            return surgery;
        }

        public void setSurgery(Surgery surgery) {
            this.surgery = surgery;
        }

        public int getNeededProf() {
            return neededProf;
        }

        public void setNeededProf(int neededProf) {
            this.neededProf = neededProf;
        }

        public int getNeededAssoc() {
            return neededAssoc;
        }

        public void setNeededAssoc(int neededAssoc) {
            this.neededAssoc = neededAssoc;
        }

        public int getNeededDr() {
            return neededDr;
        }

        public void setNeededDr(int neededDr) {
            this.neededDr = neededDr;
        }

        public TaskState getTaskState() {
            return taskState;
        }

        public void setTaskState(TaskState taskState) {
            this.taskState = taskState;
        }
    }

    private static class Surgery{
        private Patient patient;
        private SpecialtyType operationType;
        private String room;
        private Date date;
        private boolean done;

        public Patient getPatient() {
            return patient;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public SpecialtyType getOperationType() {
            return operationType;
        }

        public void setOperationType(SpecialtyType operationType) {
            this.operationType = operationType;
        }
    }
}
