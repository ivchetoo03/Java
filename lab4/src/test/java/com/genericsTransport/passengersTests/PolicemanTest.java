package com.genericsTransport.passengersTests;

import org.junit.Test;
import static org.junit.Assert.*;
import com.genericsTransport.passengers.Policeman;

public class PolicemanTest {

    // перевірка створення та правильного формату виведення інформації
    @Test
    public void test_create_policeman() {
        Policeman policeman1 = new Policeman("Clark", 35, "Sergeant");
        assertEquals("Policeman: Clark, 35, Sergeant", policeman1.toString());
    }

    // перевірка введення хибного звання
    @Test
    public void test_wrong_rank() {
        assertThrows(RuntimeException.class, () -> new Policeman("Dave", 29, "NoSuchRank"));
    }
}
