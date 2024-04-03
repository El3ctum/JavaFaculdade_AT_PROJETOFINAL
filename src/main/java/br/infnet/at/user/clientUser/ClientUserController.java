package br.infnet.at.user.clientUser;

import br.infnet.at.util.ApiResponse;
import com.google.gson.Gson;
import spark.Route;

public class ClientUserController {

    // Get all Client Users
    public static Route getClientUsersList = (req, res) -> {

        res.type("application/json");
        res.status(200);
        return new Gson().toJson(ClientUserService.clientUserList());
    };

    // Include a new Client User
    public static Route insertClientUser = (req, res) -> {

        res.type("application/json");
        ClientUser clientUser = new Gson().fromJson(req.body(), ClientUser.class);
        ClientUserService.insertClientUser(clientUser);
        res.status(201);
        return new Gson().toJson(new ApiResponse("Client insertion was successful", clientUser));
    };


    // Exclude a Client User
    public static Route deleteClientUser = (req, res) -> {
        res.type("application/json");
        Integer index = Integer.valueOf(req.params("id"));
        ClientUser clientUser = ClientUserService.getClientUserById(index);
        ClientUserService.deleteClientUser(index);
        res.status(200);
        return new Gson().toJson(new ApiResponse("Client deletion was successful", clientUser));
    };


    // Get a Client User
    public static Route getClientUser = (req, res) -> {
        res.type("application/json");
        Integer id = Integer.parseInt(req.params("id"));
        ClientUser clientUser = ClientUserService.getClientUserById(id);
        if (clientUser != null) {
            res.status(200);
            return new Gson().toJson(clientUser);
        } else {
            res.status(404);
            return new Gson().toJson(new ApiResponse("Client not found", null));
        }
    };

}
