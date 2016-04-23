package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.commandParsers.*;
import com.epam.cdpWeek2project.factories.PlayroomFactory;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.managers.PlayroomsManager;
import com.epam.cdpWeek2project.managers.ToysManager;
import com.epam.cdpWeek2project.models.Playroom;
import com.epam.cdpWeek2project.strings.HelpStrings;

/**
 * Sub commands for Build command
 */
public enum SubCommandsBuild {
    PLAYROOM {
        public void run(String[] userInput, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            try {
                String name = userInput[0];
                System.out.println("Building Playroom...");
                Playroom playroom = playroomsManager.addPlayroom(name);
                System.out.println(playroom.getName() + " is created. You are inside.");

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Specify name to build a playroom. " +
                        "E.g. [build playroom test]");
            }
        }
    },

    PLAYER {
        public void run(String[] userInput, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            try {
                String name = userInput[0];
                playersManager.addPlayer(name, playroomsManager.getActivePlayroom());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Specify name to build a player. e.g. [build player masha]");
            }
        }
    },

    TOY {
        public void run(String[] userInput, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager) {
            try {
                String name = userInput[0];
                String type = userInput[1];
                toysManager.addToy(name, type, playroomsManager);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Specify name and type to build a toy. e.g. [build toy SoccerBall Ball]");
            }
        }
    };

    public abstract void run(String[] userInput, PlayersManager playersManager, PlayroomsManager playroomsManager,
        ToysManager toysManager);
}
