package com.genericsTransport.vehicles;

import org.junit.Test;
import static org.junit.Assert.*;

import com.genericsTransport.passengers.Passenger;
import java.util.ArrayList;

public class VehicleTest {

    // пересадка пасажирів з різних автомобілів
    @Test
    public void test_transfer_passengers() {
        Car<Passenger> carToTransferFrom = new Car<>("Mitsubish", 5, "5274");
        Car<Passenger> carToTransferTo = new Car<>("Nissan", 5, "S-1");

        Passenger a = new Passenger("Michael", 20);
        Passenger b = new Passenger("Jeremy", 21);

        carToTransferFrom.addPassenger(a);
        carToTransferFrom.addPassenger(b);

        carToTransferTo.transferFrom(carToTransferFrom);

        assertEquals(2, carToTransferTo.getTakenSpots());
        assertEquals(0, carToTransferFrom.getTakenSpots());
    }

    // пересадка пасажирів з автомобіля без пасажирів
    @Test
    public void test_transfer_from_empty() {
        Car<Passenger> carToTransferFrom = new Car<>("Mitsubish", 5, "5274");
        Car<Passenger> carToTransferTo = new Car<>("Nissan", 5, "S-1");
        assertThrows(RuntimeException.class, () -> carToTransferTo.transferFrom(carToTransferFrom));
    }
    
    // додавання групи пасажирів
    @Test
    public void test_add_passenger_group() {
        Car<Passenger> car = new Car<>("Toyota", 3, "AA1774BM");
        ArrayList<Passenger> list = new ArrayList<>();
        list.add(new Passenger("John", 34));
        list.add(new Passenger("Emma", 28));
        car.addPassengerList(list);
        assertEquals(2, car.getTakenSpots());
        
        ArrayList<Passenger> tooMany = new ArrayList<>();
        tooMany.add(new Passenger("Bobby", 45));
        tooMany.add(new Passenger("Sarah", 31));
        tooMany.add(new Passenger("Darryl", 29));
        assertThrows(RuntimeException.class, () -> car.addPassengerList(tooMany));
    }
    
    // видалення пасажирів
    @Test
    public void test_remove_passengers() {
        Car<Passenger> car = new Car<>("Honda", 3, "BB5678CC");
        Passenger p = new Passenger("Robert Miller", 52);

        car.addPassenger(p);
        assertEquals(1, car.getTakenSpots());

        car.removePassenger(p);
        assertEquals(0, car.getTakenSpots());

        car.addPassenger(new Passenger("Alice Johnson", 27));
        car.addPassenger(new Passenger("Brian Clark", 39));
        car.removeAllPassengers();
        assertEquals(0, car.getTakenSpots());
    }
}