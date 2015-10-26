package com.epam.cdpWeek2project.commands;

import com.epam.cdpWeek2project.exceptions.NoToyException;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.models.Player;
import com.epam.cdpWeek2project.models.Playroom;
import com.epam.cdpWeek2project.models.Toy;

public class CommandDestroy implements Command {
    private PlayersManager playersManager;

    public CommandDestroy(PlayersManager playersManager){
        this.playersManager = playersManager;
    }

    @Override
    public void run(String[] userInput) {
        String name;

        try {
            name = userInput[0];
            Player activePlayer = playersManager.getActivePlayer();
            Playroom activePlayroom = activePlayer.getActivePlayroom();
            Toy toy = activePlayroom.findToy(name);
            toy.destroy();
        } catch (IndexOutOfBoundsException e) {
            //destroying all toys for active user in active playroom
            Player activePlayer = playersManager.getActivePlayer();
            activePlayer.destroyAll();
        } catch (NoToyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getCommand() {
        return "destroy";
    }
}
