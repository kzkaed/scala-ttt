package ui

trait UserInterface {
  
  def prepare(): Unit
  def displayBoard(board: Array[String]): Unit
  def goodbye(): Unit 
  def readCellNumber(): String
  
}