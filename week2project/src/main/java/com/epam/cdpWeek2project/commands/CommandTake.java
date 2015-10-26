package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.exceptions.NoToyException;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.models.Player;
import com.epam.cdpWeek2project.models.Playroom;
import com.epam.cdpWeek2project.models.Toy;

public class CommandTake implements Command {
    private final PlayersManager playersManager;

    public CommandTake(PlayersManager playersManager){
        this.playersManager = playersManager;
    }

    @Override
    public void run(String[] userInput) {
        String name;

        try {
            name = userInput[0];
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

    @Override
    public String getCommand() {
        return "take";
    }
}
