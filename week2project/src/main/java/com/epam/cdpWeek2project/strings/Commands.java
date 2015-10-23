package com.epam.cdpWeek2project.strings;

import com.epam.cdpWeek2project.commandParsers.*;
import com.epam.cdpWeek2project.factories.PlayroomFactory;
import com.epam.cdpWeek2project.managers.PlayersManager;
import com.epam.cdpWeek2project.managers.PlayroomsManager;
import com.epam.cdpWeek2project.managers.ToysManager;

/**
 * Main commands in the Playroom app
 */
public enum Commands {
    HELP {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            System.out.println(HelpStrings.HELP);
        }
    },
    BUILD {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            BuildParser.parse(userCommands, playroomsManager, playersManager, toysManager);
        }
    },
    SHOW {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
                        ToysManager toysManager){
            ShowParser.parse(userCommands, playroomsManager, playersManager, toysManager);
        }
    },
    DESTROY {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            DestroyParser.parse(userCommands, playersManager);
        }
    },
    PLAY {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            PlayParser.parse(userCommands, playersManager);
        }
    },
    SWITCH {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            SwitchParser.parse(userCommands, playroomsManager, playersManager, toysManager);
        }
    },
    TAKE {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            TakeParser.parse(userCommands, playersManager);
        }
    },
    RETURN {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            ReturnParser.parse(userCommands, playersManager);
        }
    },
    EXIT {
        public void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
            ToysManager toysManager){
            System.out.println(HelpStrings.GOODBYE);
            System.exit(0);
        }
    };

    public abstract void run(String[] userCommands, PlayersManager playersManager, PlayroomsManager playroomsManager,
        ToysManager toysManager);

}
