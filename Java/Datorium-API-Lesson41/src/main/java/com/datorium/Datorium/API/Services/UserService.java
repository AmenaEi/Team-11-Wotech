package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Repo.UserRepo;
import org.apache.coyote.BadRequestException;

import java.util.ArrayList;

public class UserService {

    private UserRepo userRepo;
    public UserService(){
        userRepo = new UserRepo();
    }

    public void add(User user) throws BadRequestException {
        /*
        if(!user.name.isEmpty()) {
            userRepo.add(user);     //just don't add user, if it's empty
        }
         */

        //If we have also email, etc. then it should be like this:

        if(user.name.isEmpty()){
            throw new BadRequestException("User name is empty");
        }
        userRepo.add(user);


    }

    public ArrayList<User> getUsers() {
        return userRepo.getUsers();
    }

    public User update(int userIndex, User updateUserDTO) {
        return userRepo.update(userIndex, updateUserDTO);
    }
}
