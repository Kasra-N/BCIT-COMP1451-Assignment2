package com.bcit.comp1451.assignment1;

/**
 * This class models an item
 * @author Kasra
 * @version 1.0
 */

public class Item {
    private double weightKg;
    private double manufacturingPriceDollars;
    private double suggestedPriceDollars;
    private String uniqueId;

    /**
     *
     * @param weightKg weight in Kilograms
     * @param manufacturingPriceDollars manufacturer price in dollars
     * @param suggestedPriceDollars the suggested price of item in dollars
     * @param uniqueId unique identification of this item
     */
    public Item(double weightKg, double manufacturingPriceDollars, double suggestedPriceDollars, String uniqueId) {
        this.setWeightKg(weightKg);
        this.setManufacturingPriceDollars(manufacturingPriceDollars);
        this.setSuggestedPriceDollars(suggestedPriceDollars);
        this.setUniqueId(uniqueId);
    }

    /**
     *
     * @param weightKg weight in Kilograms
     */
    private void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    /**
     *
     * @param manufacturingPriceDollar manufacturer price in dollars
     */
    private void setManufacturingPriceDollars(double manufacturingPriceDollar) {
        this.manufacturingPriceDollars = manufacturingPriceDollar;
    }

    /**
     *
     * @param suggestedPriceDollars suggested price in dollars
     */
    private void setSuggestedPriceDollars(double suggestedPriceDollars) {
        this.suggestedPriceDollars = suggestedPriceDollars;
    }

    /**
     *
     * @param uniqueId unique identification of this item
     */
    private void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     *
     * @return weight in Kilograms
     */
    public double getWeightKg() {
        return this.weightKg;
    }

    /**
     *
     * @return manufacturer price in dollars
     */
    public double getManufacturingPriceDollars() {
        return this.manufacturingPriceDollars;
    }

    /**
     *
     * @return suggested price in dollars
     */
    public double getSuggestedPriceDollars() {
        return this.suggestedPriceDollars;
    }

    /**
     *
     * @return unique identification of this item
     */
    public String getUniqueId() {
        return this.uniqueId;
    }
}

