package com.example.flightmodule.service;

import com.example.flightmodule.entity.Aircraft;

import java.util.List;

public interface AircraftService {

    List<Aircraft> findAll();

    Aircraft findById(int theId);

    Aircraft save(Aircraft theAircraft);

    void deleteById(int theId);

}
