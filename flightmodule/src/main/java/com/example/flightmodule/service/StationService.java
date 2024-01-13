package com.example.flightmodule.service;

import com.example.flightmodule.entity.Station;

import java.util.List;

public interface StationService {

    List<Station> findAll();
    Station save(Station station);
    Station findById(int id);
    void deleteById(int id);

}
