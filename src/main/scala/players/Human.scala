package players
import base.GameRules
import users._

class Human (var playerMark: String, userInterface: UserInterface) extends Player {
  
  def selectMove(game: GameRules): String = {
    userInterface.readCellNumber(game.availableCells())
  }  
}