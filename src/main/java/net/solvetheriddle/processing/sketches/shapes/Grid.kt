package net.solvetheriddle.processing.sketches.shapes

import processing.core.PApplet

class Grid(private val applet: PApplet, private val width: Float) {

    fun draw(rgb: Int) {
        applet.stroke(rgb)
        var a = 0F
        while (a < applet.width) {
            applet.line(a, 0f, a, applet.width.toFloat())
            applet.line(0f, a, applet.height.toFloat(), a)
            a += width
        }
    }
}