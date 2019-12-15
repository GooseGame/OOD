package main.shapes

import main.shapes.components.BasicShapeDecorator
import main.shapes.components.CircleShape
import main.shapes.components.RectangleShape
import main.shapes.components.TriangleShape

interface Factory<BasicShapeDecorator> {
    fun createShape(argsOfShape: MutableList<Int>):BasicShapeDecorator
}

class CircleFabric  {
    companion object : Factory<BasicShapeDecorator> {
        override fun createShape(argsOfShape: MutableList<Int>): BasicShapeDecorator {
            return BasicShapeDecorator(CircleShape(argsOfShape.toIntArray()))
        }
    }
}

class TriangleFabric  {
    companion object : Factory<BasicShapeDecorator> {
        override fun createShape(argsOfShape: MutableList<Int>): BasicShapeDecorator {
            return BasicShapeDecorator(TriangleShape(argsOfShape.toIntArray()))
        }
    }
}

class RectangleFabric  {
    companion object : Factory<BasicShapeDecorator> {
        override fun createShape(argsOfShape: MutableList<Int>): BasicShapeDecorator {
            return BasicShapeDecorator(RectangleShape(argsOfShape.toIntArray()))
        }
    }
}
