package net.solvetheriddle.processing.library.shapes

import net.solvetheriddle.processing.library.GenericApplet

class Grid(private val applet: GenericApplet, private val width: Float) {

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