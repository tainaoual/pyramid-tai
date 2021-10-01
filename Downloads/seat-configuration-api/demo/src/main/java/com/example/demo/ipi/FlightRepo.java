package com.example.demo.ipi;

import org.springframework.data.repository.CrudRepository;
//repo for plan
public interface FlightRepo extends CrudRepository<Flight, String> {
//    Iterable<Flight> findByFlightId(Long flightId);

}

