package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, String> {
    public Ticket findByPnr(String pnr);

    public Iterable<Ticket> findAllByEmail(String email);
}
