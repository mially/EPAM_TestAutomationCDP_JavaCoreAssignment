package models;

import exceptions.*;
import interfaces.Playable;
import interfaces.Showable;

import java.util.ArrayList;
import java.util.List;

public class Player implements Showable, Playable {
    private String name;
    private List<Toy> takenToys = new ArrayList<>();

    private Toy activeToy = null;
    private Playroom activePlayroom = null;
    public boolean isActive = true;

    public Player(String name, Playroom playroom) {
        this.name = name;
        activePlayroom = playroom;
    }

    @Override
    public void show() {
        String playerDescription = String.format("Name: %s. Taken toys: ", getName());
        if (!takenToys.isEmpty()) {
            for (Toy toy : takenToys) {
                playerDescription += toy.getName() + "; ";
            }
        } else {
            playerDescription += " none so far.";
        }
        playerDescription += "\n Is active now? - " + (isActive ? "Yes" : "No") + "\n";
        System.out.println(playerDescription);
    }

    @Override
    public void play() {
        if (!takenToys.isEmpty()){
            for (Toy toy: takenToys){
                toy.play();
            }
            System.out.println("It was fun playing in the " + activePlayroom.getName());
        } else {
            System.out.println("This playroom is very boring, no toys at all!");
        }
    }

    public void playWith(Toy toy) {
        activeToy = toy;
        toy.play();
    }

    public Toy getToy(String name) throws ToyIsNotTakenException{
        for (Toy toy : takenToys){
            if (toy.getName().equals(name)){
                return toy;
            }
        }
        throw new ToyIsNotTakenException();
    }

    public void takeToy(Toy toy){
        if (takenToys.size() < 3) {
            try {
                toy.take(this);
                takenToys.add(toy);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("You have 3 toys taken, return something to take more!");
        }
    }

    public void returnToy(Toy toy){
        takenToys.remove(toy);
        toy.giveBack();
    }

    public void returnToys(){
        for (Toy toy : takenToys) {
            toy.giveBack();
        }
        takenToys.clear();
    }

    public void destroyToy(Toy toy){
        toy.destroy();
    }

    public void destroyAll() {
        for (Toy toy : takenToys) {
            toy.destroy();
        }
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Toy getActiveToy() {
        return activeToy;
    }

    public void setActiveToy(Toy activeToy) {
        this.activeToy = activeToy;
    }

    public Playroom getActivePlayroom() {
        return activePlayroom;
    }

    public void setActivePlayroom(Playroom activePlayroom) {
        this.activePlayroom = activePlayroom;
    }
}

