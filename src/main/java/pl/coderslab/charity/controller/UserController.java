package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.domain.model.User;
import pl.coderslab.charity.sevice.UserService;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String prepareRegisterUser(){
        return "/register/register";
    }

    @PostMapping("/register")
    public String processRegisterUser(User user){

        log.info("zapis: {}", user);
        userService.saveUser(user);
        return "redirect:/donation/create";
    }

}
