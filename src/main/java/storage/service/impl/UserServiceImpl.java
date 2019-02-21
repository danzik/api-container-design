package storage.service.impl;

import storage.model.User;
import storage.repository.UserRepository;
import storage.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User createUser(User user) {
        User userCandidate = findByEmail(user.getEmail());
        if (userCandidate != null) {
            throw new IllegalArgumentException("User with such email " + user.getEmail() + " already exist");
        }
        return userRepository.createUser(user);
    }

}