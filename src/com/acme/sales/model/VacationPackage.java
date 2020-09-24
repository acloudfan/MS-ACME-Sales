package com.acme.sales.model;

import java.util.Date;

/**
 * Strategic Pattern: Entity
 * Model: Acme Sales
 * Represents a Vacation Product
 */
public class VacationPackage {
    // Unique Identity of the product
    // Think of this as a technical identity which does not have a meaning in business domain
    private int    id;

    // Name for the product - pseudo identity
    // Sales agent know the product by this
    private String name;

    // Friendly description
    private String description;

    // Number of nights
    private int   numberOfNights;

    // Vacation packages have  a type
    public  enum vacationPackageType {RESORT, CRUISE, HOTEL_AIR, HOTEL_AIR_CAR}

    // Type of the vacation package
    private vacationPackageType packageType;

    // Suggested retail price for the product
    private double retailPrice;

    // Date till this product can be purchased
    private Date   validTill;

    // Sometime the product needs to be marked unavailable
    private boolean active;

    // Indicates if the product is sold out
    private boolean soldOut;



    /**
     * Behavior
     **/

    /**
     * Check the availability
     * Takes the argument - number of persons
     **/
    public  boolean checkAvailability(int numPersons){
        return true;
    }


    /**
     * Getters & Setters
     **/
}
