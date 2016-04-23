package com.epam.cdpWeek2project.commandParsers;

import com.epam.cdpWeek2project.exceptions.ToyIsNotTakenException;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.models.Player;
import com.epam.cdpWeek2project.models.Toy;

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
