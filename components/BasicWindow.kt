package main.shapes.components

import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JPanel

@Suppress("DEPRECATION")
class BasicWindow: JPanel() {
    var shapes = mutableListOf<BasicShapeDecorator>()
    private val ma = MovingAdapter(shapes, this)

    fun addSomeInteractive() {
        addMouseMotionListener(ma)
        addMouseListener(ma)
    }

    fun addShape(shape: BasicShapeDecorator) {
        shapes.add(shape)
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        g.let {
            shapes.forEach {
                it.paint(g)
            }
        }

    }
    class MovingAdapter(val shapes: MutableList<BasicShapeDecorator>, val window: BasicWindow) : MouseAdapter() {
        private var x = 0
        private var y = 0

        override fun mousePressed(e: MouseEvent) {
            x = e.x
            y = e.y
        }

        override fun mouseDragged(e: MouseEvent) {
            var dx = e.x - x
            var dy = e.y - y


            for (i in 1 .. shapes.size) {
                if (shapes[shapes.size - i].getShape().bounds2D.contains(x.toDouble(),y.toDouble())) {
                    shapes[shapes.size - i].move(dx,dy)
                    window.repaint()
                    break
                }
            }

            x += dx
            y += dy
        }
    }
}
