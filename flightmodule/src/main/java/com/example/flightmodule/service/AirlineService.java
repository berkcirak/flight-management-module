package com.example.flightmodule.service;

import com.example.flightmodule.entity.Airline;

import java.util.List;

public interface AirlineService {

    List<Airline> findAll();
    Airline findById(int theId);
    Airline save(Airline theAirline);
    void deleteById(int theId);

}
