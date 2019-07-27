package net.solvetheriddle.processing.library

abstract class GenericApplet {

    abstract fun settings()
    abstract fun setup()
    abstract fun draw()

    lateinit var callback: Applet

    val mousePressed get() = callback.mousePressedG
    val mouseX get() = callback.mouseXG
    val mouseY get() = callback.mouseYG
    val width get() = callback.widthG
    val height get() = callback.heightG

    fun size(width: Int, height: Int) = callback.sizeG(width, height)
    fun pushMatrix() = callback.pushMatrixG()
    fun popMatrix() = callback.popMatrixG()
    fun translate(x: Float, y: Float) = callback.translateG(x, y)
    fun rotate(x: Float) = callback.rotateG(x)
    fun background(color: Int) = callback.backgroundG(color)
    fun noFill() = callback.noFillG()
    fun stroke(color: Int) = callback.strokeG(color)
    fun color(r: Int, g: Int, b: Int) = callback.colorG(r, g, b)
    fun color(grey: Int) = callback.colorG(grey)
    fun ellipse(x: Float, y: Float, radiusX: Float, radiusY: Float) = callback.ellipseG(x, y, radiusX, radiusY)
    fun line(x1: Float, y1: Float, x2: Float, y2: Float) = callback.line(x1, y1, x2, y2)
    fun beginShape() = callback.beginShapeG()
    fun vertex(x: Float, y: Float) = callback.vertexG(x, y)
    fun endShape() = callback.endShapeG()
    fun endShape(mode: Int) = callback.endShapeG(mode)

    val controlX: Float get() = callback.controlX
    val controlY: Float get() = callback.controlY
}

interface Applet {
    val heightG: Int
    val widthG: Int
    val mousePressedG: Boolean
    val mouseXG: Int
    val mouseYG: Int

    fun sizeG(width: Int, height: Int)
    fun pushMatrixG()
    fun popMatrixG()
    fun translateG(x: Float, y: Float)
    fun rotateG(x: Float)
    fun noFillG()
    fun backgroundG(color: Int)
    fun strokeG(color: Int)
    fun colorG(r: Int, g: Int, b: Int): Int
    fun colorG(grey: Int): Int
    fun ellipseG(x: Float, y: Float, radiusX: Float, radiusY: Float)
    fun line(x1: Float, y1: Float, x2: Float, y2: Float)
    fun beginShapeG()
    fun vertexG(x: Float, y: Float)
    fun endShapeG()
    fun endShapeG(mode: Int)

    val controlX: Float
    val controlY: Float
}
