package storage.controller;

import storage.GsonConverter;
import storage.http.HttpStatusCode;
import storage.http.container.HttpService;
import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;
import storage.model.User;
import storage.service.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService, HttpService http) {
        this.userService = userService;
        http.post("/users", this::createUser);
        http.get("/users/:email", this::findUserByEmail);
    }

    private ResponseWrapper<User> findUserByEmail(RequestWrapper request, ResponseWrapper<User> response) {
        String email = request.getParam(":email");
        User user = userService.findByEmail(email);
        response.body(user);
        return response;
    }

    private ResponseWrapper<User> createUser(RequestWrapper request, ResponseWrapper<User> response) {
        String userJsonModel = request.getBody();
        User newUser = userService.createUser(userJsonModel);
        response.body(newUser);
        response.setStatus(HttpStatusCode.CREATED);
        return response;
    }

}