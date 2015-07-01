package players
import base.GameRules
import gui._

class Human (var playerMark: String, userInterface: UserInterface) extends Player {
  
  def selectMove(game: GameRules): String = {
    userInterface.readCellNumber(game.availableCells())
  }
  
  def getPlayerMark(): String = {
    playerMark
  }
  
  
}