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

    // This is the destination city
    // In case of cruise it is the port of origin
    private String destination;


    /**
     * Getters & Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public vacationPackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(vacationPackageType packageType) {
        this.packageType = packageType;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
