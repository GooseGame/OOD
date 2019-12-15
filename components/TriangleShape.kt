package main.shapes.components
import main.shapes.Visitor
import main.shapes.impl.BasicMethodsImpl
import java.awt.*

class TriangleShape(args: IntArray): BasicMethodsImpl {
    val a = BasicDot(args[0], args[1])
    val b = BasicDot(args[2], args[3])
    val c = BasicDot(args[4], args[5])
    var shape = Polygon(listOf(a.x,b.x,c.x).toIntArray(), listOf(a.y,b.y,c.y).toIntArray(), 3)

    override fun draw(g: Graphics2D) {
        g.color = Color.GREEN

        g.fill(shape)
    }

    override fun getShape(): Shape {
        return shape
    }
    override fun move(x: Int, y: Int) {
        shape.xpoints = arrayOf(shape.xpoints[0]+x, shape.xpoints[1]+x, shape.xpoints[2]+x).toIntArray()
        shape.ypoints = arrayOf(shape.ypoints[0]+y, shape.ypoints[1]+y, shape.ypoints[2]+y).toIntArray()

    }

    override fun calculateArea(v: Visitor): Double {
        return v.calculateAreaTriangle(this)
    }

    override fun calculatePerimeter(v: Visitor): Double {
        return v.calculatePerimeterTriangle(this)
    }
}