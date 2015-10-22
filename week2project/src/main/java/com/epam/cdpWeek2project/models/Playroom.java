package com.epam.cdpWeek2project.models;

import com.epam.cdpWeek2project.exceptions.NoToyException;
import com.epam.cdpWeek2project.interfaces.Destroyable;
import com.epam.cdpWeek2project.interfaces.Playable;
import com.epam.cdpWeek2project.interfaces.Showable;
import com.epam.cdpWeek2project.strings.HelpStrings;

import java.util.ArrayList;
import java.util.List;

public class Playroom implements Playable, Destroyable, Showable {
    private String name;
    private String description = HelpStrings.EMPTY_PLAYROOM;
    protected List<Toy> listOfToys = new ArrayList<>();
    public boolean isActive = true;

    public Playroom (String playroomName){
        this.name = playroomName;
        description = String.format("%s is a playroom for every kid!",
                playroomName);
    }

    @Override
    public void play(){
        if(isActive){
            if (!listOfToys.isEmpty()){
                for (Toy toy: listOfToys){
                    toy.play();
                }
                System.out.println("It was fun playing in the " + getName());
            } else {
                System.out.println("This playroom is very boring, no toys at all!");
            }
        } else {
            System.out.println(getName() + " is not active, you cannot play in it!");
        }
    }

    @Override
    public void show() {
        String showPlayroom = description + " Toys in this room: ";
        if (!listOfToys.isEmpty()){
            for (Toy toy : listOfToys){
                showPlayroom += toy.getName() + "; ";
            }
        } else {
            showPlayroom += "none fo far";
        }
        showPlayroom += "\n" + (isActive ? "This playroom is now active \n" : "Not active, [switch] to manage and play \n");
        System.out.println(showPlayroom);
    }

    public void addToy(Toy toy){
        listOfToys.add(toy);
    }

    public Toy findToy (String name) throws NoToyException{
        for (Toy toy : listOfToys) {
            if (toy.getName().equals(name)) {
                return toy;
            }
        }
        throw new NoToyException();
    }
    @Override
    public void destroy() {
        for (Toy toy : listOfToys){
            toy.destroy();
        }
        listOfToys.clear();
        isActive = false;
        setDescription(getName() + " is destroyed, all toys are destroyed! Mua-ha-ha!!!");
        setName("Destroyed" + getName());
        System.out.println(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String playroomName) {
        this.name = playroomName;
    }

    public void setDescription(String playroomDescription) {
        this.description = playroomDescription;
    }

}
