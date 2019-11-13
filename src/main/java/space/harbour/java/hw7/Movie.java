package space.harbour.java.hw7;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public final class Movie {

    private static Integer length;
    private static Integer ratings;
    private static Integer year;
    private static String director;
    private static String actor;
    private static String genre;
    private static String title;



    public Movie(final String ttl, final Integer yeaR, final String direc,
        final String gnr, final String act,
        final Integer len, final Integer rtngs) {

        this.title = ttl;
        this.length = len;
        this.ratings = rtngs;
        this.year = yeaR;
        this.director = direc;
        this.actor = act;
        this.genre = genre;
    }

    public Integer getLen() {
        return this.length;
    }

    public Integer getYear() {
        return this.year;
    }

    public Integer getRatings() {
        return this.ratings;
    }

    public static List<Movie> filterByDirector(final List<Movie> mList,
        final String contains) {
        List<Movie> filtMList = mList.stream()
            .filter(m -> m.director.contains(contains))
            .collect(Collectors.toList());

        return filtMList;
    }

    public static List<Movie> filterByActor(final List<Movie> mList,
           final Integer lenght) {
        List<Movie> filtMList = mList.stream()
            .filter(m -> m.actor.length() <= lenght)
            .collect(Collectors.toList());

        return filtMList;
    }

    public static List<Movie> filterByGenre(final List<Movie> mList,
        final String gen) {
        List<Movie> filtMList = mList.stream()
            .filter(m -> m.genre == gen)
            .collect(Collectors.toList());

        return filtMList;
    }

    public static List<Movie> sortByLenght(final List<Movie> mList) {
        List<Movie> filtMList = mList.stream()
            .sorted(Comparator.comparingInt(Movie::getLen))
            .collect(Collectors.toList());
        return filtMList;
    }

    public static List<Movie> sortByYear(final List<Movie> mList) {
        List<Movie> filtMList = mList.stream()
            .sorted(Comparator.comparingInt(Movie::getYear))
            .collect(Collectors.toList());
        return filtMList;
    }

    public static List<Movie> sortByRatings(final List<Movie> mList) {
        List<Movie> filtMList = mList.stream()
            .sorted(Comparator.comparingInt(Movie::getRatings))
            .collect(Collectors.toList());
        return filtMList;
    }

}
