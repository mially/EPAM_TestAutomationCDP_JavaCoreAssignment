package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.strings.HelpStrings;

public class CommandExit implements Command {
    @Override
    public void run(String[] userInput) {
        System.out.println(HelpStrings.GOODBYE);
        System.exit(0);
    }

    @Override
    public String getCommand() {
        return "exit";
    }
}
