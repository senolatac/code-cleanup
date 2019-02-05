package com.sha.pattern;

public interface IUnit {

    void accept(IVisitor visitor);
    void acceptMembers(IVisitor visitor);
}
