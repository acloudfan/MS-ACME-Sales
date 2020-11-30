package com.acme.sales.model;

/**
 * Strategic Pattern: Entity
 * Model: Acme Sales
 * Represents a Customer
 */

public class Customer {

    // Customer identified uniquely by an email address
    public String email;

    // This is an alternate way to identify the customer
    public String phoneNumber;

    // Address
    public final String addressLine1;
    public final String city;
    public final String state;
    public final String zipcode;
    public final boolean contactInformationValidated;

    // Name
    public final String fName;
    public final String mName;
    public final String lName;

    /**
     * Constructor - first time creation of the object would require the contact information to be validated
     */
    public Customer(String fName, String mName, String lName, ContactInformation ci) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;

        contactInformationValidated = ci.isValid();

        this.addressLine1 = ci.addressLine1;
        this.city=ci.city;
        this.zipcode=ci.zipcode;
        this.state=ci.state;
        this.phoneNumber=ci.phoneNumber;
        this.email=ci.email;
    }

    /**
     * Constructor
     */
    public Customer(String fName, String mName, String lName, String email, String phoneNumber, String addressLine1, String city, String state, String zipcode, boolean contactInformationValidated) {

        this.fName = fName;
        this.mName = mName;
        this.lName = lName;

        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;

        this.contactInformationValidated = contactInformationValidated;
    }
}
