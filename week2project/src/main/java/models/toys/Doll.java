package models.toys;

import models.Toy;

public class Doll extends Toy {
    private String type = "Doll";
    private String action = "Agu, mama, agu...";
    private String shape = "human";

    public Doll(String name) {
        super(name);
    }

    @Override
    public void playImplementation() {
        System.out.println(String.format("%s: %s", super.getName(), getAction()));
    }

    @Override
    public void show(){
        super.show();
        System.out.println("Type: " + getType());
        System.out.println("Shape: " + getShape());
        System.out.println("Action: " + getAction());    }

    @Override
    public void destroy(){
        super.destroy();
        setShape("messed up");
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
