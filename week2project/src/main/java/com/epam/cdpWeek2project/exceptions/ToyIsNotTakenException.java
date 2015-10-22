package com.epam.cdpWeek2project.exceptions;

public class ToyIsNotTakenException extends Exception{
    public ToyIsNotTakenException () {
        super("You can't return this toy, you don't have it!");
    }
}
