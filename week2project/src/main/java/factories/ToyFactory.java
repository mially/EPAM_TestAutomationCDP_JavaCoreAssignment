package factories;


import models.Toy;
import models.toys.Ball;
import models.toys.Blocks;
import models.toys.Doll;

import java.io.InputStreamReader;
import java.util.Scanner;

public class ToyFactory {

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
