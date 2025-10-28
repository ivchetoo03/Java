package com.genericsTransport.road;

import org.junit.Test;
import static org.junit.Assert.*;

import com.genericsTransport.vehicles.Car;
import com.genericsTransport.passengers.Passenger;

public class RoadTest {
    
    // підрахунок кількості пасажирів на дорозі
    @Test
    public void test_count_road_passengers() {
        Road road = new Road();
        
        Car<Passenger> car1 = new Car<>("Lexus", 5, "AP3462AC");
        Car<Passenger> car2 = new Car<>("Opel", 8, "BX0292EA");
        
        car1.addPassenger(new Passenger("Johnny", 1));
        car1.addPassenger(new Passenger("Johnny", 2));
        car2.addPassenger(new Passenger("Yes-Papa", 3));
        
        road.addVehicle(car1);
        road.addVehicle(car2);
        
        assertEquals(3, road.getCountOfPassengers());
    }
    
    // додавання одного автомобіля 2 рази
    @Test
    public void test_add_same_car() {
        Road road = new Road();
        Car<Passenger> car1 = new Car<>("Peugeot", 5, "CB9553AA");
        road.addVehicle(car1);
        assertThrows(RuntimeException.class, () -> road.addVehicle(car1));
    }
    
    // видалення автомобіля, якого немає на дорозі
    @Test
    public void test_remove_car_thats_not_on_the_road() {
        Road road = new Road();
        Car<Passenger> car1 = new Car<>("Kia", 4, "AO7429BB");
        assertThrows(RuntimeException.class, () -> road.removeVehicle(car1));
    }
}
