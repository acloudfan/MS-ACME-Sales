package com.acme.sales.model;

/**
 * Strategic Pattern: Value Object
 * Model: Acme Sales
 * Contains the information about the Customer entity along with validation for address & email
 */

public class ContactInformation {

    // Contact information
    public final String email;
    public final String phoneNumber;
    public final String addressLine1;
    public final String city;
    public final String state;
    public final String zipcode;

    private int validationResultCode = 0;
    private String  notValidReason;

    // Constructor
    public ContactInformation(String email, String phoneNumber, String addressLine1, String city, String state, String zipcode) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;

        try {
            validateInformation();
            // If no exception then the validation was successful
        } catch(Exception e) {
            notValidReason = e.getMessage();
        }
    }

    // Check if the information is valid
    public boolean isValid(){
        return (validationResultCode == 0);
    }

    // Validates the information provided by the customer
    public boolean validateInformation() throws Exception {
        validateEmailAddress();
        validatePhoneNumber();
        validateAddress();
        return true;
    }

    // Validate the email address
    public boolean validateEmailAddress() throws Exception{
        // Logic for email address validation e.g., use Regex
        // In case of invalid address -
        //      validationResultCode = 501
        //      throw new Exception("501: Email is not valid !!!")
        return true;
    }

    // Validate the phone number
    public boolean validatePhoneNumber() throws Exception {
        // Logic for phone validation
        // In case of invalid phone number -
        //      validationResultCode = 502
        //      throw new Exception("502: Phone number is not valid !!!")
        return true;
    }

    // Validate the address
    public boolean validateAddress() throws Exception {
        // Use a 3rd party service such as USPS, Pitney Bowes etc to validate the address
        // In case of invalid address -
        //      validationResultCode = 503
        //      throw new Exception("503: Address is not valid !!!")
        return true;
    }
}
