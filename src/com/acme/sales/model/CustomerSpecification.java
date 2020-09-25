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

    // Destination city - identified by the airport code
    private  final String destination;

    // Range of $ customer is willing to spend
    private  final double  minAmountSpend;
    private  final double  maxAmountSpend;

    // Number of nights
    private  final int     minNights;
    private  final int     maxNights;

    // Constructor
    // A null destination represents ANY destination
    public CustomerSpecification(String destination, double minAmountSpend, double maxAmountSpend, int minNights, int maxNights) {
        this.destination = destination;
        this.minAmountSpend = minAmountSpend;
        this.maxAmountSpend = maxAmountSpend;
        this.minNights = minNights;
        this.maxNights = maxNights;
    }

    public boolean isSatisfiedBy(VacationPackage  vacationPackage){

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
