package main.shapes.components

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class BasicLine(beginDot: BasicDot, endDot: BasicDot) {
    val length: Double = sqrt(abs(((endDot.x - beginDot.x).toDouble()).pow(2) + ((endDot.y - beginDot.y).toDouble()).pow(2)))
}