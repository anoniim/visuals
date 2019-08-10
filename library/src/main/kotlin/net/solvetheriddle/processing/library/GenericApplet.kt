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

    /* Custom fields */

    private val isLandscape by lazy { width > height }
    private val screenPadding = 5

    private val controlXStart by lazy {
        when (controlMode) {
            ControlMode.OVERLAY -> 0
            ControlMode.PAD -> if (isLandscape) height else 0
        }
    }
    private val controlXEnd by lazy { width }
    private val controlYStart by lazy {
        when (controlMode) {
            ControlMode.OVERLAY -> 0
            ControlMode.PAD -> if (isLandscape) 0 else width
        }
    }
    private val controlYEnd by lazy { height }
    private val controlWidth by lazy { controlXEnd - controlXStart - screenPadding }
    private val controlHeight by lazy { controlYEnd - controlYStart }

    val middleX by lazy {
        when (controlMode) {
            ControlMode.OVERLAY -> width / 2F
            ControlMode.PAD -> if (isLandscape) height / 2F else width / 2F
        }
    }
    val middleY by lazy {
        when (controlMode) {
            ControlMode.OVERLAY -> height / 2F
            ControlMode.PAD -> if (isLandscape) height / 2F else width / 2F
        }
    }
    val controlX: Float = 1F
        get() {
            return when (controlMode) {
                ControlMode.OVERLAY -> mouseX.toFloat()
                ControlMode.PAD -> {
                    val isWithinControlBounds = mouseX in controlXStart..controlXEnd && mouseY in controlYStart..controlYEnd
                    if (isWithinControlBounds) {
                        val mouseXControl = mouseX - controlXStart
                        (if (mouseXControl != 0) mouseXControl else 1) / (controlWidth / 100F)
                    } else {
                        // return the last value within bounds
                        field
                    }
                }
            }
        }

    val controlY: Float = 1F
        get() {
            return when (controlMode) {
                ControlMode.OVERLAY -> mouseY.toFloat()
                ControlMode.PAD -> {
                    val isWithinControlBounds = mouseX in controlXStart..controlXEnd && mouseY in controlYStart..controlYEnd
                    if (isWithinControlBounds) {
                        val mouseYControl = mouseY - controlYStart
                        (if (mouseYControl != 0) mouseYControl else 1) / (controlHeight / 100F)
                    } else {
                        // return the last value within bounds
                        field
                    }
                }
            }
        }
    var controlMode = ControlMode.OVERLAY

    fun controlMode(mode: ControlMode) { controlMode = mode }

    fun showControls(horizontalControlCount: Int = 0, verticalControlCount: Int = 0) {
        stroke(80)
        // Horizontal control = vertical lines
        drawControlLines(horizontalControlCount, controlXStart, controlWidth) { x ->
            line(x, controlYStart.toFloat(), x, controlYEnd.toFloat())
        }
        // Vertical control = horizontal lines
        drawControlLines(verticalControlCount, controlYStart, controlHeight) { y ->
            line(controlXStart.toFloat(), y, controlXEnd.toFloat(), y)
        }
    }

    private fun drawControlLines(lineCount: Int, // number of lines
                                 startCoordinate: Int, // start coordinate of the space
                                 totalSpace: Int, // width/height of the space
                                 drawLine: (Float) -> Unit) {
        if (lineCount != 0) {
            val lineStep = totalSpace / lineCount
            // Do not draw the first and the last line
            for (i in 1 until lineCount) {
                val lineCoordinate: Float = (startCoordinate + i * lineStep).toFloat()
                drawLine(lineCoordinate)
            }
        }
    }
}

enum class ControlMode {
    PAD,
    OVERLAY
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
}
