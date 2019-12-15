package main.shapes.components

import main.shapes.Visitor
import main.shapes.impl.BasicMethodsImpl
import java.awt.Canvas
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Shape

open class BasicShapeDecorator(private val component: BasicMethodsImpl): Canvas() {

    fun calculateArea(): Double {
        return component.calculateArea(v = Visitor())
    }
    fun calculatePerimeter(): Double {
        return component.calculatePerimeter(v = Visitor())
    }
    override fun move(x: Int, y: Int) {
        component.move(x, y)
    }
    fun getShape(): Shape {
        return component.getShape()
    }
    override fun paint(g: Graphics?) {
        val g2d: Graphics2D = g as Graphics2D
        component.draw(g2d)
    }
}