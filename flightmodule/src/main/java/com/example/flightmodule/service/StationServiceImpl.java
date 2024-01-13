package com.example.flightmodule.service;

import com.example.flightmodule.entity.Station;
import com.example.flightmodule.repo.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService{

    private StationRepository stationRepository;
    @Autowired
    public StationServiceImpl(StationRepository stationRepository){
        this.stationRepository=stationRepository;
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Station save(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public Station findById(int id) {
        Optional<Station> result=stationRepository.findById(id);
        Station station=null;
        if(result.isPresent()){
            station=result.get();
        }
        else{
            throw new RuntimeException("station is not found");
        }
        return station;
    }

    @Override
    public void deleteById(int id) {
       Station station=stationRepository.findById(id).orElseThrow(() ->new RuntimeException("station not found"));
       stationRepository.delete(station);
    }
}
