package com.example.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Response;
import com.example.demo.entity.Train;
import com.example.demo.repository.TrainRepository;

@RestController
@RequestMapping("/api")
public class TrainController {

    @Autowired
    private TrainRepository trainRepository;

    // QUERY
    // http://localhost:8080/api/create-train?trainName=dusky_train&trainNumber=212&source=patna&destination=bangalore&date=17-07-2024&time=23:41
    @GetMapping("/create-train")
    public Response createTrain(@ModelAttribute Train train) {
        trainRepository.save(train);
        Response response = new Response();
        response.message = "Train Created Successfully";
        response.status = 200;
        return response;
    }

    @GetMapping("/edit-train")
    public Response editTrain(@ModelAttribute Train train) {
        String trainId = train.getTrainNumber();

        if (trainRepository.existsById(trainId)) {
            Train existingTrain = trainRepository.findById(trainId).get();
            if (train.getTrainName() != null) {
                existingTrain.setTrainName(train.getTrainName());
            }
            if (train.getSource() != null) {
                existingTrain.setSource(train.getSource());
            }
            if (train.getDestination() != null) {
                existingTrain.setDestination(train.getDestination());
            }
            if (train.getDate() != null) {
                existingTrain.setDate(train.getDate());
            }
            if (train.getTime() != null) {
                existingTrain.setTime(train.getTime());
            }

            trainRepository.save(existingTrain);
            Response response = new Response();
            response.message = "Train Edited Successfully";
            response.status = 200;
            return response;
        } else {
            Response response = new Response();
            response.message = "Train Not Found";
            response.status = 404;
            return response;
        }
    }

    // QUERY
    // http://localhost:8080/api/delete-train?trainId=212
    @GetMapping("/delete-train")
    public Response deleteTrain(@RequestParam String trainId) {
        trainRepository.deleteById(trainId);
        Response response = new Response();
        response.message = "Train Deleted Successfully";
        response.status = 200;
        return response;
    }

    @GetMapping("/all-trains")
    public Iterable<Train> allTrains() {
        return trainRepository.findAll();
    }

    @GetMapping("/search-train-by-id")
    public Train searchTrainById(@RequestParam String trainId) {
        return trainRepository.findById(trainId).get();
    }

    @GetMapping("/search-train")
    public Iterable<Train> searchTicket(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String date) {
        // return trainRepository.findAll();
        return trainRepository.findAllBySourceAndDestinationAndDate(
                source,
                destination,
                date);
    }
}
