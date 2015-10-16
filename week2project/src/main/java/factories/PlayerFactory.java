package factories;


import models.Player;
import models.Playroom;

public class PlayerFactory {
    public static Player build(String name, Playroom playroom) {
        return new Player(name, playroom);
    }
}
