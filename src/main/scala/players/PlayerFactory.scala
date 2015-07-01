package players

import ai._
import gui._

object PlayerFactory {
  
  def getPlayer(s: String, playerMark: String, engine: Intelligence, userInterface: UserInterface): Player = {
    if(s == "computer") return new Computer(playerMark,engine)
    else return new Human(playerMark, userInterface)
  }
}