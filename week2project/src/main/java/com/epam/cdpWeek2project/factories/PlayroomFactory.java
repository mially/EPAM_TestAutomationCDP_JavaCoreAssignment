package com.epam.cdpWeek2project.factories;

import com.epam.cdpWeek2project.models.Playroom;

/** Class PlayroomFactory builds and returns Playroom*/
public class PlayroomFactory {
    /** Static method build()
     * @param name Playroom name
     * @return Playroom
     */
    public static Playroom build(String name) {
        return new Playroom(name);
    }
}
