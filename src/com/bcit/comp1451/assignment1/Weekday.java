package com.bcit.comp1451.assignment1;

import java.util.HashMap;
import java.util.Map;

/**
 * The seven names given to 24-hour periods in the Gregorian Calendar.
 *
 * @author James Pede
 * @version Jul12'14,1600h
 */
public enum Weekday
{
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String literal;

    private static Map<String, Weekday> lookup = new HashMap<String, Weekday>();

    static{
        for (Weekday w : Weekday.values()){
            lookup.put(w.toString(), w);
        }
    } // end class init

    /**
     *
     * @param literal the string literal that is used by Date
     */
    private Weekday(String literal) {
        this.literal = literal;
    } // end constructor

    /**
     *
     * @param searchTerm term searched
     * @return searched term
     */
    public static Weekday get(String searchTerm) {
        return lookup.get(searchTerm);
    } // end class method

    /**
     *
     * @return the string literal
     */
    public String toString() {
        return literal;
    } // end accessor
} // end class
