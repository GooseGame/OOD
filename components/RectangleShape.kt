package main.shapes.components

import main.shapes.Visitor
import main.shapes.impl.BasicMethodsImpl
import java.awt.*
import java.awt.geom.Rectangle2D

class RectangleShape(args: IntArray): BasicMethodsImpl {
    val leftUpDot = BasicDot(args[0], args[1])
    val rightDownDot = BasicDot(args[2], args[3])
    var shape = Rectangle2D.Float(leftUpDot.x.toFloat(), leftUpDot.y.toFloat(),
        (rightDownDot.x - leftUpDot.x).toFloat(), (rightDownDot.y - leftUpDot.y).toFloat())

    override fun draw(g: Graphics2D) {
        g.color = Color.YELLOW

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
        return v.calculateAreaRect(this)

    }

    override fun calculatePerimeter(v: Visitor): Double {
        return v.calculatePerimeterRect(this)
    }
}