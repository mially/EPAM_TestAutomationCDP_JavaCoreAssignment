package models;

import exceptions.IsBrokenException;
import exceptions.IsTakenByYouException;
import exceptions.ToyIsTakenException;
import interfaces.Destroyable;
import interfaces.Playable;
import interfaces.Showable;

public abstract class Toy implements Playable, Destroyable, Showable {

    public boolean isBroken = false;
    public boolean isTaken = false;
    private String name;
    private Player activePlayer = null;

    public Toy(String name) {
        this.name = name;
    }

    public void play() {
        if (!isBroken) {
            System.out.println(String.format("Playing with %s.", getName()));
            playImplementation();
        } else {
            System.out.println(getName() + " is broken, no fun playing with it");
        }
    };

    protected abstract void playImplementation();

    public void take(Player player) throws IsBrokenException, IsTakenByYouException, ToyIsTakenException{
        if (!isBroken) {
            if (!isTaken) {
                isTaken = true;
                activePlayer = player;
                System.out.println(getName() + " is taken by " + activePlayer.getName() + ". [play] carefully!");
            } else {
                if (activePlayer.getName().equals(player.getName())) {
                    throw new IsTakenByYouException();
                } else {
                    throw new ToyIsTakenException();
                }
            }
        } else {
            throw new IsBrokenException();
        }
    }

    public void giveBack(){
        isTaken = false;
        activePlayer = null;
        System.out.println(getName() + " is returned. Thanks for playing!");
    }

    public void destroy(){
        isBroken = true;
        System.out.println(getName() + " is now broken");
    }

    public void show(){
        System.out.println(String.format("Toy: %s", getName()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
