package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.domain.model.User;
import pl.coderslab.charity.sevice.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping({"/register","donation"})
    public String createUser(){
        User user = new User();
        user.setUsername("user");
        user.setPassword("user1");
        userService.saveUser(user);
        return "register/register";
    }
}
