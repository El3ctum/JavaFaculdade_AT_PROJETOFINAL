package br.infnet.at.movie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieService {
    private static Map<Integer, Movie> MovieMap = new HashMap<Integer, Movie>();

    private static Integer id = 0;

    public static void insertMovie(Movie movie) {

        movie.setId(++id);

        MovieMap.put(movie.getId(), movie);
    }

    public static void deleteMovie(Integer id) {
        MovieMap.remove(id);
    }

    public static Collection<Movie> moviesList() {
        return MovieMap.values();
    }

    public static Movie getMovieById(Integer id) {
        return MovieMap.get(id);
    }

}