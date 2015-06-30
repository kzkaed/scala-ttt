package base

import ui._
import players._


class Runner(val game: GameRules, 
             val userInterface: UserInterface, 
             val player1: Player, 
             val player2: Player){
  
  def run() : Unit = {
    userInterface.prepare()
    userInterface.displayBoard(game.getCurrentBoard())
    
    //while(!game.isEnd){   
      val moveSelection = player1.selectMove(game)
      game.takeTurn(moveSelection, player1.getPlayerMark())
      val board = game.getCurrentBoard()
      
    //}
    userInterface.goodbye()  
  }
 
  
  
}