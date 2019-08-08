package com.bcit.comp1451.assignment1;

import java.util.Collection;
import java.util.Iterator;

/**
 * This class models a book store
 * @author Kasra
 * @version 1.0
 */

public class BookStore extends Store {
    private Collection<Book> books;
    private BookType specialty;

    /**
     * Constructor for BookStore
     * @param address the address of the bookstore
     * @param name the name of the bookstore
     * @param specialty the specialty
     */
    public BookStore(Address address, String name, BookType specialty) {
        super(address, name);
        this.specialty = specialty;
        addBooks();
    }

    /**
     * Overloaded Constructor for BookStore
     * @param address the address of the bookstore
     * @param name the name of the bookstore
     * @param specialty the String specialty
     */
    public BookStore(Address address, String name, String specialty){
        super(address, name);
        this.specialty = BookType.get(specialty);
        addBooks();
    }
    /**
     * method to add the books in the inventory
     */
    private void addBooks() {
        Date birthDate = new Date(1919, 1, 1);
        Name name = new Name("Jerome", "David", "Salinger");
        BookType genre = BookType.get("fiction");
        Author author = new Author(birthDate, name, genre, "JD");
        Date datePublished = new Date(1951, 5, 14);
        String title = "The Catcher in the Rye";
        Book b = new Book(0.4, 2.0, 4.0, "1234", author,
                datePublished, title, genre);
        addItem(b);

        datePublished = new Date(1948, 1, 31);
        title = "A Perfect Day for Bananafish";
        genre = BookType.get("fiction");
        b = new Book(1, 11, 12, "2345", author,
                datePublished, title, genre);
        addItem(b);

        datePublished = new Date(1945, 12, 12);
        title = "A Boy in France";
        genre = BookType.get("fiction");
        b = new Book(2, 33, 35, "3456", author,
                datePublished, title, genre);
        addItem(b);

        birthDate = new Date(1963, 9, 3);
        name = new Name("Malcolm", "Gladwell");
        genre = BookType.get("nonfiction");
        author = new Author(birthDate, name, genre) ;
        datePublished = new Date(2008, 11, 18);
        title = "Outliers";
        b = new Book(2.1, 2, 6, "4567", author,
                datePublished, title, genre);
        addItem(b);

        datePublished = new Date(2000, 3, 1);
        title = "The Tipping Point";
        genre = BookType.get("nonfiction");
        b = new Book(0.5, 3, 5, "5678", author,
                datePublished, title, genre);
        addItem(b);

        birthDate = new Date(1919, 11, 26);
        name = new Name("Frederik", "Pohl");
        genre = BookType.get("sciencefiction");
        author = new Author(birthDate, name, genre, "Paul Dennis Lavond") ;
        datePublished = new Date(1977, 7, 4);
        title = "Gateway";
        b = new Book(0.01, 4, 4, "6789", author,
                datePublished, title, genre);
        addItem(b);

        datePublished = new Date(1937, 10, 6);
        title = "Elegy to a Dead Planet: Luna";
        genre = BookType.get("sciencefiction");
        b = new Book(0.1, 5, 11, "abcd", author,
                datePublished, title, genre);
        addItem(b);

        birthDate = new Date(1918, 5, 11);
        name = new Name("Richard", "Phillips", "Feynman");
        genre = BookType.get("reference");
        author = new Author(birthDate, name, genre) ;
        datePublished = new Date(1942, 5, 20);
        title = "Principle of Least Action in Quantum Mechanics";
        b = new Book(0.8, 15, 30, "efgh", author,
                datePublished, title, genre);
        addItem(b);

        datePublished = new Date(1964, 6, 30);
        title = "The Messenger Lectures";
        genre = BookType.get("reference");
        b = new Book(0.6, 44, 45.5, "ijkl", author,
                datePublished, title, genre);
        addItem(b);

        datePublished = new Date(1985, 11, 1);
        title = "Surely You're Joking Mr. Feynman";
        genre = BookType.get("nonfiction");
        b = new Book(1.0, 3, 13, "mnop", author,
                datePublished, title, genre);
        addItem(b);
    }

    /**
     * display all the books by every author
     */
    public void displayAllBooksByEveryAuthor() {
        for(Book b: books) {
            System.out.println(String.format("%s wrote %s in %d",
                    b.getAuthor().getName().getLastName(),b.getTitle(), b.getDatePublished().getYear()));
        }
    }

    /**
     * display all the books by author's last name entered
     * @param lastName last name entered
     */
    public void displayAllBooksByAuthor(String lastName) {
        if (lastName == null) {
            System.out.println("Wrong last name");
        }

        for(Book b: books) {
            if (b.getAuthor().getName() != null && b.getAuthor().getName().getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(String.format("%s wrote %s", b.getAuthor().getName().getLastName(), b.getTitle()));
            }
        }
    }

    /**
     * display all the books written before year entered
     * @param year year entered
     */
    public void displayAllBooksWrittenBefore(int year) {
        if (year < 0) {
            System.out.println("Wrong year");
        }

        for(Book b: books) {
            if (b.getDatePublished().getYear() < year) {
                System.out.println(String.format("%s was published in %d, which is before %d",
                        b.getTitle(), b.getDatePublished().getYear(),year));
            }
        }
    }

