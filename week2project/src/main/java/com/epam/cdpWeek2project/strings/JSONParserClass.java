package com.epam.cdpWeek2project.strings;

import com.google.gson.*;
import com.epam.cdpWeek2project.models.Toy;

import com.epam.cdpWeek2project.models.toys.Blocks;
import com.epam.cdpWeek2project.models.toys.Doll;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONParserClass {

    public void writeJSON() {
        String path = "../playroom/week2project/src/main/java/data/strings/json-out.txt";
        Map<String, Toy> toys = new HashMap<>();

        toys.put("lego", new Blocks("Lego"));
        toys.put("mega", new Blocks("Megablocks"));
        toys.put("masha", new Doll("Masha"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fw = new FileWriter(path);){
            gson.toJson(toys, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromJSON() {
        String path = "../playroom/week2project/src/main/java/data/strings/json.txt";

        try (FileReader fr = new FileReader(path)) {
            Gson gson = new Gson();
            JsonObject jo = gson.fromJson(fr, JsonObject.class);
            JsonArray types = jo.get("types").getAsJsonArray();
            String names = jo.get("names").getAsString();

            System.out.println("\nPrinting json out:");
            System.out.println("===================");
            System.out.println("Types:\n");
            for(JsonElement type : types){
                System.out.println(type.getAsString());
            }
            System.out.println("\nNames: \n");
            System.out.println(names);
            System.out.println("===================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
