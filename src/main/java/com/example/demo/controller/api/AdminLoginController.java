package com.example.demo.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Response;

@RestController
@RequestMapping("/api")
public class AdminLoginController {

    @GetMapping("/admin-login")
    public Response adminLogin(
            @RequestParam String username,
            @RequestParam String password) {
        String ADMIN_USERNAME = "admin";
        String ADMIN_PASSWORD = "admin";

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            Response response = new Response();
            response.message = "Login Successful";
            response.status = 200;
            return response;
        } else {
            Response response = new Response();
            response.message = "Username or Password is incorrect";
            response.status = 400;
            return response;
        }
    }
}
