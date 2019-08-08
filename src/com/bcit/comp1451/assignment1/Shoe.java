package com.bcit.comp1451.assignment1;


import java.awt.Color;

/**
 * This class models a shoe
 * @author Kasra
 * @version 1.0
 */
public class Shoe extends Item {
    private Material meterial;
    private int size;
    private Name designer;
    private ShoeType department;
    private Color color;

    /**
     *
     * @param weightKg weight of shoe in Kilograms
     * @param manufacturingPriceDollars the manufacture price of shoe in dollars
     * @param suggestedPriceDollars the suggested price of shoe in dollars
     * @param uniqueId the unique ID of the shoe
     * @param meterial the material of the shoe
     * @param size the size of the shoe
     * @param designer the designer of the shoe
     * @param color the color of the shoe
     * @param department the department of the shoe
     */
    public Shoe(double weightKg, double manufacturingPriceDollars, double suggestedPriceDollars, String uniqueId, Material meterial, int size, Name designer, Color color, ShoeType department) {
        super(weightKg, manufacturingPriceDollars, suggestedPriceDollars, uniqueId);
        this.setMeterial(meterial);
        this.setSize(size);
        this.setDesigner(designer);
        this.setShoeType(department);
        this.setColor(color);
    }

    /**
     *
     * @param meterial the material of the shoe
     */
    private void setMeterial(Material meterial) {
        this.meterial = meterial;
    }

    /**
     *
     * @param size the size of the shoe
     */
    private void setSize(int size) {
        this.size = size;
    }

    /**
     *
     * @param designer the designer of the shoe
     */
    private void setDesigner(Name designer) {
        this.designer = designer;
    }

    /**
     *
     * @param shoeTypeDepartment the department type of shoe is from
     */
    private void setShoeType(ShoeType shoeTypeDepartment) {
        this.department = shoeTypeDepartment;
    }

    /**
     *
     * @param color the color of the shoe
     */
    private void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return the material of the shoe
     */
    public Material getMeterial() {
        return this.meterial;
    }

    /**
     *
     * @return the size of the shoe
     */
    public int getSize() {
        return this.size;
    }

    /**
     *
     * @return the designer of the shoe
     */
    public Name getDesigner() {
        return this.designer;
    }

    /**
     *
     * @return the department type of shoe is from
     */
    public ShoeType getShoeType() {
        return this.department;
    }

    /**
     *
     * @return the color of the shoe
     */
    public Color getColor() {
        return this.color;
    }
}

