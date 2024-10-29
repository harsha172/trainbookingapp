package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "main-page.html";
    }

    @GetMapping("/admin-login")
    public String adminLoginPage() {
        return "admin-login-page.html";
    }

    @GetMapping("/book-ticket")
    public String bookTicketPage() {
        return "book-ticket-page.html";
    }

    @GetMapping("/cancel-ticket")
    public String cancelTicketPage() {
        return "cancel-ticket-page.html";
    }

    @GetMapping("/create-train")
    public String createTrainPage() {
        return "create-train-page.html";
    }

    @GetMapping("/delete-train")
    public String deleteTrainPage() {
        return "delete-train-page.html";
    }

    @GetMapping("/edit-train")
    public String editTrainPage() {
        return "edit-train-page.html";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "forgot-password-page.html";
    }

    @GetMapping("/passanger-details")
    public String passangerDetailsPage() {
        return "passanger-details-page.html";
    }

    @GetMapping("/payment")
    public String paymentPage() {
        return "payment-page.html";
    }

    @GetMapping("/reset-password")
    public String resetPasswordPage() {
        return "reset-password-page.html";
    }

    @GetMapping("/search-booked-ticket-details")
    public String searchBookTicketDetailsPage() {
        return "search-booked-ticket-details-page.html";
    }

    @GetMapping("/search-train")
    public String ticketSearchPage() {
        return "search-train.html";
    }

    @GetMapping("/user-dashboard")
    public String userDashboardPage() {
        return "user-dashboard-page.html";
    }

    @GetMapping("/user-login")
    public String userLoginPage() {
        return "user-login-page.html";
    }

    @GetMapping("/user-register")
    public String userRegisterPage() {
        return "user-register-page.html";
    }

    @GetMapping("/view-booked-detail")
    public String viewBookedDetailPage() {
        return "view-booked-detail-page.html";
    }

    @GetMapping("/view-booked-ticket")
    public String viewBookedTicketPage() {
        return "view-booked-ticket-page.html";
    }

    @GetMapping("/admin-dashboard")
    public String adminDasboard() {
        return "admin-dashboard-page.html";
    }
}
