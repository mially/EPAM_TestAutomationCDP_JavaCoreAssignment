package com.epam.cdpWeek2project.exceptions;

public class NoUserException extends Exception{
    public NoUserException(){
        super("No such user!");
    }
}
