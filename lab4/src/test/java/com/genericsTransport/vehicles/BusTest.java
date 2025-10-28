package com.genericsTransport.vehicles;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import com.genericsTransport.passengers.Passenger;

public class BusTest {
    
    private Bus<Passenger> bus;
    private Passenger passenger;

    @Before
    public void setUp() {
        bus = new Bus<>("Bohdan", 30, "BX9383ВВ");
        passenger = new Passenger("John", 25);
    }

    // додавання пасажира коли автобус не на рейсі
    @Test
    public void test_add_to_parked_bus() {
        assertThrows(RuntimeException.class, () -> bus.addPassenger(passenger));
    }
    
    // видалення пасажира, коли автобус порожній
    @Test
    public void test_end_duty_when_passenger() {
        bus.startDuty();
        bus.addPassenger(passenger);
        assertThrows(RuntimeException.class, () -> bus.endDuty());
    }
    
    // початок рейсу двічі
    @Test
    public void test_double_start() {
        bus.startDuty();
        assertThrows(RuntimeException.class, () -> bus.startDuty());
    }
    
    // закінчення рейсу, якого не було
    @Test
    public void test_end_parked_bus() {
        assertThrows(RuntimeException.class, () -> bus.endDuty());
    }
    
    // закінчення рейсу, коли в атобусі залишились пасажири
    @Test
    public void test_end_with_passengers() {
        bus.startDuty();
        bus.addPassenger(passenger);
        assertThrows(RuntimeException.class, () -> bus.endDuty());
    }
    
    // повна перевірка діяльності автобуса
    @Test
    public void test_full_bus_route() {
        // початок рейсу
        bus.startDuty();
        assertTrue(bus.ifOnDuty());

        // додавання пасажирів
        bus.addPassenger(passenger);
        assertEquals(1, bus.getTakenSpots());

        // видалення пасажира
        bus.removePassenger(passenger);
        assertEquals(0, bus.getTakenSpots());

        // закінчення рейсу
        bus.endDuty();
        assertTrue(!bus.ifOnDuty());
    }
}