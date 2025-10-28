package com.genericsTransport.passengers;
import java.util.ArrayList;
import java.util.Arrays;

public class Policeman extends Passenger{
    
    private String rank;
    private static final ArrayList<String> ranks = new ArrayList<String>(Arrays.asList("Police Officer", "Detective", "Sergeant", "Lieutenant", "Captain", "Deputy Chief", "Assistant Chief","Chief of Police","Commissioner"));

    public Policeman(String name, int age, String rank){
        super(name, age);
        if(!ranks.contains(rank)){
            throw new RuntimeException("\nThere is no rank '"+ rank +"', please try again\n");
        }
        this.rank = rank;
    }

    @Override
    public String toString(){
        return "Policeman: " + name + ", " + age + ", " + rank;
    }
}
