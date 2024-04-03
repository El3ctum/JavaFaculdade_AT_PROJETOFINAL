package br.infnet.at.user.workerUser;

import br.infnet.at.user.workerUser.WorkerUser;
import br.infnet.at.user.workerUser.WorkerUserService;
import br.infnet.at.util.ApiResponse;
import br.infnet.at.util.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Route;

import java.time.LocalDate;

public class WorkerUserController {

    // Get all Worker Users
    public static Route getWorkerUsersList = (req, res) -> {
        res.type("application/json");
        res.status(200);
        return new Gson().toJson(new ApiResponse("Success", WorkerUserService.workerUserList()));
    };

    // Include a new Worker User
    public static Route insertWorkerUser = (req, res) -> {

        // Configure Gson with custom type adapter
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        WorkerUser workerUser = gson.fromJson(req.body(), WorkerUser.class);

        WorkerUserService.insertWorkerUser(workerUser);

        return new Gson().toJson(new ApiResponse("Worker insertion was successful", workerUser));
    };


    // Exclude a Worker User
    public static Route deleteWorkerUser = (req, res) -> {
        Integer id = Integer.parseInt(req.params("id"));

        WorkerUser workerUser = WorkerUserService.getWorkerUserById(id);

        if (workerUser != null) {
            return new Gson().toJson(new ApiResponse("Success", workerUser));
        } else {
            return new Gson().toJson(new ApiResponse("WorkerUser with ID " + id + " not found", null));
        }
    };


    // Get a Worker User
    public static Route getWorkerUser = (req, res) -> {
        Integer id = Integer.parseInt(req.params("id"));

        WorkerUser workerUser = WorkerUserService.getWorkerUserById(id);

        if (workerUser != null) {
            return "WorkerUser found: " + workerUser;
        } else {
            return "WorkerUser with ID " + id + " not found.";
        }
    };

}

