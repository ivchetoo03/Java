package com.genericsTransport.vehicles;

import org.junit.Test;
import static org.junit.Assert.*;

import com.genericsTransport.passengers.Fireman;

public class FireTruckTest {

    @Test
    public void test_double_fire_alert() {
        FireTruck ft = new FireTruck("FT", 3, "FT-1");
        ft.informAboutActiveFire();
        assertThrows(RuntimeException.class, () -> ft.informAboutActiveFire());
    }

    @Test
    public void test_fire_mission() {
        FireTruck ft = new FireTruck("FT", 3, "FT-2");
        Fireman f = new Fireman("FM", 30, "Captain");
        ft.addPassenger(f);
        ft.informAboutActiveFire();
        ft.startDuty();

        // while onDuty and activeFire, adding a passenger should throw
        assertThrows(RuntimeException.class, () -> ft.addPassenger(new Fireman("X", 25, "Lieutenant")));

        // extinguish fire and then end duty
        ft.extinguishFire();
        ft.endDuty();
        String s = ft.toString();
        assertTrue(s.contains("On duty - false") || s.contains("Assigned active fire  - false"));
    }
}
