package com.example.myfundamentalsapp;

public class Person {
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static int nrInstances = 0;
    private int nrInstance;

    Person() {
        ++nrInstances;
        nrInstance = nrInstances;
    }

    public String getFirstName() {
        return FIRST_NAME + " " + nrInstance;
    }

    public String getLastName() {
        return LAST_NAME + " " + nrInstance;
    }
}
