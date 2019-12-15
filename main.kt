package main.shapes

import main.shapes.components.*
import main.shapes.func.createWindow
import java.io.File
import java.io.FileWriter
import java.io.Writer
import java.nio.file.Path
import java.util.*

fun main(){
    val input = Scanner(Path.of("src/main/shapes/res/input.txt"))
    val output: Writer = FileWriter(File("src/main/shapes/res/output.txt"))
    val shapes = mutableListOf<BasicShapeDecorator>()
    var line: String
    val types = mutableListOf<String>()
    var type: String
    var argsOfShape = mutableListOf<Int>()
    while (input.hasNextLine()) {
        line = input.nextLine()
        type = line.substring(0, line.indexOf(':'))
        types.add(type)
        val tmpInputMaskFormatter = Regex("(;\\s)?[PCR][0-9]*=|[,;]\\s?").split(line.subSequence(line.indexOf(':'), line.length))
        for (i in 1 until tmpInputMaskFormatter.size) {
            argsOfShape.add(tmpInputMaskFormatter[i].toInt())
        }
        when (type) {
            "TRIANGLE" -> {
                shapes.add(TriangleFabric.createShape(argsOfShape))
            }
            "RECTANGLE" -> {
                shapes.add(RectangleFabric.createShape(argsOfShape))
            }
            "CIRCLE" -> {
                shapes.add(CircleFabric.createShape(argsOfShape))
            }
        }
        argsOfShape = mutableListOf()
    }
    createWindow(output, shapes, types)
}
