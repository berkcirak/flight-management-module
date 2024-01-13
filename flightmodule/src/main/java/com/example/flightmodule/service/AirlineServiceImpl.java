package com.example.flightmodule.service;

import com.example.flightmodule.entity.Airline;
import com.example.flightmodule.repo.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AirlineServiceImpl implements AirlineService{

    private AirlineRepository airlineRepository;
    @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository){
        this.airlineRepository=airlineRepository;
    }

    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline findById(int id) {
        Optional<Airline> result=airlineRepository.findById(id);
        Airline airline=null;
        if(result.isPresent()){
            airline=result.get();
        }
        else {
            throw new RuntimeException("airline is not found");
        }
        return airline;
    }

    @Override
    public Airline save(Airline theAirline) {
        return airlineRepository.save(theAirline);
    }

    @Override
    public void deleteById(int id) {
        airlineRepository.deleteById(id);
    }
}
