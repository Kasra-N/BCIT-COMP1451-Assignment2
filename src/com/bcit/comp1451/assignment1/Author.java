package com.bcit.comp1451.assignment1;

/**
 * This class models the Author
 */

public class Author {
    private Date birthDate;
    private Name name;
    private BookType genre;
    private String pseudonym;

    /**
     *
     * @param birthDate the birth date of the author
     * @param name the name of the author
     * @param genre the genre author writes
     * @param pseudonym the pseudonym of the author
     */
    public Author(Date birthDate, Name name, BookType genre, String pseudonym) {
        this.setBirthDate(birthDate);
        this.setName(name);
        this.setGenre(genre);
        this.setPseudonym(pseudonym);
    }

    /**
     *
     * @param birthDate the birth date of the author
     * @param name the name of the author
     * @param genre the genre author writes
     */
    public Author(Date birthDate, Name name, BookType genre) {
        this.setBirthDate(birthDate);
        this.setName(name);
        this.setGenre(genre);
    }

    /**
     *
     * @param birthDate the birth date of the author
     */
    private void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @param name the name of the author
     */
    private void setName(Name name) {
        this.name = name;
    }

    /**
     *
     * @param genre the genre author writes
     */
    private void setGenre(BookType genre) {
        this.genre = genre;
    }

    /**
     *
     * @param pseudonym the pseudonym of the author
     */
    private void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    /**
     *
     * @return the birth date of the author
     */
    public Date getBirthDate() {
        return this.birthDate;
    }

    /**
     *
     * @return the name of the author
     */
    public Name getName() {
        return this.name;
    }

    /**
     *
     * @return the genre author writes
     */
    public BookType getGenre() {
        return this.genre;
    }

    /**
     *
     * @return the pseudonym of the author
     */
    public String getPseudonym() {
        return this.pseudonym;
    }
}
