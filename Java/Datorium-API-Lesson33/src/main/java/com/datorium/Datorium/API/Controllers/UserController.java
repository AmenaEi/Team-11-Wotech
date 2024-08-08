package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * This service is specific for this controller. We assign local variable to store existing {@link UserService} instance.
     */
    private UserService userService;

    public UserController() {
        // This code runs first, when creating UserController object
        userService = new UserService();

    }

    // CRUD
    // Create user or add user
    // Get User
    // Update user
    // Delete user

    /*
    @GetMapping("/test") //http://localhost:8080/test -> http://localhost:8080/user/test because of @RequestMapping (8th line)
    public String test() {
        return "testy testy";
    }    // Postman - GET
    */

    @PostMapping("/add")
    public int add(@RequestBody User user) {
        return userService.add(user);               //API is asking the Services
    }

}
