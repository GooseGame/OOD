package main.shapes.impl

import main.shapes.components.CircleShape
import main.shapes.components.RectangleShape
import main.shapes.components.TriangleShape

interface VisitorImpl {
    fun calculateAreaRect(shape: RectangleShape):Double
    fun calculatePerimeterRect(shape: RectangleShape):Double
    fun calculateAreaCircle(shape: CircleShape):Double
    fun calculatePerimeterCircle(shape: CircleShape):Double
    fun calculateAreaTriangle(shape: TriangleShape):Double
    fun calculatePerimeterTriangle(shape: TriangleShape):Double
}