package net.solvetheriddle.processing.java.library

import net.solvetheriddle.processing.java.utils.ImageLoad
import processing.core.PApplet
import processing.core.PImage

fun main() {
    PApplet.main(Screen::class.java.name)
}

class Screen: PApplet() {

    private val ROWS = 12
    private val COLS = 32
    private val SCALE = 50
    private val H = ROWS * SCALE
    private val W = COLS * SCALE
    private var img: PImage? = null

    override fun settings() {
        size(W, H)
        img = ImageLoad().getImage("sw.jpg")
        img!!.resize(32, 12)
        img!!.loadPixels()
        noLoop()
    }

    override fun draw() {
        background(0)
        for (row in 0 until ROWS) {
            for (col in 0 until COLS) {
                val clr = img!!.get(col, row)
                fill(clr)
                rect(
                    (col * SCALE).toFloat(),
                    (row * SCALE).toFloat(),
                    ((col + 1) * SCALE).toFloat(),
                    ((row + 1) * SCALE).toFloat()
                )
            }
        }
    }

}