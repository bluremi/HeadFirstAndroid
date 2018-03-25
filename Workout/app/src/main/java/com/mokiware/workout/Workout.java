package com.mokiware.workout;

/**
 * Created by Phil on 12/16/2017.
 */

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener","5 handstand push-ups\n10 1-legged squate\n15 pullups"),
            new Workout("Core Agony","100 pull-ups\n100 Push-ups\n100 sit-=ups\n100 Squats"),
            new Workout("Strength and Length","500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    private Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String toString(){
        return this.name;
    }
}