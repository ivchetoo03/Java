package com.genericsTransport.passengersTests;

import org.junit.Test;
import static org.junit.Assert.*;
import com.genericsTransport.passengers.Passenger;

public class PassengerTest {

    // перевірка створення та правильного формату виведення інформації
    @Test
    public void test_create_passenger() {
        Passenger passenger1 = new Passenger("Alice", 30);
        assertEquals("Passenger: Alice, 30", passenger1.toString());
    }
}
