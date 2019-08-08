package com.bcit.comp1451.assignment1;

import java.util.HashMap;
import java.util.Map;

/**
 * This Enum models a book type
 * @author Kasra
 * @version 1.0
 */
public enum BookType {
    FICTION("fiction"), NONFICTION("nonfiction"), SCIENCEFICTION("sciencefiction"),
    REFERENCE("reference");

    private String theBookType;
    private static Map<String, BookType> lookup = new HashMap<>();

    static{
        for (BookType b : BookType.values()){
            lookup.put(b.getTheBookType(), b);
        }
    }

    /**
     *
     * @param theBookType the type of book
     */
    BookType(String theBookType) {
        this.theBookType = theBookType;
    }

    /**
     *
     * @return the type of book
     */
    public String getTheBookType() {
        return theBookType;
    }

    /**
     *
     * @param theBookType the type of book
     * @return the type of book
     */
    public static BookType get(String theBookType) {
        return lookup.get(theBookType);
    }
}