package com.sha.pattern;

import com.sha.model.Doctor;
import com.sha.model.Manager;

public interface IVisitor {

    void visit(final Manager manager);
    void visit(final Doctor doctor);
}
