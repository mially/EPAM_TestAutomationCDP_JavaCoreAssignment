package commandParsers;

import exceptions.NoToyException;
import managers.PlayersManager;
import managers.PlayroomsManager;
import managers.ToysManager;
import models.Player;
import models.Playroom;
import models.Toy;

public class PlayParser {
    public static void parse(String[] userCommands, PlayersManager playersManager) {
        String name;

        try {
            name = userCommands[0];
            Player activePlayer = playersManager.getActivePlayer();
            Playroom activePlayroom = activePlayer.getActivePlayroom();
            Toy toy = activePlayroom.findToy(name);
            toy.play();
        } catch (IndexOutOfBoundsException e) {
            //play with all toys for active user in active playroom
            Player activePlayer = playersManager.getActivePlayer();
            activePlayer.play();
        } catch (NoToyException e) {
            System.out.println(e.getMessage());
        }
    }
}
