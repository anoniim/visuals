package net.solvetheriddle.processing.sketches.shapes

import processing.core.PApplet
import processing.core.PConstants
import kotlin.math.cos
import kotlin.math.sin

class Polygon(
        private val applet: PApplet,
        private val x: Float,
        private val y: Float,
        private val radius: Float,
        private val rotation: Float,
        private val npoints: Int) {

    fun draw() {
        //            float x1 = x - radius;
        //            float y1 = y;
        //            float x2 = x - radius / 2;
        //            float y2 = y - 2/sqrt(3);
        //            float x3 = x + radius / 2;
        //            float y3 = y - radius / 2;
        //            float x4 = x + radius;
        //            float y4 = y;
        //            float x5 = x + radius / 2;
        //            float y5 = y + radius / 2;
        //            float x6 = x - radius / 2;
        //            float y6 = y + radius / 2;
        //            line(x1, y1, x2, y2);
        //            line(x2, y2, x3, y3);
        //            line(x3, y3, x4, y4);
        //            line(x4, y4, x5, y5);
        //            line(x5, y5, x6, y6);
        //            line(x6, y6, x1, y1);

        val angle = PConstants.TWO_PI / npoints
        applet.beginShape()
        var a = 0f
        while (a < PConstants.TWO_PI) {
            val sx = x + cos(a + rotation) * radius
            val sy = y + sin(a + rotation) * radius
            applet.vertex(sx, sy)
            a += angle
        }
        applet.endShape(PConstants.CLOSE)
    }
}
