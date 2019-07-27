package net.solvetheriddle.processing.java.library;

import processing.core.PApplet;

public class Road extends PApplet {

    private static final int ROAD_LENGTH = 450;

    private float middle;
    private float roadWidth;
    private float perspective;
    private float middleLineWidth;
    private float sideLineWidth;
    private float top;
    private Line[] lines = new Line[13];
    private int counter = 0;

    public static void main(String... args) {
        PApplet.main(Road.class.getName());
    }

    @Override
    public void settings() {
        size(1280, 720);
    }

    @Override
    public void setup() {
        top = height - ROAD_LENGTH;
        middle = width / 2;
        roadWidth = 4;
        perspective = 350;
        sideLineWidth = 1;
        middleLineWidth = 0.1F;
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line();
        }
    }

    @Override
    public void draw() {
        background(0);

        // side lines
        strokeWeight(sideLineWidth);
        stroke(255);
        line(middle - roadWidth / 2, top, middle - roadWidth / 2 * perspective, height);
        line(middle + roadWidth / 2, top, middle + roadWidth / 2 * perspective, height);

        // middle line
        noStroke();
        fill(100);
        quad(
                middle - middleLineWidth / 2, top,
                middle + middleLineWidth / 2, top,
                middle + middleLineWidth / 2 * perspective, height,
                middle - middleLineWidth / 2 * perspective, height);

        // move
        for (int i = 0; i < lines.length; i++) {
            if (counter > (ROAD_LENGTH / lines.length) * i) {
                lines[i].draw();
            }
        }

        counter++;
    }

    class Line {
        private float d = 0F;

        void draw() {

            float yPosition = getYPosition();

            stroke(255, 0, 0);
//            float x1 = middle - ((roadWidth / 2) * perspective);
//            float x2 = middle + ((roadWidth / 2) * perspective);
            line(0, yPosition, width, yPosition);
        }

        private float getYPosition() {
            float yPosition = height - d;

            float speedRatio = ((top + ROAD_LENGTH) / yPosition);
            float speed = (4 * (1 / speedRatio)) * (1 / speedRatio);

//        if(yPosition == top+ROAD_LENGTH) speed = 1;
//        if(yPosition == top+ROAD_LENGTH/2) speed = 0.5F;
//        if(yPosition == top) speed = 0F;


            if (yPosition > top + 5) {
                d = d + speed;
            } else {
                d = 0;
            }
            return yPosition;
        }
    }
}