package com.epam.cdpWeek2project.commandParsers;

import com.epam.cdpWeek2project.exceptions.NoToyException;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.models.Player;
import com.epam.cdpWeek2project.models.Playroom;
import com.epam.cdpWeek2project.models.Toy;

public class TakeParser {
    public static void parse(String[] userCommands, PlayersManager playersManager) {
        String name;

        try {
            name = userCommands[0];
            Player activePlayer = playersManager.getActivePlayer();
            Playroom playroomForPlayer = activePlayer.getActivePlayroom();
            Toy toy = playroomForPlayer.findToy(name);
            activePlayer.takeToy(toy);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Use toy_name as an argument. " +
                "Remember that only active player inside the playroom can take toys.");
        } catch (NoToyException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No active playroom yet!");
        }
    }
}
