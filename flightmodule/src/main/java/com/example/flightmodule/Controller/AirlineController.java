package com.example.flightmodule.Controller;

import com.example.flightmodule.entity.Airline;
import com.example.flightmodule.service.AirlineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/airlines")
public class AirlineController {

    private AirlineService airlineService;

    public AirlineController(AirlineService airlineService){
        this.airlineService=airlineService;
    }

    @GetMapping("/list")
    public String listAirlines(Model theModel){
        List<Airline> theAirlines=airlineService.findAll();
        theModel.addAttribute("airlines",theAirlines);
        return "airlines/list-airlines";
    }
    @GetMapping("/add")
    public String showFormForAdd(Model theModel){
        Airline theAirline=new Airline();
        theModel.addAttribute("airline",theAirline);
        return "airlines/add-airline";
    }

    @PostMapping("/save")
    public String saveAirline(@ModelAttribute("airline") Airline theAirline){
        airlineService.save(theAirline);
        return "redirect:/airlines/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("airlineId")int theId, Model theModel){
        Airline theAirline=airlineService.findById(theId);
        theModel.addAttribute("airline",theAirline);
        return "airlines/add-airline";
    }

    @GetMapping("/delete")
    public String deleteAirline(@RequestParam("airlineId") int theId){
        airlineService.deleteById(theId);
        return "redirect:/airlines/list";
    }




}
