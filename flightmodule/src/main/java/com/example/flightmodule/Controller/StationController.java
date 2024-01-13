package com.example.flightmodule.Controller;

import com.example.flightmodule.entity.Station;
import com.example.flightmodule.service.StationService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/stations")
public class StationController {

    private StationService stationService;

    public StationController(StationService stationService){
        this.stationService=stationService;
    }
    @GetMapping("/list")
    public String listStations(Model theModel){
        List<Station> stationList=stationService.findAll();
        theModel.addAttribute("stations",stationList);
        return "stations/list-stations";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model theModel){
        Station theStation=new Station();
        theModel.addAttribute("station",theStation);
        return "stations/add-station";
    }

    @PostMapping("/save")
    public String addStation(@ModelAttribute("station") Station station){
        stationService.save(station);
        return "redirect:/stations/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("stationId")int theId,Model theModel){
        Station station=stationService.findById(theId);
        theModel.addAttribute("station",station);
        return "stations/add-station";
    }

    @GetMapping("/delete")
    public String deleteStation(@RequestParam("stationId") int id){
        stationService.deleteById(id);
        return "redirect:/stations/list";
    }
}
