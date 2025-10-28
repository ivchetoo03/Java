package com.genericsTransport.passengersTests;

import org.junit.Test;
import static org.junit.Assert.*;
import com.genericsTransport.passengers.Fireman;

public class FiremanTest {

   // перевірка створення та правильного формату виведення інформації 
   @Test
   public void test_create_fireman() {
      Fireman fireman1 = new Fireman("Bob", 40, "Captain");
      assertEquals("Fireman: Bob, 40, Captain", fireman1.toString());
   }
   
   // перевірка введення хибного звання
   @Test
   public void test_wrong_rank() {
      assertThrows(RuntimeException.class, () -> new Fireman("Eve", 28, "InvalidRank"));
   }
}
