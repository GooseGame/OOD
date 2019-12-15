package main.shapes

import main.shapes.components.BasicLine
import main.shapes.components.CircleShape
import main.shapes.components.RectangleShape
import main.shapes.components.TriangleShape
import main.shapes.impl.VisitorImpl
import kotlin.math.abs

class Visitor: VisitorImpl {
    override fun calculatePerimeterTriangle(shape: TriangleShape): Double {
        val ac = BasicLine(shape.a, shape.c)
        val ab = BasicLine(shape.a, shape.b)
        val bc = BasicLine(shape.b, shape.c)
        return ac.length + ab.length + bc.length
    }

    override fun calculateAreaTriangle(shape: TriangleShape): Double {
        return abs(0.5 * (((shape.a.x - shape.c.x) * (shape.b.y - shape.c.y)) - ((shape.a.y - shape.c.y) * (shape.b.x - shape.c.x))))
    }

    override fun calculatePerimeterCircle(shape: CircleShape): Double {
        return 2 * Math.PI * shape.radius
    }

    override fun calculateAreaCircle(shape: CircleShape): Double {
        return Math.PI * shape.radius * shape.radius
    }

    override fun calculatePerimeterRect(shape: RectangleShape): Double {
        return ((shape.rightDownDot.x - shape.leftUpDot.x) * 2 + (shape.rightDownDot.y - shape.leftUpDot.y) * 2).toDouble()
    }

    override fun calculateAreaRect(shape: RectangleShape): Double {
        return ((shape.rightDownDot.x - shape.leftUpDot.x) * (shape.rightDownDot.y - shape.leftUpDot.y)).toDouble()
    }

}