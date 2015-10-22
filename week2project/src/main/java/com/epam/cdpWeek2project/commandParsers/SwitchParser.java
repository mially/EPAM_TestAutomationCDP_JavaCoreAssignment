package com.epam.cdpWeek2project.commandParsers;


import com.epam.cdpWeek2project.exceptions.NoPlayroomException;
import com.epam.cdpWeek2project.exceptions.NoUserException;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.managers.PlayroomsManager;
import com.epam.cdpWeek2project.managers.ToysManager;

public class SwitchParser {
    public static void parse(String[] userCommands, PlayroomsManager playroomManager,
        PlayersManager playersManager, ToysManager toysManager) {
        String name;

        try {
            String mainCommand = userCommands[0];
            name = userCommands[1];

            switch (mainCommand) {
                case "playroom":
                    playroomManager.switchTo(name);
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
}