package br.infnet.at.cinema;

import br.infnet.at.movie.Movie;
import br.infnet.at.movie.MovieService;
import br.infnet.at.user.workerUser.WorkerUser;
import br.infnet.at.user.workerUser.WorkerUserService;
import br.infnet.at.util.ApiResponse;
import br.infnet.at.util.LocalDateAdapter;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import spark.Route;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;

public class CinemaController {

    // Get all Cinemas
    public static Route getCinemasList = (req, res) -> {
        res.type("application/json");
        res.status(200);
        return new Gson().toJson(new ApiResponse("Success", CinemaService.cinemasList()));
    };

    // Include a new Cinema
    public static Route insertCinema = (req, res) -> {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        JsonObject requestBodyJson = JsonParser.parseString(req.body()).getAsJsonObject();

        Cinema cinema = gson.fromJson(requestBodyJson, Cinema.class);

        if (requestBodyJson.has("workerUser")) {
            JsonObject workerUserJson = requestBodyJson.getAsJsonObject("workerUser");
            WorkerUser workerUser = gson.fromJson(workerUserJson, WorkerUser.class);
            WorkerUserService.insertWorkerUser(workerUser);
            cinema.setWorkerUser(workerUser);
        } else {
            cinema.setWorkerUser(WorkerUserService.getRandomWorkerUser());
        }

        if (requestBodyJson.has("movies")) {
            Type listType = new TypeToken<List<Movie>>(){}.getType();
            JsonArray moviesJsonArray = requestBodyJson.getAsJsonArray("movies");
            List<Movie> movies = gson.fromJson(moviesJsonArray, listType);
            for (Movie movie : movies) {
                MovieService.insertMovie(movie);
            }
            cinema.setMovies(movies);
        } else {
            Collection<Movie> movies = MovieService.moviesList();
            cinema.setMovies(new ArrayList<>(movies));
        }

        CinemaService.insertCinema(cinema);

        return new Gson().toJson(new ApiResponse("Cinema insertion was successful", cinema));
    };


    // Exclude a Cinema
    public static Route deleteCinema = (req, res) -> {
        Integer index = Integer.valueOf(req.params("id"));

        Cinema cinema = CinemaService.getCinemaById(index);

        CinemaService.deleteCinema(index);

        return new Gson().toJson(new ApiResponse("Cinema deletion was successful", cinema));
    };


    // Get a Cinema
    public static Route getCinema = (req, res) -> {
        Integer id = Integer.parseInt(req.params("id"));

        Cinema cinema = CinemaService.getCinemaById(id);

        if (cinema != null) {
            return new Gson().toJson(new ApiResponse("Success", cinema));
        } else {
            return new Gson().toJson(new ApiResponse("Cinema with ID " + id + " not found", null));
        }
    };
}
