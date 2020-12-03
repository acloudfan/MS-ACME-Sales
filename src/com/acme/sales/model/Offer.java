package com.acme.sales.model;

import java.util.Date;

/**
 * Strategic Pattern: Value Object
 * Model: Acme Sales
 * Represents a discount offer that is applied to the Vacation Product
 */

public class Offer {

    // Some kind of reference code - Not an identity
    public final String reference;

    // Represents Percentage between 0 & 100
    public final int discount;

    // Description of the discount
    public final String description;

    // Valid Till this date
    public final Date validTill;

    /** Constructor **/
    public Offer(String reference, int discount, String description, Date validTill) {
        this.reference = reference;
        this.discount = discount;
        this.description = description;
        this.validTill = validTill;
    }

}