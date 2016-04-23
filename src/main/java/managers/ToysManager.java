package com.epam.cdpWeek2project.managers;

import com.epam.cdpWeek2project.exceptions.NoPlayroomException;
import com.epam.cdpWeek2project.factories.ToyFactory;
import com.epam.cdpWeek2project.interfaces.Showable;
import com.epam.cdpWeek2project.models.Playroom;
import com.epam.cdpWeek2project.models.Toy;

import java.util.HashMap;
import java.util.Map;

/** ToysManager holds map of toys and playrooms and allows to show and add toys*/
public class ToysManager implements Showable {
    Map<Toy, Playroom> toys = new HashMap<>();

    /**show() all toys in the game*/
    @Override
    public void show() {
        System.out.println("All toys in this game: \n");
        for (Toy toy : toys.keySet()) {
            toy.show();
        }
    }

    /**showToysInPlayroom uses playroom object to show() all corresponding toys
     *
     * @param playroom
     */
    public void showToysInPlayroom(Playroom playroom) {
        System.out.println("Toys in the " + playroom.getName() + ": \n");
        if (!toys.isEmpty()) {
            for (Toy toy : toys.keySet()) {
                if (toys.get(toy).equals(playroom)) {
                    toy.show();
                }
            }
        } else {
            System.out.println("none so far.");
        }
    }

    /**showToyByName() uses toy name to search keyset in map of toys and playrooms and show() found toy
     *
     * @param name
     */
    public void showToyByName(String name) {
        if (!toys.isEmpty()) {
            for (Toy toy : toys.keySet()) {
                if (toy.getName().equals(name)) {
                    toy.show();
                }
            }
        } else {
            System.out.println("No such toy in all playrooms - " + name);
        }
    }

    /**addToy() build() new Toy using name and type, add it to the map together with the active playroom
     *
     * @param name
     * @param type
     * @param playroomsManager
     */
    public void addToy(String name, String type, PlayroomsManager playroomsManager) {

        System.out.println("Building new toy...");
        Toy newToy = ToyFactory.build(name, type);
        try {
            if (playroomsManager.getActivePlayroom() != null) {
                ;
                Playroom activePlayroom = playroomsManager.getActivePlayroom();
                toys.put(newToy, activePlayroom);
                playroomsManager.getPlayroomByName(activePlayroom.getName()).addToy(newToy);
                System.out.println("Toy " + newToy.getName() + " is created in active playroom - "
                        + activePlayroom.getName());
            } else {
                System.out.println("You can add toy to active playrooms only. No active playrooms? [build] one!");
            }
        } catch (NoPlayroomException e) {
            System.out.println(e.getMessage());
        }
    }
}