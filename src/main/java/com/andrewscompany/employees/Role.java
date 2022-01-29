package com.andrewscompany.employees;

public enum Role {
    PROGRAMMER("Programmer"),
    MANAGER("Manager"),
    ANALYST("Analyst"),
    CEO("CEO");

    private String reference;

    Role(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return this.reference;
    }
}
