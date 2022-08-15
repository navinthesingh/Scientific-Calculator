package ch.makery.Calculator.View

import scalafx.scene.control.TextField
import scalafx.scene.text.Text
import scalafxml.core.macros.sfxml


@sfxml
class GeometricController(private val cubeLength: TextField,
                          private val cubeSurface: Text,
                          private val cubeVolume: Text,
                          private val rectLength: TextField,
                          private val rectWidth: TextField,
                          private val rectHeight: TextField,
                          private val rectSurface: Text,
                          private val rectVolume: Text,
                          private val cylinderHeight: TextField,
                          private val cylinderRadius: TextField,
                          private val cylinderSurface: Text,
                          private val cylinderVolume: Text,
                          private val coneRadius: TextField,
                          private val coneHeight: TextField,
                          private val coneVolume: Text,
                          private val coneSurface: Text,
                          private val pyramidLength: TextField,
                          private val pyramidHeight: TextField,
                          private val pyramidVolume: Text,
                          private val pyramidSurface: Text,
                          private val sphereRadius: TextField,
                          private val sphereVolume: Text,
                          private val sphereSurface: Text) {



  def calculate1(): Unit = {
    try {
      cubeVolume.text = "%1.2f".format(math.pow(cubeLength.text().toDouble, 3))
      cubeSurface.text = "%1.2f".format(6 * math.pow(cubeLength.text().toDouble, 2))
    }catch{
      case _: NumberFormatException => println("Please input the length")
    }
  }


  def calculate2(): Unit = {
    try {
      val length = rectLength.text().toDouble
      val width = rectWidth.text().toDouble
      val height = rectHeight.text().toDouble
      rectVolume.text = "%1.2f".format(length * width * height)
      rectSurface.text = "%1.2f".format(2 * ((length * width) + (length * height) + (height * width)))
    }catch{
      case _: NumberFormatException => println("Please make sure all fields are filled")
    }
  }


  def calculate3(): Unit = {
    try {
      val height = cylinderHeight.text().toDouble
      val radius = cylinderRadius.text().toDouble
      cylinderVolume.text = "%1.2f".format(math.Pi * math.pow(radius, 2) * height)
      cylinderSurface.text = "%1.2f".format((2 * math.Pi * radius * height) + (2 * math.Pi * math.pow(radius, 2)))
    }catch{
      case _: NumberFormatException => println("Please make sure all fields are filled")
    }
  }


  def calculate4(): Unit = {
    try {
      val radius = coneRadius.text().toDouble
      val height = coneHeight.text().toDouble
      val slantedHeight = math.sqrt(math.pow(height, 2) + math.pow(radius, 2))
      coneVolume.text = "%1.2f".format((math.Pi * math.pow(radius, 2) * height) / 3)
      coneSurface.text = "%1.2f".format((math.Pi * radius * slantedHeight) + (math.Pi * math.pow(radius, 2)))
    }catch{
      case _: NumberFormatException => println("Please make sure all fields are filled")
    }
  }


  def calculate5(): Unit = {
    try {
      val length = pyramidLength.text().toDouble
      val height = pyramidHeight.text().toDouble
      val slantedHeight = math.sqrt(math.pow(height, 2) + math.pow(length / 2, 2))
      pyramidVolume.text = "%1.2f".format((math.pow(length, 2) * height) / 3)
      pyramidSurface.text = "%1.2f".format(math.pow(length, 2) + 4 * ((length * slantedHeight) / 2))
    }catch{
      case _: NumberFormatException => println("Please make sure all fields are filled")
    }
  }

  def calculate6(): Unit = {
    try {
      val radius = sphereRadius.text().toDouble
      sphereVolume.text = "%1.2f".format((4 * math.Pi * math.pow(radius, 3)) / 3)
      sphereSurface.text = "%1.2f".format(4 * math.Pi * math.pow(radius, 2))
    }catch{
      case _: NumberFormatException => println("Please input the radius")
    }
  }
}
