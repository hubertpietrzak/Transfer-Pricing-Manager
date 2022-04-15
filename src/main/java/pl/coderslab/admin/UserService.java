package pl.coderslab.admin;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}