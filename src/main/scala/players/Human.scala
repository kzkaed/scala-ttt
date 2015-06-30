package players
import base.GameRules
import ui._

class Human (var playerMark: String, userInterface: UserInterface) extends Player {
  
  def selectMove(game: GameRules): String = {
    val moveSelection = userInterface.readCellNumber()
    moveSelection
  }
  def getPlayerMark(): String = {
    playerMark
  }
  
  
}