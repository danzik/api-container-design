package storage.service;

import storage.model.LoginResponse;

public interface LoginService {
    LoginResponse login(String username, String password);
}
