package com.epam.cdpWeek2project;

import com.epam.cdpWeek2project.commands.*;
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
        //creates default playroom and player on start
        Playroom defaultPlayroom = playroomsManager.addPlayroom("defaultplayroom");
        Player admin = playersManager.addPlayer("admin", defaultPlayroom);

        //builds map of commands for mapping
        AllCommandsMap allCommandsMap = AllCommandsMap.build(Arrays.asList(
                new CommandBuild(playersManager, playroomsManager, toysManager),
                new CommandTake(playersManager),
                new CommandHelp(),
                new CommandExit(),
                new CommandDestroy(playersManager),
                new CommandPlay(playersManager),
                new CommandShow(playroomsManager, playersManager, toysManager),
                new CommandSwitch(playersManager, playroomsManager)));

        //gets user input from command line
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        System.out.print("\nWelcome, " + admin.getName() + "!" + HelpStrings.WELCOME);
        System.out.println(HelpStrings.HELP);
        System.out.print(HelpStrings.ASK_FOR_COMMAND);

        while(true){
            String userInput = scanner.nextLine();

            if(!userInput.isEmpty()){
                String[] userCommands = userInput.toLowerCase().split(" ");
                allCommandsMap.run(userCommands);
            } else {
                System.out.println(HelpStrings.COMMAND_NEEDED);
            }
            System.out.print("\n" + HelpStrings.ASK_FOR_COMMAND);
        }
    }
}
