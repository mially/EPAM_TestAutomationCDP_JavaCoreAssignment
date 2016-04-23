package com.epam.cdpWeek2project.factories;

import com.epam.cdpWeek2project.models.Player;
import com.epam.cdpWeek2project.models.Playroom;

/** Class PlayerFactory builds and returns Player */
public class PlayerFactory {
    /** Static method build()
     * @param name Player name
     * @param playroom Playroom player belongs
     * @return Player
     */
    public static Player build(String name, Playroom playroom) {
        return new Player(name, playroom);
    }
}
