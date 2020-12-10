package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    UserModel getUserByUsername(String username);
    public String encrypt(String password);
    boolean passwordValidation(String password);
}
