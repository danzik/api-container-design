package storage.service.impl;

import storage.model.LoginResponse;
import storage.model.User;
import storage.service.LoginService;
import storage.service.UserService;

import java.util.Date;

public class LoginServiceImpl implements LoginService {
    private UserService userService;

    public LoginServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public LoginResponse login(String username, String password) {
        User user = userService.findByEmail(username);
        LoginResponse response = new LoginResponse();
        if (user != null) {
            if (user.getPassword().equals(password)) {
                response.setLoginDate(new Date());
                response.setUserEmail(user.getEmail());
                response.setLastName(user.getLastName());
                response.setUserType(user.getUserType());
                response.setFirstName(user.getFirstName());
                response.setSuccess(true);
            }
        }
        return response;
    }

}
