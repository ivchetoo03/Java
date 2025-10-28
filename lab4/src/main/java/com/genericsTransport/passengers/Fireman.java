package com.genericsTransport.passengers;

import java.util.ArrayList;
import java.util.Arrays;

public class Fireman extends Passenger{
    
    private String rank;
    private static final ArrayList<String> ranks = new ArrayList<String>(Arrays.asList("Firefighter", "Engineer", "Apparatus operator", "Driver operator", "Lieutenant", "Captain","Battalion Chief","District Chief","Division Chief","Assistant Chief","Deputy Chief","Fire Chief"));

    public Fireman(String name, int age, String rank){
        super(name, age);
        if(!ranks.contains(rank)){
            throw new RuntimeException("\nThere is no rank '" + rank + "', please try again\n");
        }
        this.rank = rank;
    }

    @Override
    public String toString(){
        return "Fireman: " + name + ", " + age + ", " + rank;
    }
}
