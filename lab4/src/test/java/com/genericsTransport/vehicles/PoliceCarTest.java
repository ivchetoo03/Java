package com.genericsTransport.vehicles;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import com.genericsTransport.passengers.Policeman;

public class PoliceCarTest {

    private PoliceCar policecar1;

    @Before
    public void setUp(){
        policecar1 = new PoliceCar("Toyota", 4, "1577");
    }
    
    // почати погоню, коли автомобіль не на чергуванні
    @Test
    public void test_chase_when_parked() {
        assertThrows(RuntimeException.class, () -> policecar1.startChase());
    }

    // почати погоню, коли автомобіль вже в погоні
    @Test
    public void test_chase_when_chasing() {
        policecar1.startDuty();
        policecar1.startChase();
        assertThrows(RuntimeException.class, () -> policecar1.startChase());
    }

    // закінчити погоню, якої не було
    @Test
    public void test_end_chase_when_no_chase() {
        policecar1.startDuty();
        assertThrows(RuntimeException.class, () -> policecar1.stopChase());
    }

    // додавання пасажира під час погоні 
    @Test
    public void test_chase() {
        PoliceCar policeCar1 = new PoliceCar("Mitsubishi", 3, "2944");
        policeCar1.startDuty();
        policeCar1.startChase();
        assertThrows(RuntimeException.class, () -> policeCar1.addPassenger(new Policeman("Off", 40, "Sergeant")));
    }
}
