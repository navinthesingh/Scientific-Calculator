package ch.makery.Calculator

import javafx.scene.layout.BorderPane
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.Image
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import javafx.{scene => jfxs}
import scalafx.Includes._

import java.net.URL

object MainApp extends JFXApp {

  val rootResource: URL = getClass.getResource("/RootLayout.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots: BorderPane = loader.getRoot[jfxs.layout.BorderPane]

  stage = new PrimaryStage {
    resizable = false // Allow the screen to be resizable
    icons += new Image("/Calculator_Icon.png")
    scene = new Scene {
      root = roots
    }
  }

  def volumeAndSurfacePage(): Any = {
    val resource = getClass.getResource("/VolumeSurfaceArea.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  def calcMain(): Any ={
    val resource = getClass.getResource("/Calculator.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  calcMain()
}
