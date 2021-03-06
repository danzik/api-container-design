package storage.service;


import storage.model.User;

public interface UserService {

    User findByEmail(String email);

    User createUser(String json);

    User findUserById(String id);

    User update(String userJsonModel);
}
