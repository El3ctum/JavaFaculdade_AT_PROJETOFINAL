package br.infnet.at;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import br.infnet.at.cinema.CinemaController;
import br.infnet.at.movie.MovieController;
import br.infnet.at.user.clientUser.ClientUserController;
import br.infnet.at.user.workerUser.WorkerUserController;
import br.infnet.at.util.CorsUtil;
import br.infnet.at.viacep.ViaCepController;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        // Spark basic config
        port(8080);
        CorsUtil.apply();

        // Client User
        get("/clientUser/list", ClientUserController.getClientUsersList);
        post("/clientUser/insert", ClientUserController.insertClientUser);
        delete("/clientUser/:id/delete", ClientUserController.deleteClientUser);
        get("/clientUser/:id", ClientUserController.getClientUser);

        // Worker User
        get("/workerUser/list", WorkerUserController.getWorkerUsersList);
        post("/workerUser/insert", WorkerUserController.insertWorkerUser);
        delete("/workerUser/:id/delete", WorkerUserController.deleteWorkerUser);
        get("/workerUser/:id", WorkerUserController.getWorkerUser);

        // Movie
        get("/movie/list", MovieController.getMoviesList);
        post("/movie/insert", MovieController.insertMovie);
        delete("/movie/:id/delete", MovieController.deleteMovie);
        get("/movie/:id", MovieController.getMovie);

        // Cinema
        get("/cinema/list", CinemaController.getCinemasList);
        post("/cinema/insert", CinemaController.insertCinema);
        delete("/cinema/:id/delete", CinemaController.deleteCinema);
        get("/cinema/:id", CinemaController.getCinema);

        //VIACEP
        get("/viacep/:cep", ViaCepController.getAddress);

    }
}