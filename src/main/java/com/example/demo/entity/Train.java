package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Train {

    @Id
    private String train_number;

    private String train_name;
    private String source;
    private String destination;
    private String date;
    private String time;

    public String getTrainNumber() {
        return train_number;
    }

    public void setTrainNumber(String trainNumber) {
        this.train_number = trainNumber;
    }

    public String getTrainName() {
        return train_name;
    }

    public void setTrainName(String trainName) {
        this.train_name = trainName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    // TODO : these String can be parsed into Date using SimpleDateFormat

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
