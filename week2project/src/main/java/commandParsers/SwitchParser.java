package commandParsers;


import exceptions.NoPlayroomException;
import exceptions.NoToyException;
import exceptions.NoUserException;
import managers.PlayersManager;
import managers.PlayroomsManager;
import managers.ToysManager;
import models.Player;
import models.Playroom;
import models.Toy;

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
