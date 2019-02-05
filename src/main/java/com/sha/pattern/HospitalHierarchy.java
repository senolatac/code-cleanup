package com.sha.pattern;

import com.sha.model.Doctor;
import com.sha.model.Manager;

public class HospitalHierarchy implements IVisitor {
    private StringBuilder builder;
    private int indentCount = 0;
    private String indent = "";
    private static final String NEW_LINE = "\n";

    public HospitalHierarchy(){
        builder = new StringBuilder();
    }

    @Override
    public void visit(Manager manager) {
        _indent();
        indentCount+=4;
        builder.append(manager.getFirstName() + " " + manager.getLastName());
        manager.acceptMembers(this);
        indentCount-=4;
    }

    @Override
    public void visit(Doctor doctor) {
        _indent();
        indentCount+=4;
        builder.append(NEW_LINE);
        builder.append(indent + doctor.getTitle().name() + " " + doctor.getFirstName() + " " + doctor.getLastName());
        doctor.acceptMembers(this);
        indentCount-=4;
    }

    public StringBuilder builder(){
        return builder;
    }

    private void _indent(){
        indent = "";
        for(int i=0; i<indentCount; i++){
            indent+=" ";
        }
    }
}
