package gui

import base._

class TConsole extends UserInterface with OutputInput {
  val messageMap = Map ('welcome    -> "Welcome to Scala Tic Tac Toe",
                         'enter     -> "Enter cell number: ",
                         'incorrect -> "Incorrect input, try again.",
                         'win       -> " Wins!", 
                         'draw      -> "It is a draw.",
                         'goodbye   -> "Goodbye")
                         
  val cells = List("1","2","3","4","5","6","7","8","9")
   
  def prepare(): Unit = print(messageMap('welcome))
  
  
  def displayBoard(board: Array[String]) = { 
    print(construct(board))
  }
    
  def displayGameResult(playerMark1: String, playerMark2: String, game: GameRules){
    print(gameResult(playerMark1, playerMark2, game))
  }

  def goodbye(): Unit = {
    print(messageMap('goodbye))
  }
  
  def readCellNumber(availableCells: List[String]): String = {
    askForCellNumber
    validate(readLine(), availableCells)   
  }
  
  def construct(board: Array[String]): String = {
   board(0) + " | " + board(1) + " | " + board(2) + "\n" +
   board(3) + " | " + board(4) + " | " + board(5) + "\n" +
   board(6) + " | " + board(7) + " | " + board(8) + "\n"
  }
  
  private def askForCellNumber() = { print(messageMap('enter)) }
 
  private def isValid(cell: String, availableCells: List[String]): Boolean = {
    availableCells.contains(cell)
  }
  
  private def askForCellNumberAgain(availableCells: List[String]) = {
    print(messageMap('incorrect))
    readCellNumber(availableCells: List[String])   
  }
  
  private def validate(cell: String, availableCells: List[String]):String = {
    if(isValid(cell,availableCells)) cell
    else askForCellNumberAgain(availableCells: List[String])  
  }
  
  private def gameResult(playerMark1: String, playerMark2: String, game: GameRules): String = {
    if (game.isWin) game.winnerMark() + messageMap('win)
    else messageMap('draw)
  }
  
}