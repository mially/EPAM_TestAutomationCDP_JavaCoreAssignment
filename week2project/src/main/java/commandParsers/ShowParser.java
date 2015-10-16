package commandParsers;

import managers.PlayersManager;
import managers.PlayroomsManager;
import managers.ToysManager;
import models.Playroom;

public class ShowParser {
    public static void parse(String[] userCommands, PlayroomsManager playroomManager,
                             PlayersManager playersManager, ToysManager toysManager) {
        String mainCommand;
        String name;

        try {
            mainCommand = userCommands[0];
            try {
                name = userCommands[1];

                switch (mainCommand) {
                    case "playroom":
                        playroomManager.showPlayroomByName(name);
                        break;
                    case "player":
                        playersManager.showPlayer(name);
                        break;
                    case "toy":
                        toysManager.ShowToyByName(name);
                        break;
                    default:
                        System.out.println("Illegal argument. Use [playroom], [player] or [toy]" +
                                "as a first [show] argument");
                }
            } catch (IndexOutOfBoundsException e) {
                //if second arg is null
                switch (mainCommand) {
                    case "playroom":
                        playroomManager.show();
                        break;
                    case "player":
                        playersManager.show();
                        break;
                    case "toy":
                        Playroom activePlayroom = playroomManager.getActivePlayroom();
                        toysManager.showToysInPlayroom(activePlayroom);
                        break;
                    default:
                        System.out.println("Illegal argument. Use [playroom], [player] or [toy] " +
                                "as a first [show] argument");
                }

            }
        } catch (IndexOutOfBoundsException e) {
            //shows full state on 0 args
            playroomManager.show();
            playersManager.show();
        }
    }
}
