package br.infnet.at.movie;

import br.infnet.at.movie.MovieService;
import br.infnet.at.util.ApiResponse;
import com.google.gson.Gson;
import spark.Route;

public class MovieController {

    // Get all Movies
    public static Route getMoviesList = (req, res) -> {

        res.type("application/json");
        res.status(200);
        return new Gson().toJson(new ApiResponse("Success", MovieService.moviesList()));
    };

    // Include a new Movie
    public static Route insertMovie = (req, res) -> {

        Movie movie = new Gson().fromJson(req.body(), Movie.class);

        MovieService.insertMovie(movie);

        return new Gson().toJson(new ApiResponse("Movie insertion was successful", movie));
    };


    // Exclude a Movie
    public static Route deleteMovie = (req, res) -> {
        Integer index = Integer.valueOf(req.params("id"));

        Movie movie = MovieService.getMovieById(index);

        MovieService.deleteMovie(index);

        return new Gson().toJson(new ApiResponse("Movie deletion was successful", movie));
    };


    // Get a Movie
    public static Route getMovie = (req, res) -> {
        Integer id = Integer.parseInt(req.params("id"));

        Movie movie = MovieService.getMovieById(id);

        if (movie != null) {
            return new Gson().toJson(new ApiResponse("Success", movie));
        } else {
            return new Gson().toJson(new ApiResponse("Movie with ID " + id + " not found", null));
        }
    };

}

