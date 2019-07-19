package net.solvetheriddle.processing.sketches

import net.solvetheriddle.processing.sketches.shapes.Grid
import net.solvetheriddle.processing.sketches.shapes.Polygon
import processing.core.PApplet
import processing.core.PConstants

fun main() {
//    PApplet.main(UpDownSpiral::class.java.name)
//    PApplet.main(DownUpSpiral::class.java.name)
//    PApplet.main(InwardSpiral::class.java.name)
    PApplet.main(PolygonCircles::class.java.name)
//    PApplet.main(PolygonCircles2::class.java.name)
//    PApplet.main(PolygonCircles3::class.java.name)
}

abstract class PolygonSpiral : PApplet() {

    protected val maxPolygonCount = 60
    protected val maxPolygonNodes = 7

    private lateinit var grid: Grid

    override fun settings() {
        //        size(1280, 720);
        size(600, 600)
        grid = Grid(this, 10f)
    }

    override fun setup() {

    }

    override fun draw() {
        background(0)
        grid.draw(50)

        translate((width / 2).toFloat(), (height / 2).toFloat())

        stroke(255)
        noFill()

        val x = 0F
        val y = 0F
        val originalRadius = width / 3

        ellipse(x, y, (originalRadius * 2).toFloat(), (originalRadius * 2).toFloat())

        val scaleX: Float = (if (mouseX != 0) mouseX else 1).toFloat()
        val scaleY: Float = (if (mouseY != 0) mouseY else 1).toFloat()
        val polygonCount = (scaleX / (width / 100F) / 100F * maxPolygonCount).toInt()
        val nodeCount = (scaleY / (height / 100F) / 100F * maxPolygonNodes - 1).toInt() + 2

        drawSpiral(x, y, originalRadius, nodeCount, polygonCount)
    }

    private fun drawSpiral(x: Float, y: Float, originalRadius: Int, nodeCount: Int, polygonCount: Int) {
        for (n in polygonCount downTo 1) {
            pushMatrix()
            doRotate(polygonCount, n)
            val radius = getRadius(n, originalRadius, polygonCount)
            val polygon = Polygon(this, x, y, radius.toFloat(), PI / 3, nodeCount)
            polygon.draw()
            popMatrix()
        }
    }

    protected abstract fun getRadius(n: Int, originalRadius: Int, polygonCount: Int): Int

    protected abstract fun doRotate(polygonCount: Int, n: Int)
}

class UpDownSpiral : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(PConstants.TWO_PI / n)

    override fun getRadius(n: Int, originalRadius: Int, polygonCount: Int) = n * originalRadius / polygonCount
}

class DownUpSpiral : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * PConstants.TWO_PI / polygonCount)

    override fun getRadius(n: Int, originalRadius: Int, polygonCount: Int) = (n) * originalRadius / polygonCount
}

class InwardSpiral : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * PConstants.TWO_PI / maxPolygonCount)

    override fun getRadius(n: Int, originalRadius: Int, polygonCount: Int) = originalRadius - n * (originalRadius / maxPolygonCount)
}

class PolygonCircles : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * (PConstants.TWO_PI / maxPolygonCount))

    override fun getRadius(n: Int, originalRadius: Int, polygonCount: Int) = originalRadius
}

class PolygonCircles2 : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * PConstants.TWO_PI / polygonCount)

    override fun getRadius(n: Int, originalRadius: Int, polygonCount: Int) = originalRadius - n * (originalRadius / maxPolygonCount)
}

class PolygonCircles3 : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * PConstants.TWO_PI / polygonCount)

    override fun getRadius(n: Int, originalRadius: Int, polygonCount: Int) = originalRadius / (maxPolygonCount / n)
}