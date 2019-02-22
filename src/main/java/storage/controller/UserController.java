package storage.controller;

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
        http.put("/users", this::updateUser);
        http.post("/users", this::createUser);
        http.get("/users/:id", this::findUserById);
    }

    private ResponseWrapper<User> findUserById(RequestWrapper request, ResponseWrapper<User> response) {
        String id = request.getParam(":id");
        User user = userService.findUserById(id);
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

    private ResponseWrapper<User> updateUser(RequestWrapper request, ResponseWrapper<User> response) {
        String userJsonModel = request.getBody();
        User newUser = userService.update(userJsonModel);
        response.body(newUser);
        return response;
    }

}