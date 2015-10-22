package com.epam.cdpWeek2project.managers;

import com.epam.cdpWeek2project.exceptions.NoUserException;
import com.epam.cdpWeek2project.factories.PlayerFactory;
import com.epam.cdpWeek2project.interfaces.Showable;
import com.epam.cdpWeek2project.models.Player;
import com.epam.cdpWeek2project.models.Playroom;

import java.util.ArrayList;
import java.util.List;

/** PlayersManager holds list of players, active player and allows to show, add and switch to players*/
public class PlayersManager implements Showable{
    List<Player> players = new ArrayList<>();
    Player activePlayer = null;

    /**show() all players in the game*/
    @Override
    public void show() {
        System.out.println("All players in this game: ");
        for (Player player : players){
            player.show();
        }
    }

    /**showPlayer() - show()'s player by name
     *
     * @param name
     */
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

    /**addPlayer() build() new Player using name and playroom, add() it to the list of players in the game,
     * changes active player to a new one and prints confirmation message
     *
     * @param name
     * @param playroom
     * @return Player
     */
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

    /**swithTo() changes currently active player to a new one found by name
     *
     * @param name
     * @throws NoUserException if getPlayerByName() fails
     */
    public void switchTo(String name) throws NoUserException {
        Player activePlayer = getActivePlayer();
        Player newPlayer = getPlayerByName(name);
        activePlayer.isActive = false;
        setActivePlayer(newPlayer);
        newPlayer.isActive = true;
        System.out.println(getActivePlayer().getName() + " is now an active player! " +
                "[take] toys, [play], [return] and [destroy], " + getActivePlayer().getName());
    }

    /**getPlayerByName() searches list of players in the game and returns player with given name
     *
     * @param name
     * @return Player
     * @throws NoUserException if can't find user with given name
     */
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