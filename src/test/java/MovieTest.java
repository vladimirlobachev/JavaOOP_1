import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import space.harbour.database.MySQLAccess;
import space.harbour.movie.Movie;

public class MovieTest {
    
    static MySQLAccess sql;
    Movie m1 = new Movie("Joker", 230, 10, 2019,
            "Vladimir Lobachev", "Vladimir Lobachev", "comedy");
    Movie m2 = new Movie("SpiderMEN", 230, 10, 2019,
            "Vladimir Lobachev", "Vladimir Lobachev", "comedy");

    @BeforeClass
    public static void setUp() {
        sql = new MySQLAccess();

    }

    @Test
    public void setUpTest() {
        sql.deleteDB();
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