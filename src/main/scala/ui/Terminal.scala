package ui

class Terminal extends UserInterface {
  
  def prepare(): Unit = {
    println("Welcome")
  }
  
  def displayBoard(board: Array[String]) = {
    println(board.toString())
  }
  
  def goodbye(): Unit = {
    println("goodbye")
  }
  
  
}