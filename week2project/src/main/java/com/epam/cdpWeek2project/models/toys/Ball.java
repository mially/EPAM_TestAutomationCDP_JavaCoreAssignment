package com.epam.cdpWeek2project.models.toys;

import com.epam.cdpWeek2project.models.Toy;

public class Ball extends Toy {

    private String type = "ball";
    private String action = "bounce, bounce, bounce...";
    private String shape = "round";

    public Ball(String name) {
        super(name);
    }

    @Override
    public void playImplementation() {
        System.out.println(String.format("%s: %s", super.getName(), getAction()));
    }

    @Override
    public void show(){
        super.show();
        System.out.println("Shape: " + getShape());
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

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getType() {
        return type;
    }
}
