package br.infnet.at.cinema;

import br.infnet.at.movie.Movie;
import br.infnet.at.user.workerUser.WorkerUser;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaService {
    private static Map<Integer, Cinema> CinemaMap = new HashMap<Integer, Cinema>();

    private static Integer id = 0;

    public static void insertCinema(Cinema cinema) {

        cinema.setId(++id);
//        cinema.setMovies(movies);
//        cinema.setWorkerUser(workerUser);
        CinemaMap.put(cinema.getId(), cinema);
    }

    public static void deleteCinema(Integer id) {
        CinemaMap.remove(id);
    }

    public static Collection<Cinema> cinemasList() {
        return CinemaMap.values();
    }

    public static Cinema getCinemaById(Integer id) {
        return CinemaMap.get(id);
    }
}
