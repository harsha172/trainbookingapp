package com.example.demo.controller.api;

import java.lang.Iterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Response;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/login")
    public Response login(
            @RequestParam String username,
            @RequestParam String password) {
        Iterable<User> iterator = userRepository.findAll();

        for (User user : iterator) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                Response response = new Response();
                response.message = user.getAadhar();
                response.status = 200;
                return response;
            }
        }
        Response response = new Response();
        response.message = "Username or Password is incorrect";
        response.status = 400;
        return response;
    }

    // QUERY
    // http://localhost:8080/api/register?username=dusklight00&firstName=dusk&lastName=light&email=r.rahul.developer@gmail.com&mobileNumber=999&address=boston&city=bangalore&state=karnataka&password=password&aadhar=999&pincode=123&gender=male
    @GetMapping(path = "/register")
    public Response login(@ModelAttribute User user) {
        userRepository.save(user);
        Response response = new Response();
        response.message = "Registration Successful";
        response.status = 200;
        return response;
    }

    @GetMapping(path = "/get-user")
    public User getUser(@RequestParam String aadhar) {
        User user = userRepository.findByAadhar(aadhar);
        return user;
    }

    @GetMapping("/change-password")
    public Response changePassword(
            @RequestParam String email,
            @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        Response response = new Response();
        response.message = "Password Changed Successfully";
        response.status = 200;
        return response;
    }

    @GetMapping("/get-user-by-aadhar")
    public User getUserByAadhar(@RequestParam String aadhar) {
        User user = userRepository.findByAadhar(aadhar);
        return user;
    }
}
