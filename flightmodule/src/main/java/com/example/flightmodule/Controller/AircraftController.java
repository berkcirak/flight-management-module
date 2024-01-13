package com.example.flightmodule.Controller;

import com.example.flightmodule.entity.Aircraft;
import com.example.flightmodule.service.AircraftService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aircrafts")
public class AircraftController {

    private AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService){
        this.aircraftService=aircraftService;
    }

    @GetMapping("/list")
    public String listAircrafts(Model theModel){
        List<Aircraft> theAircrafts=aircraftService.findAll();
        theModel.addAttribute("aircrafts",theAircrafts);
        return "aircrafts/list-aircrafts";
    }


    @GetMapping("/add")
    public String showFormForAdd(Model theModel){
        Aircraft theAircraft=new Aircraft();
        theModel.addAttribute("aircraft",theAircraft);
        return "aircrafts/add-aircraft";
    }


    @PostMapping("/save")
    public String saveAircraft(@ModelAttribute("aircraft") Aircraft theAircraft){
        aircraftService.save(theAircraft);
        return "redirect:/aircrafts/list";
    }

    @GetMapping("/update")
    public  String update(@RequestParam("aircraftId")int theId, Model theModel){
        Aircraft theAircraft=aircraftService.findById(theId);
        theModel.addAttribute("aircraft",theAircraft);
        return "aircrafts/add-aircraft";
    }

    @GetMapping("/delete")
    public String deleteAircraft(@RequestParam("aircraftId") int theId){
        aircraftService.deleteById(theId);
        return "redirect:/aircrafts/list";
    }




}
