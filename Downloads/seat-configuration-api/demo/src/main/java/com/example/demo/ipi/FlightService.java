package com.example.demo.ipi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// service class
@Service
public class FlightService {
    @Autowired

    private FlightRepo flightRepo;


    public Flight newFlight() {
        Flight object = new Flight();
        object.setId(java.util.UUID.randomUUID().toString());
        object.getSeatNumber();
        object.setSize("3");

        return object;

    }

public Iterable<Flight> retrieveAllFlights(){
    return flightRepo.findAll();
}
    public void saveFlight(Flight flightToSave){
      flightRepo.save(flightToSave);
    }
    public Flight[] findbigPlan() {

return findSmallPlain();
    }

    public Flight[] findSmallPlain() {
return findbigPlan();
    }

}