package players

import ai._
import gui._

object PlayerFactory {
  
  def getPlayer(playerType: String, playerMark: String, engine: Intelligence, userInterface: UserInterface): Player = {
    if(playerType == "computer") new Computer(playerMark, engine)
    else new Human(playerMark, userInterface)
  }
}