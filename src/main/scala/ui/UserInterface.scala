package ui

trait UserInterface {
  
  //def print(s: String) = Predef.println()
  
  def prepare(): Unit
  def displayBoard(board: Array[String]): Unit
  def goodbye(): Unit 
  
}