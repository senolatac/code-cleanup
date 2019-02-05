package com.sha.pattern;

import com.sha.model.Manager;

public class VisitorDesignPattern {

    public StringBuilder writeHierarchyOfHospital(Manager manager) {
        HospitalHierarchy hospitalHierarchy = new HospitalHierarchy();
        hospitalHierarchy.visit(manager);
        return hospitalHierarchy.builder();
    }
}
