package factories;

import models.Playroom;

public class PlayroomFactory {

    public static Playroom build(String name) {
        return new Playroom(name);
    }
}
