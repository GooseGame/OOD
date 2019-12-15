package main.shapes.impl

import main.shapes.Visitor
import java.awt.Graphics2D
import java.awt.Shape

interface BasicMethodsImpl {
    fun calculatePerimeter(v: Visitor): Double
    fun calculateArea(v: Visitor): Double
    fun draw(g: Graphics2D)
    fun move(x: Int, y: Int)
    fun getShape(): Shape
}