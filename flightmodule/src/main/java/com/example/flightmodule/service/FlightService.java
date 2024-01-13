package com.example.flightmodule.service;

import com.example.flightmodule.entity.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> findAll();
    Flight save(Flight flight);
    Flight findById(int id);
    void deleteById(int id);


}
