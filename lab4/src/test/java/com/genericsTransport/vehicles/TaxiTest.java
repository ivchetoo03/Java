package com.genericsTransport.vehicles;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import com.genericsTransport.passengers.*;

public class TaxiTest {

    private Taxi taxi;
    
    @Before
    public void setUp(){
        taxi = new Taxi("Mazda", 4, "BB3455AB", 10);
    }

    // початок подорожі без пасажирів
    @Test
    public void test_empty_taxi_travel() {
        assertThrows(RuntimeException.class, () -> taxi.startTravel(5));
    }

    // початок подорожі без пасажирів
    @Test
    public void test_start_travel_twice() {
        Fireman fireman1 = new Fireman("Josh", 51, "Engineer");
        taxi.addPassenger(fireman1);
        taxi.startTravel(10);
        assertThrows(RuntimeException.class, () -> taxi.startTravel(5));
    }
    
    // повний цикл роботи таксі
    @Test
    public void test_taxi_trip() {
        
        Passenger passenger1 = new Passenger("Rider", 22);
        taxi.addPassenger(passenger1);
        taxi.startTravel(3);
        assertFalse(taxi.getIfAvailable());

        taxi.endTravel();
        assertTrue(taxi.getIfAvailable());
        assertEquals(0, taxi.getTakenSpots());
    }
}