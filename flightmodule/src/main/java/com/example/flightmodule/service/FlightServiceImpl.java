package com.example.flightmodule.service;

import com.example.flightmodule.entity.Flight;
import com.example.flightmodule.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{
    private FlightRepository flightRepository;
    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository){
        this.flightRepository=flightRepository;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight findById(int id) {
        Optional<Flight> result=flightRepository.findById(id);
        Flight flight=null;
        if(result.isPresent()){
            flight=result.get();
        }
        else {
            throw new RuntimeException("flight is not found");
        }
        return flight;
    }

    @Override
    public void deleteById(int id) {
        flightRepository.deleteById(id);
    }
}
