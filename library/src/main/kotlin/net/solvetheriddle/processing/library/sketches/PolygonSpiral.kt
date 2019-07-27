package net.solvetheriddle.processing.library.sketches

import net.solvetheriddle.processing.library.GenericApplet
import net.solvetheriddle.processing.library.PI
import net.solvetheriddle.processing.library.TWO_PI
import net.solvetheriddle.processing.library.shapes.Grid
import net.solvetheriddle.processing.library.shapes.Polygon
import kotlin.math.min

abstract class PolygonSpiral : GenericApplet() {

    protected val maxPolygonCount = 30
    protected val maxPolygonNodes = 6

    private lateinit var grid: Grid

    override fun settings() {
        size(1280, 720)
//        size(600, 600)
        grid = Grid(this, 10f)
    }

    override fun setup() {

    }

    override fun draw() {
        background(0)
//        grid.draw(50)

        translate((width / 2).toFloat(), (height / 2).toFloat())

        stroke(255)
        noFill()

        val size = min(width, height)
        val x = 0F
        val y = 0F
        val originalRadius: Float = 3F * size / 7F

        ellipse(x, y, originalRadius * 2, originalRadius * 2)

        val polygonCount = (controlX / 100F * maxPolygonCount).toInt()
        val nodeCount = (controlY / 100F * maxPolygonNodes - 1).toInt() + 2

        drawSpiral(x, y, originalRadius, nodeCount, polygonCount)
    }

    private fun drawSpiral(x: Float, y: Float, originalRadius: Float, nodeCount: Int, polygonCount: Int) {
        for (n in polygonCount downTo 1) {
            pushMatrix()
            doRotate(polygonCount, n)
            val radius = getRadius(n, originalRadius, polygonCount)
            val polygon = Polygon(this, x, y, radius, PI / 3, nodeCount)
            polygon.draw()
            popMatrix()
        }
    }

    protected abstract fun getRadius(n: Int, originalRadius: Float, polygonCount: Int): Float

    protected abstract fun doRotate(polygonCount: Int, n: Int)
}

class UpDownSpiral : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(TWO_PI / n)

    override fun getRadius(n: Int, originalRadius: Float, polygonCount: Int) = n * originalRadius / polygonCount
}

class DownUpSpiral : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * TWO_PI / polygonCount)

    override fun getRadius(n: Int, originalRadius: Float, polygonCount: Int) = (n) * originalRadius / polygonCount
}

class InwardSpiral : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * TWO_PI / maxPolygonCount)

    override fun getRadius(n: Int, originalRadius: Float, polygonCount: Int) =
        originalRadius - n * (originalRadius / maxPolygonCount)
}

class PolygonCircles : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * (PI / maxPolygonCount))

    override fun getRadius(n: Int, originalRadius: Float, polygonCount: Int) = originalRadius
}

class PolygonCircles2 : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * TWO_PI / polygonCount)

    override fun getRadius(n: Int, originalRadius: Float, polygonCount: Int) =
        originalRadius - n * (originalRadius / maxPolygonCount)
}

class PolygonCircles3 : PolygonSpiral() {

    override fun doRotate(polygonCount: Int, n: Int) = rotate(n * TWO_PI / polygonCount)

    override fun getRadius(n: Int, originalRadius: Float, polygonCount: Int) = originalRadius / (maxPolygonCount.toFloat() / n)
}