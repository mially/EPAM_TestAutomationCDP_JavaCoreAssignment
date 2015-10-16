package managers;

import exceptions.NoUserException;
import factories.PlayerFactory;
import interfaces.Showable;
import models.Player;
import models.Playroom;

import java.util.ArrayList;
import java.util.List;

public class PlayersManager implements Showable{
    List<Player> players = new ArrayList<>();
    Player activePlayer = null;

    @Override
    public void show() {
        System.out.println("All players in this game: ");
        for (Player player : players){
            player.show();
        }
    }

    public void showPlayer(String name){
        System.out.println("Player " + name + ": ");
        for (Player player : players){
            if (player.getName().equals(name)) {
                player.show();
            }
        }
        if (players.isEmpty()) {
            System.out.println(" not created yet");
        }
    }

    public Player addPlayer(String name, Playroom playroom) {
        System.out.println("Building new player...");
        Player newPlayer = PlayerFactory.build(name, playroom);
        players.add(newPlayer);
        if (activePlayer != null) {
            activePlayer.isActive = false;
        }
        activePlayer = newPlayer;
        System.out.println("Player " + newPlayer.getName() + " is created and active now!");
        return newPlayer;
    }

    public void switchTo(String name) throws NoUserException {
        Player activePlayer = getActivePlayer();
        Player newPlayer = getPlayerByName(name);
        activePlayer.isActive = false;
        setActivePlayer(newPlayer);
        newPlayer.isActive = true;
        System.out.println(getActivePlayer().getName() + " is now an active player! " +
                "[take] toys, [play], [return] and [destroy], " + getActivePlayer().getName());
    }

    public Player getPlayerByName(String name) throws NoUserException {
        for (Player player : players){
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new NoUserException();
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }
}
