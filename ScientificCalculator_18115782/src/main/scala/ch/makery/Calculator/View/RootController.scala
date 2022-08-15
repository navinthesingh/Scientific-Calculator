package ch.makery.Calculator.View

import ch.makery.Calculator.MainApp
import scalafxml.core.macros.sfxml


@sfxml
class RootController {

  def calculatorPage(): Unit ={
    MainApp.calcMain()
  }

  def shapesPage(): Unit ={
    MainApp.volumeAndSurfacePage()
  }

}
