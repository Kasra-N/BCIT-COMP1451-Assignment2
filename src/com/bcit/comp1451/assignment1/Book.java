package com.bcit.comp1451.assignment1;

/**
 * This class models a Book
 * @author Kasra
 * @version 1.0
 */

public class Book extends Item {
    private Author author;
    private Date datePublished;
    private String title;
    private BookType genre;

    /**
     *
     * @param weightKg the weight of book in Kilograms
     * @param manufacturingPriceDollars the price of the book by manufacturer
     * @param suggestedPriceDollars the suggested price
     * @param uniqueId the unique ID of this book
     * @param author the author of this book
     * @param datePublished the date published of this book
     * @param title the title of this book
     * @param genre the genre of this book
     */
    public Book(double weightKg, double manufacturingPriceDollars, double suggestedPriceDollars, String uniqueId, Author author, Date datePublished, String title, BookType genre) {
        super(weightKg, manufacturingPriceDollars, suggestedPriceDollars, uniqueId);
        this.setAuthor(author);
        this.setDatePublished(datePublished);
        this.setTitle(title);
        this.setGenre(genre);
    }

    /**
     *
     * @param author the author of this book
     */
    private void setAuthor(Author author) {
        this.author = author;
    }

    /**
     *
     * @param datePublished the date published of this book
     */
    private void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    /**
     *
     * @param title the title of this book
     */
    private void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param genre the genre of this book
     */
    private void setGenre(BookType genre) {
        this.genre = genre;
    }

    /**
     *
     * @return the year book was published
     */
    public int getYearPublished() {
        return this.datePublished.getYear();
    }

    /**
     *
     * @return the full name of author of this book
     */
    public String getAuthorFullName() {
        return this.author.getName().getFullName();
    }

    /**
     *
     * @return genre of this book
     */
    public String getGenreString() {
        return this.genre.getTheBookType();
    }

    /**
     *
     * @return the author of this book
     */
    public Author getAuthor() {
        return this.author;
    }

    /**
     *
     * @return the date of publication of this book
     */
    public Date getDatePublished() {
        return this.datePublished;
    }

    /**
     *
     * @return the title of this book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @return the genre of this book
     */
    public BookType getGenre() {
        return this.genre;
    }
}
