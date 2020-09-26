package com.acme.sales.model;

/**
 * Pattern: Specification
 * Checks if the VacationPackage meets certain criteria.
 * Vacation package MUST meet the customer specification
 *
 * Reference: https://www.martinfowler.com/apsupp/spec.pdf
 *
 */
public class CustomerSpecification {

    private final String  vacationPackageName;
    // Destination city - identified by the airport code
    private  final String destination;

    // Range of $ customer is willing to spend
    private  final double  minAmountSpend;
    private  final double  maxAmountSpend;

    // Number of nights
    private  final int     minNights;
    private  final int     maxNights;

    public CustomerSpecification(String vacationPackageName){
        this.vacationPackageName=vacationPackageName;
        destination=null;
        minAmountSpend=0; maxAmountSpend=0;
        minNights=0; maxNights=0;
    }

    // Constructor
    // Identify vacation package by Name
    //    - if name is null then  that means any
    //    - If name not null then all other criteria are ignored
    //
    // A null destination represents ANY destination
    public CustomerSpecification(String vacationPackageName, String destination, double minAmountSpend, double maxAmountSpend, int minNights, int maxNights) {
        this.vacationPackageName = vacationPackageName;
        this.destination = destination;
        this.minAmountSpend = minAmountSpend;
        this.maxAmountSpend = maxAmountSpend;
        this.minNights = minNights;
        this.maxNights = maxNights;
    }

    public boolean isSatisfiedBy(VacationPackage  vacationPackage){

        // Remember each package has a unique name -- so if the package is found then we do not need to check further
        if(this.vacationPackageName != null && this.vacationPackageName.equalsIgnoreCase(vacationPackage.getName())){
            return true;
        }

        // Check destination match
        // A null destination means ANY destination
        if(!(this.destination != null && this.destination.equalsIgnoreCase(vacationPackage.getDestination()))){
            return false;
        }

        /* Check spend range */
        if(this.maxAmountSpend < vacationPackage.getRetailPrice() ||
                this.minAmountSpend > vacationPackage.getRetailPrice()  ){
            return false;
        }

        /* Check number of nights */
        if(this.maxNights < vacationPackage.getNumberOfNights()||
                this.minNights > vacationPackage.getNumberOfNights() ){
            return false;
        }

        return true;
    }
}
