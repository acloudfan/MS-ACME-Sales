package com.acme.sales.model;

/**
 * Strategic Pattern: Entity
 * Model: Acme Sales
 * Represents a Customer
 */

public class Customer {

    // Customer identified by either of these
    public String phoneNumber;
    public String email;

    // Name
    public final String fName;
    public final String mName;
    public final String lName;

    /**
     * Constructor
     */
    public Customer(String fName, String mName, String lName) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
    }
}
