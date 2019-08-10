package net.solvetheriddle.processing.android

import net.solvetheriddle.processing.library.Applet
import net.solvetheriddle.processing.library.GenericApplet
import processing.core.PApplet

class AndroidApplet(private val applet: GenericApplet) : PApplet(), Applet {

    init {
        applet.callback = this
    }

    override fun settings() = applet.settings()
    override fun setup() = applet.setup()
    override fun draw() = applet.draw()

    override val heightG: Int get() = super.height
    override val widthG: Int get() = super.width
    override val mouseXG: Int get() = super.mouseX
    override val mouseYG: Int get() = super.mouseY
    override val mousePressedG: Boolean get() = super.mousePressed

    override fun sizeG(width: Int, height: Int) { /* Always fullscreen */ }
    override fun pushMatrixG() = super.pushMatrix()
    override fun popMatrixG() = super.popMatrix()
    override fun translateG(x: Float, y: Float) = super.translate(x, y)
    override fun rotateG(x: Float) = super.rotate(x)
    override fun noFillG() = super.noFill()
    override fun backgroundG(color: Int) = super.background(color)
    override fun strokeG(color: Int) = super.stroke(color)
    override fun colorG(r: Int, g: Int, b: Int) = super.color(r, g, b)
    override fun colorG(grey: Int) = super.color(grey)
    override fun ellipseG(x: Float, y: Float, radiusX: Float, radiusY: Float) = super.ellipse(x, y, radiusX, radiusY)
    override fun line(x1: Float, y1: Float, x2: Float, y2: Float) = super.line(x1, y1, x2, y2)
    override fun beginShapeG() = super.beginShape()
    override fun vertexG(x: Float, y: Float) = super.vertex(x, y)
    override fun endShapeG() = super.endShape()
    override fun endShapeG(mode: Int) = super.endShape(mode)

}