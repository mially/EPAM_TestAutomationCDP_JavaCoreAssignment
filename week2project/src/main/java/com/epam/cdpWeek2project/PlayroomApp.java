package com.epam.cdpWeek2project;

import com.epam.cdpWeek2project.commandParsers.*;
import com.epam.cdpWeek2project.strings.JSONParserClass;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.managers.PlayroomsManager;
import com.epam.cdpWeek2project.managers.ToysManager;
import com.epam.cdpWeek2project.models.Player;
import com.epam.cdpWeek2project.strings.HelpStrings;
import com.epam.cdpWeek2project.models.Playroom;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Playroom App is a console-driven application.
 * Allows admin to build a playroom and players, play with toys, return or even destroy them.
 * Run it to know more! (java -jar Playroom.jar)
 */

public class PlayroomApp {
    public static void main(String[] args) {
        //loading com.epam.cdpWeek2project.managers for the app
        ToysManager toysManager = new ToysManager();
        PlayersManager playersManager = new PlayersManager();
        PlayroomsManager playroomsManager = new PlayroomsManager();
        //creates default playroom on start
        Playroom defaultPlayroom = playroomsManager.addPlayroom("defaultplayroom");
        //creates new Player for main user on start
        Player admin = playersManager.addPlayer("admin", defaultPlayroom);

        //read JSON and build a sample toy
        JSONParserClass js = new JSONParserClass();
        js.readFromJSON();
        js.writeJSON();

        //gets user input from command line
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        System.out.print("\nWelcome, " + admin.getName() + "!" + HelpStrings.WELCOME);
        System.out.println(HelpStrings.HELP);
        System.out.print(HelpStrings.ASK_FOR_COMMAND);

        while(true){
            String userInput = scanner.nextLine();

            if(!userInput.isEmpty()){
                String[] userCommands = userInput.toLowerCase().split(" ");
                String userCommand = userCommands[0];

                //saves command attributes to pass down the chain. Ok to be empty
                String[] userCommandAttributes = Arrays.copyOfRange(userCommands, 1, userCommands.length);

                //redirects complex commands to com.epam.cdpWeek2project.commandParsers
                switch (userCommand) {
                    case "help":
                        System.out.println(HelpStrings.HELP);
                        break;
                    case "build":
                        BuildParser.parse(userCommandAttributes, playroomsManager, playersManager, toysManager);
                        break;
                    case "show":
                        ShowParser.parse(userCommandAttributes, playroomsManager, playersManager, toysManager);
                        break;
                    case "destroy":
                        DestroyParser.parse(userCommandAttributes,playersManager);
                        break;
                    case "play":
                        PlayParser.parse(userCommandAttributes, playersManager);
                        break;
                    case "switch":
                        SwitchParser.parse(userCommandAttributes, playroomsManager, playersManager, toysManager);
                        break;
                    case "take":
                        TakeParser.parse(userCommandAttributes, playersManager);
                        break;
                    case "return":
                        ReturnParser.parse(userCommandAttributes, playersManager);
                        break;
                    case "exit":
                        System.out.println(HelpStrings.GOODBYE);
                        System.exit(0);
                    default:
                        System.out.println(HelpStrings.INVALID_COMMAND);
                }
            } else {
                System.out.println(HelpStrings.COMMAND_NEEDED);
            }
            System.out.print("\n" + HelpStrings.ASK_FOR_COMMAND);
        }
    }
}
