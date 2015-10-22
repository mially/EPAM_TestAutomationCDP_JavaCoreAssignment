package com.epam.cdpWeek2project.managers;

import com.epam.cdpWeek2project.exceptions.NoPlayroomException;
import com.epam.cdpWeek2project.factories.PlayroomFactory;
import com.epam.cdpWeek2project.interfaces.Showable;
import com.epam.cdpWeek2project.models.Playroom;

import java.util.ArrayList;
import java.util.List;

/** PlayroomsManager holds list of playrooms, active playroom
 *  and allows to show, add, destroy all and switch to playrooms
 */
public class PlayroomsManager implements Showable {
    private List<Playroom> playrooms = new ArrayList<>();
    private Playroom activePlayroom = null;
    private int counter = 0;

    /**show() all playrooms in the game*/
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

    /**showPlayroomByName() - show()'s playroom by name
     *
     * @param name
     */
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

    /**generatePlayroomName() uses counter to generate next name in a form of "playroom" + counter*/
    public String generatePlayroomName() {
        return "playroom" + (counter + 1);
    }

    /**addPlayroom() build() new Playroom using name, add() it to the list of playrooms in the game,
     * changes active playroom to a new one and prints confirmation message
     *
     * @param name
     * @return Playroom
     */
    public Playroom addPlayroom(String name){
        Playroom newPlayroom = PlayroomFactory.build(name);
        playrooms.add(newPlayroom);
        counter++;
        if (getActivePlayroom() != null) {
            getActivePlayroom().isActive = false;
        }
        setActivePlayroom(newPlayroom);
        System.out.println("Playroom " + newPlayroom.getName() + " is created and active now!");

        return newPlayroom;
    }

    /**destroyAll() destroys all playrooms in the game and prints confirmation message*/
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

    /**getPlayroomByName() searches list of playrooms in the game and returns playroom with given name
     *
     * @param name
     * @return Playroom
     * @throws NoPlayroomException if can't find playroom with given name
     */
    public Playroom getPlayroomByName(String name) throws NoPlayroomException{
        for (Playroom playroom : playrooms) {
            if (playroom.getName().equals(name)){
                return playroom;
            }
        }
        throw new NoPlayroomException();
    }

    /**swithTo() changes currently active playroom to a new one found by name
     *
     * @param name
     * @throws NoPlayroomException if getPlayroomByName() fails
     */
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

    public List<Playroom> getListOfPlayrooms(){
        return playrooms;
    }
}
