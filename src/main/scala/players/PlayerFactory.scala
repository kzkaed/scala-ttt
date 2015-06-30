package players

import ai._
import ui._

object PlayerFactory {
  
  def getPlayer(s: String, playerMark: String, engine: Intelligence, userInterface: UserInterface): Player = {
    if(s == "computer") return new Computer(playerMark,engine)
    else return new Human(playerMark, userInterface)
  }
}