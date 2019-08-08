package com.bcit.comp1451.assignment1;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * This is a JUnit testbed provided to all students
 * to put BookStore and ShoeStore through the wringer.
 * The majority of the 'positive' marks for Assignment 1 come from the results window
 * that this module produces.  Compile the project and right-click the green TestAssignment1
 * box to "Test All".  For each test that fails, subtract one point from your grade.
 *
 * It is possible that the module will not compile if you have a mis-named method,
 * or in the case that a constructor has the incorrect type / order of parameters.
 * You should change your code to resolve all errors since TestAssignment1
 * is an authority on how your classes should be presented.
 *
 * Finally, be aware that a number of the tests will attempt to break your solution
 * by giving null as a parameter.  If you do not pass this test, it will fail
 * with a NullPointerException message and no other explanation.
 * The fix for this is to ensure that all Object parameters (String being a type of Object)
 * are not null before you do anything -- or write the code in such a way that null
 * is not dereferenced (IE your program doesn't try to call a method of null).
 *
 * @author  COMP1451 (James Pede)
 * @version Jul12'14,1700h
 */
public class TestAssignment1
{
    private static final String MINOR_ERROR_MESSAGE = "-1 point.";
    private static final String MAJOR_ERROR_MESSAGE = MINOR_ERROR_MESSAGE + "  The amount of lines in your solution is not the same as the amount of lines in my solution.";
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String TESTCODE_PREFIX = "final String EXPECTED = \"";
    private static final String TESTCODE_NEWLINE = "\"" + NEWLINE + "\t+ NEWLINE + \"";
    private static final String TESTCODE_SUFFIX = "\";" + NEWLINE;
    private static final boolean PRODUCE_JUNIT_CODE = false;

    private static BookStore bookStore = new BookStore(
            new Address("1234", "Main Street", "Vancouver", "A3A 4A4"),
            "Chapters",
            BookType.FICTION
    );

    private static ShoeStore shoeStore = new ShoeStore(
            new Address("789", "East 1st Street", "West Vancouver", "V3A 7A4"),
            "My Shoes",
            ShoeType.CHILDREN
    );

    private static PrintStream stdOut = System.out;
    private ByteArrayOutputStream outContent;
    private PrintStream ps;

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        outContent = new ByteArrayOutputStream();
        ps = new PrintStream(outContent);
        System.setOut(ps);
    } // end setup

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        String result = outContent.toString();

        purgeOldTest();
        ps.flush();
        System.setOut(stdOut);
    } // end cleanup

    private void purgeOldTest()
    {
        outContent.reset();
    } // end method

    private void verify(String expected)
    {
        String actual = outContent.toString(); // for debug purposes
        stdOut.println(PRODUCE_JUNIT_CODE
                        ? (TESTCODE_PREFIX
                        + actual.replaceAll(NEWLINE, TESTCODE_NEWLINE)
                        + TESTCODE_SUFFIX
                ) : actual
        );

        assertEquals(MINOR_ERROR_MESSAGE, expected, actual);
    } // end method

    private void verifyAnyOrder(String expected)
    {
        String actual = outContent.toString(); // for debug purposes
        stdOut.println(actual);

        String[] actualStrings = actual.split(NEWLINE);
        String[] expectedStrings = expected.split(NEWLINE);

        int i = actualStrings.length;
        assertEquals(MAJOR_ERROR_MESSAGE, expectedStrings.length, i);

        Arrays.sort(actualStrings);
        Arrays.sort(expectedStrings);

        while (0 != i--)
            assertEquals(MINOR_ERROR_MESSAGE, expectedStrings[i], actualStrings[i]);
    } // end method

    // BookStore tests

    @Test
    public void testAllBooksByEveryAuthor()
    {
        final String EXPECTED = "Gladwell wrote The Tipping Point in 2000"
                + NEWLINE + "Salinger wrote The Catcher in the Rye in 1951"
                + NEWLINE + "Feynman wrote Principle of Least Action in Quantum Mechanics in 1942"
                + NEWLINE + "Pohl wrote Gateway in 1977"
                + NEWLINE + "Salinger wrote A Boy in France in 1945"
                + NEWLINE + "Salinger wrote A Perfect Day for Bananafish in 1948"
                + NEWLINE + "Feynman wrote The Messenger Lectures in 1964"
                + NEWLINE + "Feynman wrote Surely You're Joking Mr. Feynman in 1985"
                + NEWLINE + "Pohl wrote Elegy to a Dead Planet: Luna in 1937"
                + NEWLINE + "Gladwell wrote Outliers in 2008"
                + NEWLINE + "";

        bookStore.displayAllBooksByEveryAuthor();
        verifyAnyOrder(EXPECTED);
    } // end test

    @Test
    public void testAllBooksByAuthor()
    {
        final String EXPECTED = "Salinger wrote The Catcher in the Rye"
                + NEWLINE + "Salinger wrote A Boy in France"
                + NEWLINE + "Salinger wrote A Perfect Day for Bananafish"
                + NEWLINE + "";

        bookStore.displayAllBooksByAuthor("Salinger");
        verifyAnyOrder(EXPECTED);

        bookStore.displayAllBooksByAuthor(null);
        // Crash Subtest
    } // end test

    @Test
    public void testAllBooksWrittenBefore()
    {
        final String EXPECTED = "The Catcher in the Rye was published in 1951, which is before 1970"
                + NEWLINE + "Principle of Least Action in Quantum Mechanics was published in 1942, which is before 1970"
                + NEWLINE + "A Boy in France was published in 1945, which is before 1970"
                + NEWLINE + "A Perfect Day for Bananafish was published in 1948, which is before 1970"
                + NEWLINE + "The Messenger Lectures was published in 1964, which is before 1970"
                + NEWLINE + "Elegy to a Dead Planet: Luna was published in 1937, which is before 1970"
                + NEWLINE + "";

        bookStore.displayAllBooksWrittenBefore(1970);
        verifyAnyOrder(EXPECTED);
    } // end test

    @Test
    public void testTitlesOfBooksWrittenBy()
    {
        final String EXPECTED = "Salinger wrote The Catcher in the Rye as JD"
                + NEWLINE + "Salinger wrote A Boy in France as JD"
                + NEWLINE + "Salinger wrote A Perfect Day for Bananafish as JD"
                + NEWLINE + "";

        bookStore.displayTitlesOfBooksWrittenBy("JD");
        verifyAnyOrder(EXPECTED);

        bookStore.displayTitlesOfBooksWrittenBy(null);
        // Crash Subtest
    } // end test

    @Test
    public void testAllBooksForGenre()
    {
        final String EXPECTED = "The Tipping Point is a nonfiction book written by Gladwell"
                + NEWLINE + "Surely You're Joking Mr. Feynman is a nonfiction book written by Feynman"
                + NEWLINE + "Outliers is a nonfiction book written by Gladwell"
                + NEWLINE + "";

        bookStore.displayAllBooksForGenre("nonfiction");
        verifyAnyOrder(EXPECTED);

        bookStore.displayAllBooksForGenre(null);
        // Crash Subtest
    } // end test

    @Test
    public void testTotalWeightKgOfAllBooks()
    {
        final String EXPECTED = "total kg of books: 8.51"
                + NEWLINE + "";

        bookStore.displayTotalWeightKgOfAllBooks();
        verify(EXPECTED);
    } // end test

    @Test
    public void testAllBooksWrittenByAuthorsOverThisAge()
    {
        final String EXPECTED_OLD = "No books by authors over age 70"
                + NEWLINE + "";

        final String EXPECTED_YOUNG = "The Tipping Point was written by Gladwell at age 37, which is more than 31"
                + NEWLINE + "The Catcher in the Rye was written by Salinger at age 32, which is more than 31"
                + NEWLINE + "Gateway was written by Pohl at age 58, which is more than 31"
                + NEWLINE + "The Messenger Lectures was written by Feynman at age 46, which is more than 31"
                + NEWLINE + "Outliers was written by Gladwell at age 45, which is more than 31"
                + NEWLINE + "Surely You're Joking Mr. Feynman was written by Feynman at age 67, which is more than 31"
                + NEWLINE;

        bookStore.displayAllBooksWrittenByAuthorsOverThisAge(70);
        verify(EXPECTED_OLD);

        purgeOldTest();

        bookStore.displayAllBooksWrittenByAuthorsOverThisAge(31);
        verifyAnyOrder(EXPECTED_YOUNG);
    } // end test

    @Test
    public void testAllBooksWrittenByAuthorsBornOn()
    {
        final String EXPECTED_FRIDAY = "No authors were born on a Friday"
                + NEWLINE + "";

        final String EXPECTED_WEDNESDAY = "The Catcher in the Rye was written by Salinger, who was born on a Wednesday"
                + NEWLINE + "Gateway was written by Pohl, who was born on a Wednesday"
                + NEWLINE + "A Boy in France was written by Salinger, who was born on a Wednesday"
                + NEWLINE + "A Perfect Day for Bananafish was written by Salinger, who was born on a Wednesday"
                + NEWLINE + "Elegy to a Dead Planet: Luna was written by Pohl, who was born on a Wednesday"
                + NEWLINE + "";

        bookStore.displayAllBooksWrittenByAuthorsBornOn("Friday");
        verify(EXPECTED_FRIDAY);

        purgeOldTest();

        bookStore.displayAllBooksWrittenByAuthorsBornOn("Wednesday");
        verifyAnyOrder(EXPECTED_WEDNESDAY);

        bookStore.displayAllBooksWrittenByAuthorsBornOn("Dogsday"); // Every dog has its day.
        bookStore.displayAllBooksWrittenByAuthorsBornOn(null);
        // Crash Subtest
    } // end test

    @Test
    public void testAllBooksPublishedOn()
    {
        final String EXPECTED_SUNDAY = "No books were published on a Sunday"
                + NEWLINE + "";

        final String EXPECTED_TUESDAY = "The Messenger Lectures was written by Feynman, which was published on a Tuesday"
                + NEWLINE + "Outliers was written by Gladwell, which was published on a Tuesday"
                + NEWLINE + "";

        bookStore.displayAllBooksPublishedOn("Sunday");
        verify(EXPECTED_SUNDAY);

        purgeOldTest();

        bookStore.displayAllBooksPublishedOn("Tuesday");
        verifyAnyOrder(EXPECTED_TUESDAY);

        bookStore.displayAllBooksPublishedOn(null);
        // Crash Subtest
    } // end test

    @Test
    public void testAllBooksWrittenByAuthorsWithAPseudonym()
    {
        final String EXPECTED = "Salinger wrote The Catcher in the Rye as JD"
                + NEWLINE + "Pohl wrote Gateway as Paul Dennis Lavond"
                + NEWLINE + "Salinger wrote A Boy in France as JD"
                + NEWLINE + "Salinger wrote A Perfect Day for Bananafish as JD"
                + NEWLINE + "Pohl wrote Elegy to a Dead Planet: Luna as Paul Dennis Lavond"
                + NEWLINE + "";

        bookStore.displayAllBooksWrittenByAuthorsWithAPseudonym();
        verifyAnyOrder(EXPECTED);
    } // end test

    @Test
    public void testBookWithBiggestPercentageMarkup()
    {
        final String EXPECTED = "Highest markup is 333.33333333333333%, for Surely You're Joking Mr. Feynman by Feynman"
                + NEWLINE + "";

        bookStore.displayBookWithBiggestPercentageMarkup();
        verify(EXPECTED);
    } // end test

    @Test
    public void testAllBooksWrittenOutsideSpecialty()
    {
        final String EXPECTED = "Feynman usually wrote reference but wrote Surely You're Joking Mr. Feynman which is nonfiction"
                + NEWLINE + "";

        bookStore.displayAllBooksWrittenOutsideSpecialty();
        verify(EXPECTED);
    } // end test

    // ShoeStore tests

    @Test
    public void testAllShoesAndDesigners()
    {
        final String EXPECTED = "Skechers offers leather size-10 men's Diameter"
                + NEWLINE + "Stride Rite offers rubber size-9 children's Balance Of The Force"
                + NEWLINE + "Sperry offers cloth size-9 children's Top-Sider Unisex Bluefish H&L"
                + NEWLINE + "Nike offers rubber size-13 sports's Jordan Ace 23 II"
                + NEWLINE + "Nine West offers plastic size-8 women's Camya Multi Glitter"
                + NEWLINE + "Robert Cobbler offers leather size-12 dress's Wave"
                + NEWLINE + "Robert Cobbler offers cloth size-5 children's Toachi"
                + NEWLINE + "Geox offers plastic size-10 women's Marieclaire"
                + NEWLINE + "Geox offers cloth size-7 men's Monet"
                + NEWLINE + "Skechers offers plastic size-10 children's Lite Kicks Rainbow Sprite"
                + NEWLINE + "";

        shoeStore.displayAllShoesAndDesigners();
        verifyAnyOrder(EXPECTED);
    } // end test

    @Test
    public void testAllShoesByDesigner()
    {
        final String EXPECTED = "Skechers offers a size-10 men's Diameter"
                + NEWLINE + "Skechers offers a size-10 children's Lite Kicks Rainbow Sprite"
                + NEWLINE + "";

        shoeStore.displayAllShoesByDesigner("Skechers");
        verifyAnyOrder(EXPECTED);

        shoeStore.displayAllShoesByDesigner(null);
        // Crash Subtest
    } // end test

    @Test
    public void testAllShoesMadeOfMaterial()
    {
        final String EXPECTED = "The size-9 Top-Sider Unisex Bluefish H&L is made of cloth"
                + NEWLINE + "The size-5 Toachi is made of cloth"
                + NEWLINE + "The size-7 Monet is made of cloth"
                + NEWLINE + "";

        shoeStore.displayAllShoesMadeOf(Material.CLOTH);
        verifyAnyOrder(EXPECTED);

        shoeStore.displayAllShoesMadeOf((Material)null);
        // Crash Subtest
    } // end test

    @Test
    public void testAllShoesMadeOfString()
    {
        final String EXPECTED = "The size-8 Camya Multi Glitter is made of plastic"
                + NEWLINE + "The size-10 Marieclaire is made of plastic"
                + NEWLINE + "The size-10 Lite Kicks Rainbow Sprite is made of plastic"
                + NEWLINE + "";

        shoeStore.displayAllShoesMadeOf("plastic");
        verifyAnyOrder(EXPECTED);

        shoeStore.displayAllShoesMadeOf((String)null);
    } // end test

    @Test
    public void testNumberOfShoesDesignedByName()
    {
        final String EXPECTED = "This store has 2 shoes designed by Geox"
                + NEWLINE + "";

        shoeStore.displayNumberOfShoesDesignedBy(new Name("Geox"));
        verify(EXPECTED);

        shoeStore.displayNumberOfShoesDesignedBy((Name)null);
        // Crash Subtest
    } // end test

    @Test
    public void testNumberOfShoesDesignedByString()
    {
        final String EXPECTED = "This store has 2 shoes designed by Cobbler"
                + NEWLINE + "";

        shoeStore.displayNumberOfShoesDesignedBy("Cobbler");
        verify(EXPECTED);

        shoeStore.displayNumberOfShoesDesignedBy((String)null);
        // Crash Subtest
    } // end test

    @Test
    public void testAllShoesOfThisMaterialMadeByThisDesigner()
    {
        final String EXPECTED_LEATHER = "The Diameter is a leather shoe offered by Skechers"
                + NEWLINE + "";

        final String EXPECTED_PLASTIC = "This store has no plastic shoes designed by Nike"
                + NEWLINE + "";

        shoeStore.displayAllShoesOfThisMaterialMadeByThisDesigner(Material.LEATHER, new Name("Skechers"));
        verify(EXPECTED_LEATHER);

        purgeOldTest();

        shoeStore.displayAllShoesOfThisMaterialMadeByThisDesigner(Material.PLASTIC, new Name("Nike"));
        verify(EXPECTED_PLASTIC);

        purgeOldTest();

        shoeStore.displayAllShoesOfThisMaterialMadeByThisDesigner(Material.RUBBER, null);
        // Crash Subtest

        purgeOldTest();

        shoeStore.displayAllShoesOfThisMaterialMadeByThisDesigner(null, new Name("Robert", "Cobbler"));
        // Crash Subtest
    } // end test

    @Test
    public void testSmallestShoeSize()
    {
        final String EXPECTED = "smallest shoe size: 5"
                + NEWLINE + "";

        shoeStore.displaySmallestShoeSize();
        verify(EXPECTED);
    } // end test

    @Test
    public void testTotalWeightKgOfAllShoes()
    {
        final String EXPECTED = "total kg of shoes: 8.75"
                + NEWLINE + "";

        shoeStore.displayTotalWeightKgOfAllShoes();
        verify(EXPECTED);
    } // end test

    @Test
    public void testAllShoesNotInMatchingStore()
    {
        final String EXPECTED = "The Diameter is a men's shoe offered by Skechers"
                + NEWLINE + "The Jordan Ace 23 II is a sports's shoe offered by Nike"
                + NEWLINE + "The Camya Multi Glitter is a women's shoe offered by Nine West"
                + NEWLINE + "The Wave is a dress's shoe offered by Robert Cobbler"
                + NEWLINE + "The Marieclaire is a women's shoe offered by Geox"
                + NEWLINE + "The Monet is a men's shoe offered by Geox"
                + NEWLINE + "";

        shoeStore.displayAllShoesNotInMatchingStore();
        verifyAnyOrder(EXPECTED);
    } // end test
} // end class