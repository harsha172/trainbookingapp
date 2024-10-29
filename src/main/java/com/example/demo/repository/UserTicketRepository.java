package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.UserTicket;

public interface UserTicketRepository
        extends CrudRepository<UserTicket, Integer> {
    Iterable<UserTicket> findAllByPnr(String pnr);
}
