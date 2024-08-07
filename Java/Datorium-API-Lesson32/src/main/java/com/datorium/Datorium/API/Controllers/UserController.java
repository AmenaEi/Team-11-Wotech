package com.datorium.Datorium.API.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    // CRUD
    // Create user or add user
    // Update user
    // Get User
    // Delete user

    @GetMapping("/test") //http://localhost:8080/test -> http://localhost:8080/user/test because of @RequestMapping (8th line)
    public String test() {
        return "testy testy";
    }

}
