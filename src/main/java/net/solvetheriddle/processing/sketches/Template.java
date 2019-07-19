package net.solvetheriddle.processing.sketches;

import processing.core.PApplet;

public class Template extends PApplet {

    public static void main(String... args) {
        PApplet.main(Template.class.getName());
    }

    public void settings() {
        size(1280, 720);
    }

    @Override
    public void setup() {
    }

    public void draw() {
        background(0);
    }
}