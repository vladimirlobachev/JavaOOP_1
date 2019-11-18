package space.harbour.database;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import space.harbour.movie.Movie;


public class MySQLAccess {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/";

    private static final String USER = "root";
    private static final String PASSWORD = "1234567890";

    private static final String CREATE_TABLE_SQL = "CREATE TABLE Movie ("
                    + "Title VARCHAR(45) NOT NULL,"
                    + "Length INT NOT NULL,"
                    + "Ratings INT NOT NULL,"
                    + "Year INT NOT NULL,"
                    + "Dircetor VARCHAR(45) NOT NULL,"
                    + "Actor VARCHAR(45) NOT NULL,"
                    + "Genre VARCHAR(45) NOT NULL,"
                    + "PRIMARY KEY (Title))";


    private static Connection conn = null;
    private static Statement stm = null;
    private PreparedStatement ps = null;

    private boolean connect(final String db) {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL + db, USER, PASSWORD);
            stm = conn.createStatement();
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean disconnect() {
        try {
            conn.close();

            stm.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * method to create a db and a movie table in it
     *
     */
    public boolean setMovieDB() {
        try {
            connect("");
            stm.executeUpdate("CREATE DATABASE Movies");
            stm.executeUpdate(CREATE_TABLE_SQL);
            disconnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public void deleteDB() {
    	try {
    		connect("Movies");
    		stm.executeUpdate("DROP DATABASE Movies");
    		disconnect();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    /*
     * method to insert a movie to a Movie table
     *
     */
    public boolean insertToMovie(final Movie m) {
        if (m != null) {
            try {
            	connect("Movies");
	            ps = conn.prepareStatement("INSERT INTO Movie "
	             + "(title, length, ratings, year, director, actor, genre) "
	             + "VALUES (? ? ? ? ? ? ?)");

	            ps.setString(1, m.getTitle());
	            ps.setInt(2, m.getLen());
	            ps.setInt(3, m.getRatings());
	            ps.setInt(4, m.getYear());
	            ps.setString(5, m.getDirector());
	            ps.setString(6, m.getActor());
	            ps.setString(7, m.getGenre());
	            ps.executeUpdate();
	            disconnect();
	            return true;
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        	return false;
	        }
        }
        return false;
    }
    /*
     * method to get all movies from Movie table
     *
     */
    public List<Movie> selectFromMovie() {
        String query = "SELECT * FROM Movie";
        try {
	        connect("Movies");
	        ResultSet rs = stm.executeQuery(query);
	        List<Movie> lm = new ArrayList<Movie>();
	        while (rs.next()) {
	            lm.add(new Movie(rs.getString("title"),
	                                rs.getInt("length"),
	                                rs.getInt("ratings"),
	                                rs.getInt("year"),
	                                rs.getString("director"),
	                                rs.getString("actor"),
	                                rs.getString("genre")));
	        }
	        disconnect();
	        return lm;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return null;
        }
    }
}

