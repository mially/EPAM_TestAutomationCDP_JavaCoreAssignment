package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.exceptions.NoPlayroomException;
import com.epam.cdpWeek2project.exceptions.NoUserException;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.managers.PlayroomsManager;

public class CommandSwitch implements Command {
    private PlayersManager playersManager;
    private PlayroomsManager playroomsManager;

    public CommandSwitch(PlayersManager playersManager, PlayroomsManager playroomsManager){
        this.playersManager = playersManager;
        this.playroomsManager = playroomsManager;
    }

    @Override
    public void run(String[] userInput) {
        String name;

        try {
            String mainCommand = userInput[0];
            name = userInput[1];

            switch (mainCommand) {
                case "playroom":
                    playroomsManager.switchTo(name);
                    break;
                case "player":
                    playersManager.switchTo(name);
                    break;
                default:
                    System.out.println("Correct command to switch (to playroom or player): [switch playroom|player name]");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correct command to switch (to playroom or player): [switch playroom|player name]");
        } catch (NoUserException e) {
            System.out.println(e.getMessage());
        } catch (NoPlayroomException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getCommand() {
        return "switch";
    }
}
