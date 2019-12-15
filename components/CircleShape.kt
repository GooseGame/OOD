package main.shapes.components

import main.shapes.Visitor
import main.shapes.impl.BasicMethodsImpl
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Shape
import java.awt.geom.Ellipse2D

class CircleShape(args: IntArray): BasicMethodsImpl {
    val radius = args[2]
    private val center = BasicDot(args[0], args[1])
    var shape = Ellipse2D.Float(center.x.toFloat(), center.y.toFloat(), 2*radius.toFloat(), 2*radius.toFloat())

    override fun draw(g: Graphics2D) {

        g.color = Color.RED
        g.fill(shape)
    }

    override fun getShape(): Shape {
        return shape
    }
    override fun move(x: Int, y: Int) {
        shape.x+=x
        shape.y+=y
    }

    override fun calculateArea(v: Visitor): Double {
        return v.calculateAreaCircle(this)
    }

    override fun calculatePerimeter(v: Visitor): Double {
        return v.calculatePerimeterCircle(this)
    }

}