package net.solvetheriddle.processing.java.utils

import processing.core.PImage
import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

class ImageLoad {

    fun getImage(url: String): PImage {
        var image: BufferedImage? = null
        try {
            image = ImageIO.read(ImageLoad::class.java.classLoader.getResourceAsStream(url))
        } catch (e: IOException) {
            println("UNABLE TO LOAD IMAGE!!")
            e.printStackTrace()
        }

        return PImage(image)
    }
}