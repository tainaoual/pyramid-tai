package com.example.demo.api;

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
    public Flight[] findBigPlane() {

return findSmallPlane();
    }

    public Flight[] findSmallPlane() {
return findBigPlane();
    }

}