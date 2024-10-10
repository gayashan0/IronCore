package com.fitnus.fitnusbackend.exception;

public class WorkoutNotFoundException extends RuntimeException{
    public WorkoutNotFoundException(Long id){
        super("Could not found the user with id"+id);
    }
}
