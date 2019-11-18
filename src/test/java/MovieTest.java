import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import space.harbour.database.MySQLAccess;
import space.harbour.movie.Movie;

public class MovieTest {
    MySQLAccess sql;
    Movie m1;
    Movie m2;

    @Before
    public void setUp() {
        sql = new MySQLAccess();
        m1 = new Movie("Joker", 230, 10, 2019,
            "Vladimir Lobachev", "Vladimir Lobachev", "comedy");

        m2 = new Movie("SpiderMEN", 230, 10, 2019,
            "Vladimir Lobachev", "Vladimir Lobachev", "comedy");
    }

    @Test
    public void setUpTest() {
        assertTrue(sql.setMovieDB());

    }

    @Test
    public void insertTest() {
        assertTrue(sql.insertToMovie(m1));
        assertTrue(sql.insertToMovie(m2));
    }

    @Test
    public void selectTest() {
        List<Movie> lm = sql.selectFromMovie();
        assertTrue(lm != null);
    }


}