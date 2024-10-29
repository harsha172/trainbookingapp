package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Train;

public interface TrainRepository extends CrudRepository<Train, String> {
    public Iterable<Train> findAllBySourceAndDestinationAndDate(
            String source,
            String destination,
            String date);
}
