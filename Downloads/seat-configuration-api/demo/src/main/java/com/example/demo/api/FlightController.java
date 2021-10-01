package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//controler class
@RestController
public class FlightController {
//    @Autowired
//    private FlightService flightService;
//    @RequestMapping(method= RequestMethod.GET, value="/flights", produces={"application/xml"})
//    public Flight getFlight() {
//        return flightService.newFlight();
//    }

    private final FlightRepo flightRepo;

    public FlightController(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    @PostMapping("/flight")
    public ResponseEntity<Flight> save(@RequestBody Flight flight) {
        try {
            return new ResponseEntity<>(flightRepo.save(flight), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
