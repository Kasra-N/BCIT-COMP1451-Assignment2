package com.bcit.comp1451.assignment1;

/**
 * This class models a name
 * @author Kasra
 * @version 1.0
 */
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    /**
     *
     * @param name the name with only first name
     */
    public Name(String name) {
        this.setFirstName(name);
    }

    /**
     *
     * @param firstName first name
     * @param lastName last name
     */
    public Name(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    /**
     *
     * @param firstName first name
     * @param middleName middle name
     * @param lastName last name
     */
    public Name(String firstName, String middleName, String lastName) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
    }

    /**
     *
     * @param firstName first name
     */
    private void setFirstName(String firstName) {
        if (!(firstName == null) && !firstName.isEmpty()) {
            this.firstName = firstName;
        }
    }

    /**
     *
     * @param middleName the middle name
     */
    private void setMiddleName(String middleName) {
        if (!(middleName == null) && !middleName.isEmpty()) {
            this.middleName = middleName;
        }
    }

    /**
     *
     * @param lastName the last name
     */
    private void setLastName(String lastName) {
        if (!(lastName == null) && !lastName.isEmpty()) {
            this.lastName = lastName;
        }
    }

    /**
     *
     * @return the full name
     */
    public String getFullName() {
        String fullName = null;

        if (this.firstName != null && this.middleName != null && this.lastName != null) {
            fullName = String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
        }

        if (this.firstName != null && this.lastName != null) {
            fullName = String.format("%s %s", this.firstName, this.lastName);
        }
        if (this.middleName == null && this.lastName == null) {
            fullName = this.firstName;
        }

        if (this.middleName == null && this.firstName == null) {
            fullName = this.lastName;
        }

        if (this.firstName == null && this.lastName == null) {
            fullName = this.middleName;
        }

        return fullName;
    }

    /**
     *
     * @return the first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return this.middleName;
    }

    /**
     *
     * @return the last name
     */
    public String getLastName() {
        return this.lastName;
    }
}
