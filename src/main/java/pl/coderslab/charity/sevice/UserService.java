package pl.coderslab.charity.sevice;

import pl.coderslab.charity.domain.model.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}
