package net.solvetheriddle.processing.library.sketches

import net.solvetheriddle.processing.library.GenericApplet
import kotlin.math.min
import kotlin.random.Random

/**
Spore 1 by Mike Davis.

A short program for alife experiments. Click in the window to restart. Each cell is represented by a pixel on
the display as well as an entry in the array 'cells'. Each cell has a run() method, which performs actions based on
the cell's surroundings. Cells run one at a time (to avoid conflicts like wanting to move to the same space) and in
random order.

https://processing.org/examples/spore1.html
 */
class Spore1 : GenericApplet() {

    lateinit var w: World
    var numcells = 1
    var maxcells = 6700
    var cells = arrayOfNulls<Cell>(maxcells)
    var spore_color = 0
    // set lower for smoother animation, higher for faster simulation
    var runs_per_loop = 10000
    var black = 0

    override fun settings() {
        size(1024, 760)
    }

    override fun setup() {
        frameRate(48F)
        black = color(0, 0, 0)
        spore_color = color(172, 255, 128)
        reset()
    }

    fun reset() {
        clearScreen()
        w = World()
        seed()
    }

    fun seed() {
        // Add cells at random places
        for (i in 0 until maxcells) {
            val cX = Random.nextInt(width)
            val cY = Random.nextInt(height)
            if (w.getpix(cX, cY) == black) {
                w.setpix(cX, cY, spore_color)
                cells[numcells] = Cell(cX, cY)
                numcells++
            }
        }
    }

    override fun draw() {
        // Run cells in random order
        for (i in 0 until runs_per_loop) {
            val selected = min(Random.nextInt(numcells), numcells - 1)
            cells[selected]?.run()
        }
    }

    fun clearScreen() {
        background(0)
    }

    inner class Cell(var x: Int, var y: Int) {

        // Perform action based on surroundings
        fun run() {
            // Fix cell coordinates
            while (x < 0) {
                x += width
            }
            while (x > width - 1) {
                x -= width
            }
            while (y < 0) {
                y += height
            }
            while (y > height - 1) {
                y -= height
            }

            // Cell instructions
            if (w.getpix(x + 1, y) == black) {
                move(0, 1)
            } else if (w.getpix(x, y - 1) != black && w.getpix(x, y + 1) != black) {
                move(Random.nextInt(9) - 4, Random.nextInt(9) - 4)
            }
        }

        // Will move the cell (dx, dy) units if that space is empty
        fun move(dx: Int, dy: Int) {
            if (w.getpix(x + dx, y + dy) == black) {
                w.setpix(x + dx, y + dy, w.getpix(x, y))
                w.setpix(x, y, color(0))
                x += dx
                y += dy
            }
        }
    }

    //  The World class simply provides two functions, get and set, which access the
    //  display in the same way as getPixel and setPixel.  The only difference is that
    //  the World class's get and set do screen wraparound ("toroidal coordinates").
    inner class World {

        fun setpix(x: Int, y: Int, c: Int) {
            var x = x
            var y = y
            while (x < 0) x += width
            while (x > width - 1) x -= width
            while (y < 0) y += height
            while (y > height - 1) y -= height
            set(x, y, c)
        }

        fun getpix(x: Int, y: Int): Int {
            var x = x
            var y = y
            while (x < 0) x += width
            while (x > width - 1) x -= width
            while (y < 0) y += height
            while (y > height - 1) y -= height
            return get(x, y)
        }
    }

    override fun mousePressed() {
        numcells = 0
        reset()
    }
}