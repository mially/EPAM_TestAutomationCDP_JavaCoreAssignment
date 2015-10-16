package managers;

import exceptions.NoPlayroomException;
import factories.PlayroomFactory;
import interfaces.Showable;
import models.Playroom;

import java.util.ArrayList;
import java.util.List;

public class PlayroomsManager implements Showable {
    private List<Playroom> playrooms = new ArrayList<>();
    private Playroom activePlayroom = null;
    private int counter = 0;

    @Override
    public void show() {
        System.out.println("All playrooms in this game:");
        if (!playrooms.isEmpty()) {
            for (Playroom playroom : playrooms) {
                playroom.show();
            }
        } else {
            System.out.println("none so far");
        }
    }

    public void showPlayroomByName(String name){
        System.out.println("Playroom " + name + ": ");
        for (Playroom playroom : playrooms){
            if (playroom.getName().equals(name)) {
                playroom.show();
            }
        }
        if (playrooms.isEmpty()) {
            System.out.println(" not created yet");
        }
    }

    public String generatePlayroomName() {
        return "playroom" + (counter + 1);
    }

    public Playroom addPlayroom(String name){
        Playroom newPlayroom = PlayroomFactory.build(name);
        playrooms.add(newPlayroom);
        counter++;
        if (getActivePlayroom() != null) {
            getActivePlayroom().isActive = false;
        }
        setActivePlayroom(newPlayroom);
        return newPlayroom;
    }

    public void destroyPlayroom(Playroom playroom){
        playroom.destroy();
    }

    public void destroyAllPlayrooms(){
        activePlayroom = null;
        if (!playrooms.isEmpty()){
            for (Playroom playroom : playrooms){
                playroom.destroy();
            }
        } else {
            System.out.println("You don't have any playrooms.");
        }
    }

    public Playroom getPlayroomByName(String name) throws NoPlayroomException{
        for (Playroom playroom : playrooms) {
            if (playroom.getName().equals(name)){
                return playroom;
            }
        }
        throw new NoPlayroomException();
    }

    public void switchTo(String name) throws NoPlayroomException{
        Playroom activePlayroom = getActivePlayroom();
        Playroom newPlayroom = getPlayroomByName(name);
        activePlayroom.isActive = false;
        setActivePlayroom(newPlayroom);
        newPlayroom.isActive = true;
        System.out.println(getActivePlayroom().getName() + " is now an active playroom! ");
    }

    public Playroom getActivePlayroom() {
        return activePlayroom;
    }

    public void setActivePlayroom(Playroom activePlayroom) {
        this.activePlayroom = activePlayroom;
    }
}
