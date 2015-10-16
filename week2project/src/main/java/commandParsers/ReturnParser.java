package commandParsers;

import exceptions.NoToyException;
import exceptions.ToyIsNotTakenException;
import managers.PlayersManager;
import managers.PlayroomsManager;
import managers.ToysManager;
import models.Player;
import models.Playroom;
import models.Toy;

public class ReturnParser {
    public static void parse(String[] userCommands, PlayersManager playersManager) {
        String name;

        try {
            name = userCommands[0];
            Player activePlayer = playersManager.getActivePlayer();
            Toy toy = activePlayer.getToy(name);
            activePlayer.returnToy(toy);
        } catch (IndexOutOfBoundsException e) {
            //return all toy for active player
            Player activePlayer = playersManager.getActivePlayer();
            activePlayer.returnToys();
        } catch (ToyIsNotTakenException e) {
            System.out.println(e.getMessage());
        }
    }
}
