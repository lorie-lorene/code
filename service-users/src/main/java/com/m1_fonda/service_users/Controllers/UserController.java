package com.m1_fonda.service_users.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1_fonda.service_users.Services.UserService;
import com.m1_fonda.service_users.models.Userbanque;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    // Controller pour l'enregistrement
    @PostMapping("/create")
    public List<Userbanque> addUserController(@RequestBody Userbanque user){
        userService.addUser(user);
        return userService.findUser();

    }

    @GetMapping("/delete/{id}")
    public List<Userbanque> delete(@PathVariable("id") int id) {
        return userService.deleteById(id);
    }
    
    
}