    /**
     * display title of the books written by the pseudonym entered
     * @param pseudonym pseudonym entered
     */
    public void displayTitlesOfBooksWrittenBy(String pseudonym) {
        if (pseudonym == null) {
            System.out.println("Wrong pseudonym");
        }

        for(Book b: books) {
            if (b.getAuthor().getPseudonym() != null && b.getAuthor().getPseudonym().equalsIgnoreCase(pseudonym)) {
                System.out.println(String.format("%s wrote %s as %s",
                        b.getAuthor().getName().getLastName(), b.getTitle() ,b.getAuthor().getPseudonym()));
            }
        }
    }

    /**
     * display all the books in the genre entered
     * @param genre genre entered
     */
    public void displayAllBooksForGenre(String genre) {
        if (genre == null) {
            System.out.println("Wrong genre");
        }

        for(Book b: books) {
            if (b.getGenreString() != null && b.getGenreString().equalsIgnoreCase(genre)) {
                System.out.println(String.format("%s is a %s book written by %s",
                        b.getTitle(), b.getGenre().toString().toLowerCase(), b.getAuthor().getName().getLastName()));
            }
        }
    }

    /**
     * display the total weight of all the books in Kilograms
     */
    public void displayTotalWeightKgOfAllBooks() {
        double totalWeight = 0.0;

        for(Book b: books) {
            totalWeight += b.getWeightKg();
        }
        System.out.println("total kg of books: " + totalWeight);
    }

    /**
     * display all the books written by authors over the age entered
     * @param ageInYears age entered
     */
    public void displayAllBooksWrittenByAuthorsOverThisAge(int ageInYears){
        boolean match = false;

        for(Book b: books) {
            int ageYears = b.getDatePublished().getYear() - b.getAuthor().getBirthDate().getYear();

            if(ageYears > ageInYears){
                System.out.println(String.format("%s was written by %s at age %d, which is more than %d",
                        b.getTitle(), b.getAuthor().getName().getLastName(), ageYears, ageInYears));
                match = true;
            }
        }
        if(!match){
            System.out.println("No books by authors over age " + ageInYears);
        }
    }

    /**
     * display all the books written by author born on day of the week entered
     * @param dayOfTheWeek day of the week entered
     */
    public void displayAllBooksWrittenByAuthorsBornOn(String dayOfTheWeek) {
        boolean match = false;

        if (dayOfTheWeek == null) {
            System.out.println("Wrong day");
        }

        for(Book b: books) {
            String day = b.getAuthor().getBirthDate().getDayOfTheWeek();

            if (day != null && day.equalsIgnoreCase(dayOfTheWeek)) {
                System.out.println(String.format("%s was written by %s, who was born on a %s",
                        b.getTitle(), b.getAuthor().getName().getLastName(),day));
                match = true;
            }
        }

        if (!match) {
            System.out.println("No authors were born on a " + dayOfTheWeek);
        }
    }

    /**
     * display all the books published on the day of the week entered
     * @param dayOfTheWeek the day of the week entered
     */
    public void displayAllBooksPublishedOn(String dayOfTheWeek) {
        boolean match = false;

        for(Book b: books) {
            if (b.getDatePublished().getDayOfTheWeek() != null &&
                    b.getDatePublished().getDayOfTheWeek().equalsIgnoreCase(dayOfTheWeek)) {
                System.out.println(String.format("%s was written by %s, which was published on a %s",
                        b.getTitle(),b.getAuthor().getName().getLastName(),b.getDatePublished().getDayOfTheWeek()));
                match = true;
            }
        }

        if (!match) {
            System.out.println("No books were published on a " + dayOfTheWeek);
        }
    }

    /**
     * display all the books written by authors with pseudonym
     */
    public void displayAllBooksWrittenByAuthorsWithAPseudonym() {
        books = getCollectionOfItems();

        for(Book b: books) {
            String pseudonym = b.getAuthor().getPseudonym();

            if (pseudonym != null) {
                System.out.println(String.format("%s wrote %s as %s",
                        b.getAuthor().getName().getLastName(), b.getTitle(), b.getAuthor().getPseudonym()));
            }
        }
    }

    /**
     * display all the books with biggest percentage of markup
     */
    public void displayBookWithBiggestPercentageMarkup() {

        double markUp;
        double someMarkup = 0.0;
        Book someBook = null;

        for(Book b: books) {
            markUp = 100.0 * (b.getSuggestedPriceDollars() - b.getManufacturingPriceDollars()) /
                    b.getManufacturingPriceDollars();

            if (markUp > someMarkup) {
                someMarkup = markUp;
                someBook = b;
            }
        }
        if (someBook != null) {
            System.out.println(String.format("Highest markup is %.12f33%%, for %s by %s",
                    someMarkup, someBook.getTitle(),someBook.getAuthor().getName().getLastName()));
        }
    }

    /**
     * display all the books written outside specialty
     */
    public void displayAllBooksWrittenOutsideSpecialty() {
        for(Book b: books) {
            if (!b.getAuthor().getGenre().equals(b.getGenre())) {
                System.out.println(String.format("%s usually wrote %s but wrote %s which is %s",
                        b.getAuthor().getName().getLastName(),
                        b.getAuthor().getGenre().toString().toLowerCase(), b.getTitle(), b.getGenre().toString().toLowerCase()));
            }
        }
    }
}
