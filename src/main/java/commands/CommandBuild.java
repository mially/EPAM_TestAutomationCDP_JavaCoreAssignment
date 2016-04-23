package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.managers.PlayroomsManager;
import com.epam.cdpWeek2project.managers.ToysManager;
import com.epam.cdpWeek2project.models.Playroom;

import java.util.Arrays;

public class CommandBuild implements Command {
    PlayroomsManager playroomsManager;
    PlayersManager playersManager;
    ToysManager toysManager;

    public CommandBuild(PlayersManager playersManager, PlayroomsManager playroomsManager, ToysManager toysManager) {
        this.playersManager = playersManager;
        this.playroomsManager = playroomsManager;
        this.toysManager = toysManager;
    }

    @Override
    public void run(String[] userInput) {
        String mainCommand;

        try {
            mainCommand = userInput[0].toUpperCase();
            String[] otherCommands = Arrays.copyOfRange(userInput, 1, userInput.length);
            try {
                SubCommandsBuild.valueOf(mainCommand).run(otherCommands, playersManager, playroomsManager, toysManager);
            } catch (Exception e) {
                System.out.println("Illegal argument. Use [playroom], [player] or [toy] as a first [build] argument");
            }
        } catch (IndexOutOfBoundsException e) {
            //creates default playroom on 0 args
            String name = playroomsManager.generatePlayroomName();
            System.out.println("Building default Playroom...");
            Playroom playroom = playroomsManager.addPlayroom(name);
            System.out.println(playroom.getName() + " is created. You are inside.");
        }
    }

    @Override
    public String getCommand() {
        return "build";
    }
}
