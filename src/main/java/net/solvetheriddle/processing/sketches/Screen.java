package net.solvetheriddle.processing.sketches;

import processing.core.PApplet;
import processing.core.PImage;
import util.ImageLoad;

public class Screen extends PApplet {

    private static int ROWS = 12, COLS = 32, SCALE = 50;
    private static int H = ROWS * SCALE, W = COLS * SCALE;
    private static PImage img;

    public static void main(String... args) {
        PApplet.main(Screen.class.getName());
    }

    public void settings() {
        size(W, H);
        img = ImageLoad.getImage("sw.jpg");
        img.resize(32, 12);
        img.loadPixels();
        noLoop();
    }

    public void draw() {
        background(0);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int clr = img.get(col, row);
                fill(clr);
                rect(col * SCALE, row * SCALE, (col + 1) * SCALE, (row + 1) * SCALE);
            }
        }
    }

}
