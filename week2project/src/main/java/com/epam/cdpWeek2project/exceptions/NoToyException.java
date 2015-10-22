package com.epam.cdpWeek2project.exceptions;

public class NoToyException extends Exception {
    public NoToyException() {
        super("No such toy in active player playroom!");
    }
}
