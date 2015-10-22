package com.epam.cdpWeek2project.strings;

/**
 * Contains help strings for Playroom App
 */
public class HelpStrings {
    public static final String WELCOME = "\nWelcome to Playroom App! \n";

    public static final String HELP = "\nAvailable commands: " +
            "\nbuild [playroom | player] [name]" +
            "\nbuild [toy] [name] [category (Ball, Doll, Blocks)]" +
            "\nshow [playroom | player | toy | catalog] [name]" +
            "\nswitch [playroom | player] [name] " +
            "\ntake [toy_name]" +
            "\nplay [toy_name | playroom_name | player_name] " +
            "\nreturn [toy_name]" +
            "\ndestroy [toy_name | playroom_name]" +
            "\nexit \n";

    public static final String COMMAND_NEEDED = "Please enter command. Start with [build]-ing a playroom" +
            " or [help] to know more about your options";

    public static final String ASK_FOR_COMMAND = "Enter your command: ";

    public static final String GOODBYE = "\nThanks for using our app! Get back soon!";

    public static final String EMPTY_PLAYROOM = "This Playroom is currently empty.";
    public static final String INVALID_COMMAND = "You main command is invalid, please type in a valid command.";
}
