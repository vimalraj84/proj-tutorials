package com.bilqu.bo.emp;


// A functional interface is an interface that contains only one abstract method.
// They can have only one functionality to exhibit.
// From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface.
// A functional interface can have any number of default methods.
// Runnable, ActionListener, Comparable are some of the examples of functional interfaces.

// @FunctionalInterface annotation is used to ensure that the functional interface can’t have more than one abstract method.
// In case more than one abstract methods are present, the compiler flags an ‘Unexpected @FunctionalInterface annotation’ message.
// However, it is not mandatory to use this annotation.

@FunctionalInterface
public interface Name {
    public String getFullName();
    default void pringName(String fName, String lName,String mName){
        System.out.println(fName+""+mName+""+lName);
    }
}
