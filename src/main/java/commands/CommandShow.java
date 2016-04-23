package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.managers.PlayroomsManager;
import com.epam.cdpWeek2project.managers.ToysManager;
import com.epam.cdpWeek2project.models.Playroom;

public class CommandShow implements Command {
    private PlayroomsManager playroomsManager;
    private PlayersManager playersManager;
    private ToysManager toysManager;

    public CommandShow(PlayroomsManager playroomsManager, PlayersManager playersManager, ToysManager toysManager){
        this.playersManager = playersManager;
        this.playroomsManager = playroomsManager;
        this.toysManager = toysManager;
    }

    @Override
    public void run(String[] userInput) {
        String mainCommand;
        String name;

        try {
            mainCommand = userInput[0];
            try {
                name = userInput[1];

                switch (mainCommand) {
                    case "playroom":
                        playroomsManager.showPlayroomByName(name);
                        break;
                    case "player":
                        playersManager.showPlayer(name);
                        break;
                    case "toy":
                        toysManager.showToyByName(name);
                        break;
                    default:
                        System.out.println("Illegal argument. Use [playroom], [player] or [toy]" +
                                "as a first [show] argument");
                }
            } catch (IndexOutOfBoundsException e) {
                //if second arg is null
                switch (mainCommand) {
                    case "playroom":
                        playroomsManager.show();
                        break;
                    case "player":
                        playersManager.show();
                        break;
                    case "toy":
                        Playroom activePlayroom = playroomsManager.getActivePlayroom();
                        toysManager.showToysInPlayroom(activePlayroom);
                        break;
                    default:
                        System.out.println("Illegal argument. Use [playroom], [player] or [toy] " +
                                "as a first [show] argument");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            //shows full state on 0 args
            playroomsManager.show();
            playersManager.show();
        }
    }

    @Override
    public String getCommand() {
        return "show";
    }
}
