package com.epam.cdpWeek2project.commands;

public interface Command {
    public void run(String[] userInput);

    public String getCommand();
}
