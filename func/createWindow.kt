package main.shapes.func

import main.shapes.components.BasicShapeDecorator
import main.shapes.components.BasicWindow
import java.io.Writer
import javax.swing.JFrame

fun createWindow(output: Writer, shapes: MutableList<BasicShapeDecorator>, types: MutableList<String>) {
    val frame = JFrame("shapes")
    val panel = BasicWindow()
    panel.isDoubleBuffered = true
    fillPanelWithContent(panel, shapes)
    outputValues(output, types, shapes)
    output.flush()
    output.close()
    frame.add(panel)
    frame.setSize(1000, 1000)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE;
    frame.isVisible = true
    panel.addSomeInteractive()
}
fun fillPanelWithContent(panel: BasicWindow, shapes: MutableList<BasicShapeDecorator>) {
    shapes.forEach {
        panel.addShape(it)
    }
}
fun outputValues(output: Writer, types: MutableList<String>, shapes: MutableList<BasicShapeDecorator>) {
    for (i in 0 until shapes.size) {
        output.write(makeOutput(types[i], shapes[i].calculatePerimeter(), shapes[i].calculateArea()))
    }
}