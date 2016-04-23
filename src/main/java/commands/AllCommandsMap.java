package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.strings.HelpStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllCommandsMap {
    private final Map<String, Command> commands;

    private AllCommandsMap() {
        commands = new HashMap<>();
    }

    public void run(String[] userInput){
        String mainUserCommand = userInput[0];
        String[] otherCommands = Arrays.copyOfRange(userInput, 1, userInput.length);
        Command command = commands.get(mainUserCommand);
        if (command != null) {
            command.run(otherCommands);
        } else {
            System.out.println(HelpStrings.INVALID_COMMAND);
        }
    }

    public static AllCommandsMap build(List<Command> inputCommands){
        AllCommandsMap result = new AllCommandsMap();
        for(Command command : inputCommands) {
            result.commands.put(command.getCommand(), command);
        }
        return result;
    }

}
