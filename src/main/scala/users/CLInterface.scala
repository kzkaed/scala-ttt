package users

import base._

class CLInterface extends UserInterface with OutputInput {
  val presenter = new CLInterfacePresenter()
  val validator = new Validator()
   
  def prepare(): Unit = {
    print(Communication.messages('welcome))
  }
    
  def displayBoard(board: Array[String]): Unit = { 
    print(presenter.construct(board))
  }
    
  def readCellNumber(availableCells: List[String]): String = {
    askForCellNumber()
    validate(availableCells)
  }
  
  def displayGameResult(playerMark1: String, playerMark2: String, game: GameRules): Unit = {
    print(presenter.gameResult(playerMark1, playerMark2, game))
  }
  
  def goodbye(): Unit = {
    print(Communication.messages('goodbye))
  }
  
  private def askForCellNumber() = { 
    print(Communication.messages('enter)) 
  }
   
  def validate(availableCells: List[String]):String = {
    var cell = validator.validate(readLine(), availableCells)  
    if (cell == "invalid"){
      cell = askForCellNumberAgain(availableCells: List[String])
    }
    cell
  }
  
  def askForCellNumberAgain(availableCells: List[String]): String = {
    print(Communication.messages('incorrect))
    readCellNumber(availableCells: List[String])   
  }
  
}