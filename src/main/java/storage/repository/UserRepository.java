package storage.repository;

import storage.model.User;

public interface UserRepository {
    User createUser(User user);

    void deleteById(String userId);
}
