package space.harbour.java.hw7;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MovieTest {
    static Movie m1;
    static Movie m2;
    static Movie m3;
    static Movie m4;



    @BeforeClass
    public static void SetUp() throws Exception {
        m1 = new Movie("Hello", 2019, "Vladimir Lobachev", "comedy", "Vladimir Lobachev", 180, 10);
        m2 = new Movie("World", 2020, "John Biber", "thriller", "Tom Cruise", 210, 5);
        m3 = new Movie("CruelWorld", 2029, "Stiven Plaza", "comdey", "Clint Eastwood", 185, 7);
        m4 = new Movie("GoodBye", 2030, "Michal Jackson", "drama", "Josh Kraviz", 194, 8);
    }

    /*@Test
    public void filterByDirectorTest() {
        List<Movie> expected = Arrays.asList(m1, m3);
        List<Movie> received = m1.filterByDirector(Arrays.asList(m1,m2,m3,m4), "ch");
        assertArrayEquals(expected, received);
    }

    @Test
    public void filterByActorTest() {
        List<Movie> expected = Arrays.asList(m2);
        List<Movie> received = m1.filterByDirector(Arrays.asList(m1,m2,m3,m4), 10);
        assertArrayEquals(expected, received);
    }   

    @Test
    public void filterByGenreTest() {
        List<Movie> expected = Arrays.asList(m1, m3);
        List<Movie> received = m1.filterByDirector(Arrays.asList(m1,m2,m3,m4), "comedy");
        assertArrayEquals(expected, received);
    }

    @Test
    public void sortByLengthTest() {
        List<Movie> expected = Arrays.asList(m1, m3, m4, m2);
        List<Movie> received = m1.sortByLength(Arrays.asList(m1,m2,m3,m4));
        assertArrayEquals(expected, received);
    }

    @Test
    public void sortByYearTest() {
        List<Movie> expected = Arrays.asList(m1, m2, m3, m4);
        List<Movie> received = m1.sortByYear(Arrays.asList(m1,m2,m3,m4));
        assertArrayEquals(expected, received);
    }

    @Test
    public void sortByRatingsTest() {
        List<Movie> expected = Arrays.asList(m2, m3, m4, m1);
        List<Movie> received = m1.sortByRatings(Arrays.asList(m1,m2,m3,m4));
        assertArrayEquals(expected, received);
    }*/

}