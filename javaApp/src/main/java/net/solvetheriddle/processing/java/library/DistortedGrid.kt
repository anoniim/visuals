package net.solvetheriddle.processing.java.library

import processing.core.PApplet

fun main() {
    PApplet.main(DistortedGridCircles::class.java.name)
}

abstract class DistortedGrid : PApplet() {

    override fun settings() {
        size(1280, 720)
    }

    override fun setup() {
        background(0)
    }

    private val red: Int = 0
    private val green: Int = 80
    private val blue: Int = 160
    private var step: Int = 10

    override fun draw() {
        stroke(color((red+step)%255, (green+step)%255, (blue+step)%255))
        line(pmouseX.toFloat(), pmouseY.toFloat(), mouseX.toFloat(), mouseY.toFloat())
        step += 10
    }
}

class DistortedGridCircles : DistortedGrid() {

}

class DistortedGridLines : DistortedGrid() {

    private val lineGap: Float = 20F
    private val maxDistortion: Float = 250F
    private val distortion = 100F
    private val lineCount: Int by lazy { (width / lineGap).toInt() }

    override fun draw() {
        background(0)

        val drawHorizontalLine = { position: Float, color: Int ->
            stroke(color)
            line(0F, position, width.toFloat(), position)
        }
        val drawVerticalLine = { position: Float, color: Int ->
            stroke(color)
            line(position, 0F, position, height.toFloat())
        }
        drawGridLines(lineCount, mouseX, drawVerticalLine)
        drawGridLines(lineCount, mouseY, drawHorizontalLine)
    }

    private fun drawGridLines(lineCount: Int, mousePosition: Int, drawLine: (Float, Int) -> Unit) {
        for (i in 0..lineCount) {

            val position: Float = i * lineGap
//            drawLine(position, 50)

            val distance: Float = position - mousePosition
            val elasticity = 1 - (abs(distance) / maxDistortion)
            val distortedPosition = when (distance) {
                in -maxDistortion..0F -> position - distortion * elasticity
                in 0F..maxDistortion -> position + distortion * elasticity
                else -> position
            }
            drawLine(distortedPosition, 50)
        }
    }
}