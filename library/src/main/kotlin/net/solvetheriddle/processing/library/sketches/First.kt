package net.solvetheriddle.processing.library.sketches

import net.solvetheriddle.processing.library.GenericApplet

class First : GenericApplet() {

    private val controlTop by lazy { width.toFloat() }

    override fun settings() {
//        size(parentWidth(), parentHeight())
    }

    override fun setup() {
        stroke(color(255, 0, 0))
        line(0F, controlTop, width.toFloat(), controlTop)
        stroke(color(0))
    }

    override fun draw() {
        if (mousePressed) {
            ellipse(mouseX.toFloat(), mouseY.toFloat(), 50f, 50f)
        }
    }
}