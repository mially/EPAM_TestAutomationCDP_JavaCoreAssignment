package managers;


import exceptions.NoPlayroomException;
import exceptions.NoToyException;
import factories.ToyFactory;
import interfaces.Showable;
import models.Playroom;
import models.Toy;

import java.util.HashMap;
import java.util.Map;


public class ToysManager implements Showable {
    Map<Toy, Playroom> toys = new HashMap<>();

    @Override
    public void show() {
        System.out.println("All toys in this game: \n");
        for (Toy toy : toys.keySet()) {
            toy.show();
        }
    }

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

    public void ShowToyByName(String name) {
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


