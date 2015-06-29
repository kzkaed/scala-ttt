package base

import ui._
import players._


class Runner(val game: GameRules, 
             val userInterface: UserInterface, 
             val player1: Player, 
             val player2: Player){
  
  def run() : Unit = {
    
    while(!game.isEnd){
      val currentMark = "x"
      val currentMove = "1"
      val currentBoard = game.getCurrentBoard()
      game.takeTurn(currentMark, currentMove)
    }
    userInterface.goodbye()  
  }
 
  
  
}