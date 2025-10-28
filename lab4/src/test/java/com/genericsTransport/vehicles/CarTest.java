package com.genericsTransport.vehicles;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import com.genericsTransport.passengers.*;
import static org.junit.Assert.*;

public class CarTest {

    private Car<Passenger> car;

    @Before
    public void setUp(){
        car = new Car<>("BYD", 3, "AI3322BC");
    }

    // додавання пасажира в авто (функції отримання інформації про місця)
    @Test
    public void test_add_passenger() {
        Passenger passenger1 = new Passenger("Tom", 25);
        car.addPassenger(passenger1);
        assertEquals(3, car.getCapacity()); 
        assertEquals(1, car.getTakenSpots());
    }
    
    // додавання пасажира, коли всі місця зайняті
    @Test
    public void test_car_full() {
        ArrayList<Passenger> passengersList = new ArrayList<Passenger>() {{
            add(new Passenger("Bella", 17));
            add(new Passenger("Edward", 120));
            add(new Passenger("Jacob", 16));
        }};
        car.addPassengerList(passengersList);
        assertThrows(RuntimeException.class, () -> car.addPassenger(new Passenger("Carlisle", 200)));
    }

    // додавання різних типів пасажирів
    @Test
    public void test_different_passenger_types() {
        ArrayList<Passenger> passengersList = new ArrayList<Passenger>() {{
            add(new Fireman("Bella", 17, "Fire Chief"));
            add(new Policeman("Edward", 120, "Detective"));
            add(new Passenger("Jacob", 16));
        }};
        car.addPassengerList(passengersList);
        assertEquals(3, car.getCapacity());
    }
    
    // вивід інформації про автомобіль
    @Test
    public void test_car_info() {
        String s = car.toString();
        assertTrue(s.contains("BYD") && s.contains("AI3322BC"));
    }
}