package gui

import base._

class TConsole extends UserInterface with OutputInput {
  val presenter = new TConsolePresenter()
  val cells = List("1","2","3","4","5","6","7","8","9")
   
  def prepare(): Unit = {
    print(Communication.messages('welcome))
  }
    
  def displayBoard(board: Array[String]): Unit = { 
    print(presenter.construct(board))
  }
    
  def readCellNumber(availableCells: List[String]): String = {
    askForCellNumber()
    validate(readLine(), availableCells)   
  }
  
  def displayGameResult(playerMark1: String, playerMark2: String, game: GameRules): Unit = {
    print(gameResult(playerMark1, playerMark2, game))
  }
  
  def goodbye(): Unit = {
    print(Communication.messages('goodbye))
  }
  
  private def askForCellNumber() = { 
    print(Communication.messages('enter)) 
  }
  
  private def askForCellNumberAgain(availableCells: List[String]) = {
    print(Communication.messages('incorrect))
    readCellNumber(availableCells: List[String])   
  }
  
  private def validate(cell: String, availableCells: List[String]):String = {
    if(isValid(cell,availableCells)) cell
    else askForCellNumberAgain(availableCells: List[String])  
  }
  
  private def isValid(cell: String, availableCells: List[String]): Boolean = {
    availableCells.contains(cell)
  }
  
  private def gameResult(playerMark1: String, playerMark2: String, game: GameRules): String = {
    if (game.isWin) game.winnerMark() + Communication.messages('win)
    else Communication.messages('draw)
  }
  
}