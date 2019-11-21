public final class Movie {


    private String title;
    private Integer length;
    private Integer ratings;
    private Integer year;
    private String director;
    private String actor;
    private String genre;



    public Movie(final String ttl, final Integer len, final Integer rtngs,
        final Integer yeaR, final String direc,
        final String act, final String gnr) {

        this.title = ttl;
        this.length = len;
        this.ratings = rtngs;
        this.year = yeaR;
        this.director = direc;
        this.actor = act;
        this.genre = genre;
    }

    public void setLen(int len) {
        this.length = len;
    }

    public Integer getLen() {
        return this.length;
    }

    public void setYear(int yr) {
        this.year = yr;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setRatings(int ratngs) {
        this.ratings = ratngs;
    }

    public Integer getRatings() {
        return this.ratings;
    }

    public void setDirector(String dr) {
        this.director = dr;
    }

    public String getDirector() {
        return this.director;
    }

    public void setActor(String ac) {
        this.actor = ac;
    }

    public String getActor() {
        return this.actor;
    }

    public void setGenre(String gnr) {
        this.genre = gnr;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setTitle(String ttl) {
        this.title = ttl;
    }

    public String getTitle() {
        return this.title;
    }

}
