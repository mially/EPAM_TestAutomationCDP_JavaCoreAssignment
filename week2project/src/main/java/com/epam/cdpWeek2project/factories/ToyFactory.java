package com.epam.cdpWeek2project.factories;

import com.epam.cdpWeek2project.models.Toy;
import com.epam.cdpWeek2project.models.toys.Ball;
import com.epam.cdpWeek2project.models.toys.Blocks;
import com.epam.cdpWeek2project.models.toys.Doll;

import java.io.InputStreamReader;
import java.util.Scanner;

/** Class ToyFactory builds and returns Toy depending on Toy type */
public class ToyFactory {
    /** Static method build()
     * @param name Toy name
     * @param type should be Ball, Doll or Blocks
     * @return Toy
     */
    public static Toy build(String name, String type) {
        switch(type){
            case "ball":
                return new Ball(name);
            case "doll":
                return new Doll(name);
            case "blocks":
                return new Blocks(name);
            default:
                Scanner scanner = new Scanner(new InputStreamReader(System.in));
                System.out.println("Type is incorrect. Specify correct type: Ball, Doll or Blocks: ");
                String userInput = scanner.nextLine();
                return ToyFactory.build(name, userInput);
        }
    }
}
