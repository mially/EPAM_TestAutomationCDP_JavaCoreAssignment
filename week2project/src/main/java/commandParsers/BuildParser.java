package commandParsers;

import managers.PlayersManager;
import managers.PlayroomsManager;
import managers.ToysManager;
import models.Player;
import models.Playroom;

public class BuildParser {

    public static void parse(String[] userCommands, PlayroomsManager playroomsManager, PlayersManager playersManager, ToysManager toysManager) {
        String mainCommand;
        String name;
        String type;

        try {
            mainCommand = userCommands[0];
            switch (mainCommand) {
                case "playroom":
                    try {
                        name = userCommands[1];
                        System.out.println("Building Playroom...");
                        Playroom playroom = playroomsManager.addPlayroom(name);
                        System.out.println(playroom.getName() + " is created. You are inside.");

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Specify name to build a playroom. " +
                                "E.g. [build playroom test]");
                    }
                    break;
                case "player":
                    try {
                        name = userCommands[1];
                        playersManager.addPlayer(name, playroomsManager.getActivePlayroom());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Specify name to build a player. e.g. [build player masha]");
                    }
                    break;
                case "toy":
                    try {
                        name = userCommands[1];
                        type = userCommands[2];
                        toysManager.addToy(name, type, playroomsManager);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Specify name and type to build a toy. e.g. [build toy SoccerBall Ball]");
                    }
                    break;
                default:
                    System.out.println("Illegal argument. Use [playroom], [player] or [toy] as a first [build] argument");
            }
        } catch (IndexOutOfBoundsException e) {
            //creates default playroom on 0 args
            name = playroomsManager.generatePlayroomName();
            System.out.println("Building default Playroom...");
            Playroom playroom = playroomsManager.addPlayroom(name);
            System.out.println(playroom.getName() + " is created. You are inside.");
        }
    }
}
