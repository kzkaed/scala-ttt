package gui

import base._

trait UserInterface {
  
  def prepare(): Unit
  def displayBoard(board: Array[String]): Unit
  def construct(board:Array[String]): String
  def goodbye(): Unit 
  def readCellNumber(availableCells: List[String]): String
  def displayGameResult(player1Mark: String, player2Mark: String, game: GameRules)
  
}