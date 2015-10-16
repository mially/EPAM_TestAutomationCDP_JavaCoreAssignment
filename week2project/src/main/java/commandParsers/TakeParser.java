package commandParsers;

import exceptions.NoToyException;
import managers.PlayersManager;
import managers.PlayroomsManager;
import managers.ToysManager;
import models.Player;
import models.Playroom;
import models.Toy;

public class TakeParser {
    public static void parse(String[] userCommands, PlayroomsManager playroomManager,
                             PlayersManager playersManager, ToysManager toysManager) {
        String name;

        try {
            name = userCommands[0];
            Player activePlayer = playersManager.getActivePlayer();
            Playroom playroomForPlayer = activePlayer.getActivePlayroom();
            Toy toy = playroomForPlayer.findToy(name);
            activePlayer.takeToy(toy);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Use toy_name as an argument. Remember that only active player inside the playroom can take toys.");
        } catch (NoToyException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No active playroom yet!");
        }
    }
}
