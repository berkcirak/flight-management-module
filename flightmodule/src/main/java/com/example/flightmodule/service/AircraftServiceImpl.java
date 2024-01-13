package com.example.flightmodule.service;

import com.example.flightmodule.entity.Aircraft;
import com.example.flightmodule.repo.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AircraftServiceImpl implements AircraftService{

    private AircraftRepository aircraftRepository;
    @Autowired
    private AircraftServiceImpl(AircraftRepository aircraftRepository){
        this.aircraftRepository=aircraftRepository;
    }
    @Override
    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    @Override
    public Aircraft findById(int id) {
        Optional<Aircraft> result=aircraftRepository.findById(id);
        Aircraft aircraft=null;
        if(result.isPresent()){
            aircraft=result.get();
        }
        else {
            throw new RuntimeException("aircraft is not found");
        }
        return aircraft;
    }

    @Override
    public Aircraft save(Aircraft theAircraft) {
        return aircraftRepository.save(theAircraft);
    }

    @Override
    public void deleteById(int theId) {
        aircraftRepository.deleteById(theId);
    }
}
