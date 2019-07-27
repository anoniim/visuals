package net.solvetheriddle.processing.android.app

import net.solvetheriddle.processing.library.GenericApplet
import net.solvetheriddle.processing.library.sketches.*
import java.util.*

object SketchList {

    val ITEMS: MutableList<SketchItem> = ArrayList()

    init {
        addSketch(DownUpSpiral::class.java)
        addSketch(UpDownSpiral::class.java)
        addSketch(InwardSpiral::class.java)
        addSketch(PolygonCircles::class.java)
        addSketch(PolygonCircles2::class.java)
        addSketch(PolygonCircles3::class.java)
    }

    private fun <Applet : net.solvetheriddle.processing.library.GenericApplet>addSketch(javaClass: Class<Applet>) {
        ITEMS.add(
            SketchItem(
                javaClass.name,
                javaClass.simpleName
            ) {
                javaClass.constructors[0].newInstance() as GenericApplet
            })
    }

}

data class SketchItem(val id: String, val content: String, val initializer: () -> net.solvetheriddle.processing.library.GenericApplet)
