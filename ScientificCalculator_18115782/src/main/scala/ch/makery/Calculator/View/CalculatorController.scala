package ch.makery.Calculator.View

import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{Button, Label}
import scalafx.scene.text.Text
import scalafxml.core.macros.sfxml

import scala.collection.mutable.ArrayBuffer


@sfxml
class CalculatorController(private val answerLabel: Label,
                           private val history: Text,
                           private val savedNumbers: Text,
                           private val button0: Button,
                           private val button1: Button,
                           private val button2: Button,
                           private val button3: Button,
                           private val button4: Button,
                           private val button5: Button,
                           private val button6: Button,
                           private val button7: Button,
                           private val button8: Button,
                           private val button9: Button,
                           private val euler: Button,
                           private val PI: Button,
                           private val SIN: Button,
                           private val COS: Button,
                           private val TAN: Button,
                           private val Log: Button,
                           private val factorial: Button,
                           private val squareRoot: Button,
                           private val add: Button,
                           private val minus: Button,
                           private val multiply: Button,
                           private val divide: Button,
                           private val calculate: Button,
                           private val clearAnswerLabel: Button){


  private var initialNum = ""
  private var currentNum = ""
  private var operationType = ""

  private var historyCount = 0

  private val calculationHistory: ArrayBuffer[String] = ArrayBuffer[String]()


  add.onAction  = (_: ActionEvent) => {
    calculationSetup("+")
  }
  minus.onAction  = (_: ActionEvent) => {
    calculationSetup("-")
  }
  multiply.onAction  = (_: ActionEvent) => {
    calculationSetup("*")
  }
  divide.onAction  = (_: ActionEvent) => {
    calculationSetup("/")
  }


  SIN.onAction = (_: ActionEvent) => {
    try {
      calculationSetup("sin")
      val calculatedNumber = math.sin("%1.5f".format(initialNum.toDouble * (math.Pi / 180)).toDouble)
      savedNumbers.setText("sin(" + initialNum + ") " + " = " + "%1.5f".format(calculatedNumber) + "\n")
      answerLabel.setText(String.valueOf("%1.5f".format(calculatedNumber)))
      calculationHistory.append("sin(" + initialNum + ") " + " = " + "%1.5f".format(calculatedNumber) + "\n")
      currentNum = calculatedNumber.toString
      historyCount += 1
      history.text = history.text() + calculationHistory(historyCount - 1)
    }catch{
      case _: NumberFormatException => println("No number to apply Sine Function")
    }

  }
  COS.onAction = (_: ActionEvent) => {
    try {
      calculationSetup("cos")
      val calculatedNumber = math.cos("%1.5f".format(initialNum.toDouble * (math.Pi / 180)).toDouble)
      savedNumbers.setText("cos(" + initialNum + ") " + " = " + "%1.5f".format(calculatedNumber) + "\n")
      answerLabel.setText(String.valueOf("%1.5f".format(calculatedNumber)))
      calculationHistory.append("cos(" + initialNum + ") " + " = " + "%1.5f".format(calculatedNumber) + "\n")
      currentNum = calculatedNumber.toString
      historyCount += 1
      history.text = history.text() + calculationHistory(historyCount - 1)
    }catch{
      case _: NumberFormatException => println("No number to apply Cosine function")
    }
  }
  TAN.onAction = (_: ActionEvent) => {
    try {
      calculationSetup("tan")
      val calculatedNumber = math.tan("%1.5f".format(initialNum.toDouble * (math.Pi / 180)).toDouble)
      savedNumbers.setText("tan(" + initialNum + ") " + " = " + "%1.5f".format(calculatedNumber) + "\n")
      answerLabel.setText(String.valueOf("%1.5f".format(calculatedNumber)))
      calculationHistory.append("tan(" + initialNum + ") " + " = " + "%1.5f".format(calculatedNumber) + "\n")
      currentNum = calculatedNumber.toString
      historyCount += 1
      history.text = history.text() + calculationHistory(historyCount - 1)
    }catch{
      case _: NumberFormatException => println("No number to apply Tangent function")
    }
  }
  Log.onAction = (_: ActionEvent) => {
    try {
      calculationSetup("log")
      val calculatedNumber = math.log10(initialNum.toDouble)
      savedNumbers.setText("log(" + initialNum + ") " + " = " + calculatedNumber + "\n")
      answerLabel.setText(String.valueOf(calculatedNumber))
      calculationHistory.append("log(" + initialNum + ") " + " = " + calculatedNumber + "\n")
      currentNum = calculatedNumber.toString
      historyCount += 1
      history.text = history.text() + calculationHistory(historyCount - 1)
    }catch{
      case _: NumberFormatException => println("No number to apply Log function")
    }
  }
  factorial.onAction = (_: ActionEvent) => {
    try {
      var i = 0
      var fact = 1
      i = 1
      calculationSetup("!")
      while (i <= initialNum.toInt) {
        fact = fact * i
        i += 1
      }
      val calculatedNumber = fact
      savedNumbers.setText(initialNum + "!" + " = " + calculatedNumber + "\n")
      answerLabel.setText(String.valueOf(calculatedNumber))
      calculationHistory.append(initialNum + "!" + " = " + calculatedNumber + "\n")
      currentNum = calculatedNumber.toString
      historyCount += 1
      history.text = history.text() + calculationHistory(historyCount - 1)
    }catch{
      case _: NumberFormatException => println("No number to apply Factorial")
    }
  }
  squareRoot.onAction = (_: ActionEvent) => {
    try {
      calculationSetup("√")
      val calculatedNumber = math.sqrt(initialNum.toDouble)
      savedNumbers.setText("√" + initialNum + " = " + calculatedNumber + "\n")
      answerLabel.setText(String.valueOf(calculatedNumber))
      calculationHistory.append("√" + initialNum + " = " + calculatedNumber + "\n")
      currentNum = calculatedNumber.toString
      historyCount += 1
      history.text = history.text() + calculationHistory(historyCount - 1)
    }catch{
      case _: NumberFormatException => println("No number to apply to the square root function")
    }
  }



  def calculationSetup(calculationType: String): Unit = {
    this.operationType = calculationType
    initialNum = currentNum
    currentNum = ""
    if(calculationType == "+" || calculationType == "-" || calculationType == "*" || calculationType == "/") {
      savedNumbers.setText(initialNum + " " + calculationType)
    }else if(calculationType == "sin" || calculationType == "cos" || calculationType == "tan" ||
      calculationType == "log"){
      savedNumbers.setText(calculationType + "(" + initialNum + ") ")
    }else if(calculationType == "!"){
      savedNumbers.setText(initialNum + calculationType)
    }else{
      savedNumbers.setText(calculationType + initialNum)
    }
  }

  calculate.onAction = (_: ActionEvent) => {
    try{
      val firstNumberInt = initialNum.toDouble
      val secondNumberInt = currentNum.toDouble
      operationType match {
        case "+" => val calculatedNumber = firstNumberInt + secondNumberInt
          savedNumbers.setText(initialNum + " + " + currentNum + " = " + calculatedNumber)
          answerLabel.setText(String.valueOf(calculatedNumber))
          calculationHistory.append(initialNum + " + " + currentNum + " = " + calculatedNumber + "\n")
          currentNum = calculatedNumber.toString
          historyCount += 1

        case "-" => val calculatedNumber = firstNumberInt - secondNumberInt
          savedNumbers.setText(initialNum + " - " + currentNum + " = " + calculatedNumber)
          answerLabel.setText(String.valueOf(calculatedNumber))
          calculationHistory.append(initialNum + " - " + currentNum + " = " + calculatedNumber + "\n")
          currentNum = calculatedNumber.toString
          historyCount += 1

        case "/" => val calculatedNumber = firstNumberInt / secondNumberInt
          savedNumbers.setText(initialNum + " / " + currentNum + " = " + "%1.5f".format(calculatedNumber))
          answerLabel.setText(String.valueOf(calculatedNumber))
          calculationHistory.append(initialNum + " / " + currentNum + " = " + "%1.5f".format(calculatedNumber) + "\n")
          currentNum = "%1.5f".format(calculatedNumber)
          historyCount += 1

        case "*" => val calculatedNumber = firstNumberInt * secondNumberInt
          savedNumbers.setText(initialNum + " * " + currentNum + " = " + calculatedNumber)
          answerLabel.setText(String.valueOf(calculatedNumber))
          calculationHistory.append(initialNum + " * " + currentNum + " = " + calculatedNumber + "\n")
          currentNum = calculatedNumber.toString
          historyCount += 1
      }
      // Append to the history
      history.text = history.text() + calculationHistory(historyCount - 1)

    }catch{
      case _: NumberFormatException => println("No number was given to be calculated")
    }
  }

  clearAnswerLabel.onAction = (_: ActionEvent) => {
    currentNum = ""
    answerLabel.setText("")
    savedNumbers.setText("")
  }



  button0.onAction  = (_: ActionEvent) => {
    if (!(currentNum == "")) addNumber("0")
  }
  button1.onAction  = (_: ActionEvent) => {
    addNumber("1")
  }
  button2.onAction  = (_: ActionEvent) => {
    addNumber("2")
  }
  button3.onAction  = (_: ActionEvent) => {
    addNumber("3")
  }
  button4.onAction  = (_: ActionEvent) => {
    addNumber("4")
  }
  button5.onAction  = (_: ActionEvent) => {
    addNumber("5")
  }
  button6.onAction  = (_: ActionEvent) => {
    addNumber("6")
  }
  button7.onAction  = (_: ActionEvent) => {
    addNumber("7")
  }
  button8.onAction  = (_: ActionEvent) => {
    addNumber("8")
  }
  button9.onAction  = (_: ActionEvent) => {
    addNumber("9")
  }
  euler.onAction  = (_: ActionEvent) => {
    addNumber("%1.5f".format(math.E))
  }
  PI.onAction = (_: ActionEvent) => {
    addNumber("%1.5f".format(math.Pi))
  }

  def updateAnswerLabel(): Unit = {
    answerLabel.setText(currentNum)
  }

  def addNumber(number: String): Unit = {
    currentNum += number
    updateAnswerLabel()
  }

  def clearHistory(): Unit ={
    history.setText(" ")
  }


}