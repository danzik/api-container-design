package storage.service;


import storage.model.User;

public interface UserService {

    User findByEmail(String email);

    User createUser(User user);

}
