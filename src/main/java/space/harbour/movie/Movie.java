package space.harbour.movie;

public final class Movie {


    private String title;
    private Integer length;
    private Integer ratings;
    private Integer year;
    private String director;
    private String actor;
    private String genre;



    public Movie(final String t, final int l,
        final int r, final int y, final String d,
        final String a, final String g) {

        this.title = t;
        this.length = l;
        this.ratings = r;
        this.year = y;
        this.director = d;
        this.actor = a;
        this.genre = g;
    }

    public String getTitle() {
        return title;
    }

    public Integer getLen() {
        return length;
    }

    public Integer getRatings() {
        return ratings;
    }

    public Integer getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getActor() {
        return actor;
    }

    public String getGenre() {
        return genre;
    }

}
