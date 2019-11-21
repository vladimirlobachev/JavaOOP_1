import com.google.gson.Gson;
import org.eclipse.jetty.client.HttpResponse;
import org.eclipse.jetty.http.HttpStatus;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple CRUD example showing how to create, get, update and delete book resources.
 */
public class Movies {

    public static void main(String[] args) {
        // You shoud read them from the MongoDB

        final Gson gson = new Gson();

        Mongo mongo = new Mongo();

        mongo.setMongo();

        staticFileLocation("public");

        // Creates a new book resource, will return the ID to the created resource
        // author and title are sent in the post body as x-www-urlencoded values e.g. author=Foo&title=Bar
        // you get them by using request.queryParams("valuename")
        post("/movies", (request, response) -> {
            String title = request.queryParams("title");
            Integer length = Integer.valueOf(request.queryParams("length"));
            Integer ratings = Integer.valueOf(request.queryParams("ratings"));
            Integer year = Integer.valueOf(request.queryParams("year"));
            String director = request.queryParams("director");
            String actor = request.queryParams("actor");
            String genre = request.queryParams("genre");
            

            Movie m = new Movie(title, length, ratings,
                year, director, actor, genre);

            mongo.insertMovie(m);

            response.status(HttpStatus.CREATED_201);
            return title;
        });

        // Gets the book resource for the provided id
        get("/movies/:title", (request, response) -> {
            
            String title = request.params(":title");

            Movie movie = mongo.getMovie(title);
            

            if (movie == null) {
                response.status(HttpStatus.NOT_FOUND_404);
                return "Movie not found";
            }
            if (clientAcceptsHtml(request)) {
                Map<String, Object> movieMap = new HashMap<>();
                movieMap.put("movie", movie);
                return render(movieMap, "movie.ftl");
            } else if (clientAcceptsJson(request))
                return gson.toJson(movie);

            return null;
        });

        // Updates the book resource for the provided id with new information
        // author and title are sent in the request body as x-www-urlencoded values e.g. author=Foo&title=Bar
        // you get them by using request.queryParams("valuename")
        put("/movies/:title", (request, response) -> {
            String title = request.params(":title");
            
            Movie movie = mongo.getMovie(title);
            

            if (movie == null) {
                response.status(HttpStatus.NOT_FOUND_404);
                return "Movie not found";
            }

            
            mongo.deleteMovie(title);
            
            String newTitle = request.queryParams("title");
            Integer newLength = Integer.valueOf(request.queryParams("length"));
            Integer newRatings = Integer.valueOf(request.queryParams("ratings"));
            Integer newYear = Integer.valueOf(request.queryParams("year"));
            String newDirector = request.queryParams("director");
            String newActor = request.queryParams("actor");
            String newGenre = request.queryParams("genre");

            if (newTitle != null) {
                movie.setTitle(newTitle);
            }
            if (newLength != null) {
                movie.setLen(newLength);
            }
            if (newRatings != null) {
                movie.setRatings(newRatings);
            }
            if (newYear != null) {
                movie.setYear(newYear);
            }
            if (newDirector != null) {
                movie.setDirector(newDirector);
            }
            if (newActor != null) {
                movie.setActor(newActor);
            }
            if (newGenre != null) {
                movie.setGenre(newGenre);
            }

            mongo.insertMovie(movie);

            return "Movie with title '" + title + "' updated";
        });

        // Deletes the book resource for the provided id
        delete("/movies/:title", (request, response) -> {
            String title = request.params(":title");
            Movie movie = mongo.getMovie(title);
            if (movie == null) {
                response.status(HttpStatus.NOT_FOUND_404);
                return "Movie not found";
            }
            mongo.deleteMovie(title);
            return "Movie with title '" + title + "' deleted";
        });

        // Gets all available book resources
        get("/movies", (request, response) -> {
            Map<String, Object> movieMap = mongo.getAll();
            if (clientAcceptsHtml(request)) {
                return render(movieMap, "movies.ftl");
            } else if (clientAcceptsJson(request))
                return gson.toJson(movieMap);

            return null;
        });
    }

    public static String render(Map values, String template) {
        return new FreeMarkerEngine().render(new ModelAndView(values, template));
    }

    public static boolean clientAcceptsHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }

    public static boolean clientAcceptsJson(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("application/json");
    }

}
