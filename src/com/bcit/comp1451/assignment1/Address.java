package com.bcit.comp1451.assignment1;

/**
 * This class models address
 * @author Kasra
 * @version 1.0
 */

public class Address {
    private String streetNumber;
    private String streetName;
    private String city;
    private String postalCode;

    /**
     *
     * @param streetNumber the street number
     * @param streetName he street name
     * @param city the city
     * @param postalCode the postal code
     */
    public Address(String streetNumber, String streetName, String city, String postalCode) {
        this.setStreetNumber(streetNumber);
        this.setStreetName(streetName);
        this.setCity(city);
        this.setPostalCode(postalCode);
    }

    /**
     *
     * @param streetNumber the street number
     */
    private void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     *
     * @param streetName the street name
     */
    private void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     *
     * @param city the city
     */
    private void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @param postalCode the postal code
     */
    private void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return the street name
     */
    public String getStreetNumber() {
        return this.streetNumber;
    }

    /**
     *
     * @return the street name
     */
    public String getStreetName() {
        return this.streetName;
    }

    /**
     *
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return this.postalCode;
    }
}