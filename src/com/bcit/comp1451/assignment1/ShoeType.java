package com.bcit.comp1451.assignment1;

import java.util.HashMap;
import java.util.Map;

/**
 * This Enum models a shoe type
 * @author Kasra
 * @version 1.0
 */
public enum ShoeType {
    WOMEN("women"), MEN("men"), CHILDREN("children"), SPORTS("sports"),
    DRESS("dress");

    private String theShoeType;
    private static Map<String, ShoeType> lookup = new HashMap<>();

    static{
        for (ShoeType d : ShoeType.values()){
            lookup.put(d.getTheShoeType(), d);
        }
    }

    /**
     *
     * @param theShoeType shoe type
     */
    ShoeType(String theShoeType) {
        this.theShoeType = theShoeType;
    }

    /**
     *
     * @return the shoe type
     */
    public String getTheShoeType() {
        return this.theShoeType;
    }

    /**
     *
     * @param theShoeType the shoe type
     * @return the department
     */
    public static ShoeType get(String theShoeType) {
        return lookup.get(theShoeType);
    }
}
