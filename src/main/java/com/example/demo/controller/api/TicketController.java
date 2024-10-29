package com.example.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Response;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.UserTicket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserTicketRepository;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserTicketRepository userTicketRepository;

    // QUERY
    // http://localhost:8080/api/create-ticket?pnr=123&trainId=123&paymentMethod=netbanking&amount=2500&passengerEmail=r.rahul.developer@gmail.com&passengerMobileNumber=8002030975
    @GetMapping("/create-ticket")
    public Response createTicket(@ModelAttribute Ticket ticket) {
        ticketRepository.save(ticket);
        Response response = new Response();
        response.message = "Ticket Created Successfully";
        response.status = 200;
        return response;
    }

    // QUERY
    // http://localhost:8080/api/add-user?pnr=12390&name=dusklight&age=19&gender=male&preference=upper&className=UP&price=2000&seatNumber=SUB1
    @GetMapping("/add-user")
    public Response addUser(@ModelAttribute UserTicket userTicket) {
        userTicketRepository.save(userTicket);
        Response response = new Response();
        response.message = "User Ticket Created Successfully";
        response.status = 200;
        return response;
    }

    @GetMapping("/all-ticket")
    public Iterable<Ticket> allTicket() {
        Iterable<Ticket> iterable = ticketRepository.findAll();
        return iterable;
    }

    // TODO - Research on what is the difference between Optional and Iterable

    // QUERY
    // http://localhost:8080/api/get-user-ticket?pnr=123
    @GetMapping("/get-user-ticket")
    public Iterable<UserTicket> getUserTicket(@RequestParam String pnr) {
        Iterable<UserTicket> userTicket = userTicketRepository.findAllByPnr(pnr);
        return userTicket;
    }

    // QUERY
    // http://localhost:8080/api/get-ticket?pnr=123
    @GetMapping("/get-ticket")
    public Ticket getTicket(@RequestParam String pnr) {
        Ticket ticket = ticketRepository.findByPnr(pnr);
        return ticket;
    }

    @GetMapping("/cancel-ticket")
    public Response cancelTicket(@RequestParam String pnr) {
        Response response = new Response();
        Ticket ticket = ticketRepository.findByPnr(pnr);
        if (ticket != null) {
            ticketRepository.delete(ticket);
            response.message = "Ticket Cancelled Successfully";
            response.status = 200;
        } else {
            response.message = "Ticket Not Found";
            response.status = 404;
        }
        return response;
    }

    @GetMapping("/get-all-user-ticket")
    public Iterable<Ticket> getAllUserTicket(@RequestParam String email) {
        Iterable<Ticket> tickets = ticketRepository.findAllByEmail(email);
        return tickets;
    }
}
