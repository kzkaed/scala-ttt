package gui

import base._

trait UserInterface {
  
  def prepare(): Unit
  def displayBoard(board: Array[String]): Unit
  def goodbye(): Unit 
  def readCellNumber(availableCells: List[String]): String
  
}