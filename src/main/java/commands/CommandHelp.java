package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.strings.HelpStrings;

public class CommandHelp implements Command{
    @Override
    public void run(String[] userInput) {
        System.out.println(HelpStrings.HELP);
    }

    @Override
    public String getCommand() {
        return "help";
    }
}
