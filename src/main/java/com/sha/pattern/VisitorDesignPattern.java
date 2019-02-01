package com.sha.pattern;

import com.sha.model.Doctor;
import com.sha.model.Manager;
import com.sha.model.TitleType;

public class VisitorDesignPattern {

    private static final String INDENT = "    ";
    private static final String NEW_LINE = "\n";
    StringBuilder builder;

    public StringBuilder writeHierarchyOfHospital(Manager manager) {
        builder = new StringBuilder();
        builder.append(manager.getFirstName() + " " + manager.getLastName());
        for (Doctor doctor : manager.getDoctors()) {
            if (TitleType.PROF.equals(doctor.getTitle())) {
                builder.append(NEW_LINE);
                writeHierarchyOfHospital(doctor, INDENT);
            }
        }
        for (Doctor doctor : manager.getDoctors()) {
            if (TitleType.ASSOC.equals(doctor.getTitle())) {
                builder.append(NEW_LINE);
                writeHierarchyOfHospital(doctor, INDENT);
            }
        }
        for (Doctor doctor : manager.getDoctors()) {
            if (TitleType.DR.equals(doctor.getTitle())) {
                builder.append(NEW_LINE);
                writeHierarchyOfHospital(doctor, INDENT);
            }
        }
        return builder;
    }

    private void writeHierarchyOfHospital(Doctor doctor, String preIndent) {
        builder.append(preIndent + doctor.getTitle().name() + " " + doctor.getFirstName() + " " + doctor.getLastName());
        for(Doctor d : doctor.getMembers()) {
            if (TitleType.PROF.equals(d.getTitle())) {
                builder.append(NEW_LINE);
                writeHierarchyOfHospital(d, preIndent + INDENT);
            }
        }
        for (Doctor d : doctor.getMembers()) {
            if (TitleType.ASSOC.equals(d.getTitle())) {
                builder.append(NEW_LINE);
                writeHierarchyOfHospital(d,preIndent + INDENT);
            }
        }
        for (Doctor d : doctor.getMembers()) {
            if (TitleType.DR.equals(d.getTitle())) {
                builder.append(NEW_LINE);
                writeHierarchyOfHospital(d,preIndent + INDENT);
            }
        }
    }
}
