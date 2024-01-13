package com.example.flightmodule.Controller;

import com.example.flightmodule.entity.Flight;
import com.example.flightmodule.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flights")
public class FlightController {

    private FlightService flightService;
    public FlightController(FlightService flightService){
        this.flightService=flightService;
    }

    @GetMapping("/add")
    public String addFlight(Model theModel){
        Flight theFlight=new Flight();
        theModel.addAttribute("flight",theFlight);
        return "flights/add-flight";
    }


    @PostMapping("/save")
    public String saveFlight(@ModelAttribute("flight") Flight flight){
        flightService.save(flight);
        return "redirect:/flights/list";
    }
    @GetMapping("/list")
    public String getFlights(Model theModel){
        List<Flight> flights=flightService.findAll();
        theModel.addAttribute("flights",flights);
        return "flights/list-flights";
    }
    @GetMapping("/update")
    public String update(@RequestParam("flightId")int theId,Model theModel){
        Flight flight=flightService.findById(theId);
        theModel.addAttribute("flight",flight);
        return "flights/add-flight";
    }
    @GetMapping("/delete")
    public String deleteFlight(@RequestParam("flightId") int theId){
        flightService.deleteById(theId);
        return "redirect:/flights/list";
    }

}
