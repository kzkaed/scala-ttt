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
      var moveSelection = player1.selectMove(game)
      game.takeTurn(moveSelection, player1.getPlayerMark())
      var board = game.getCurrentBoard()
      userInterface.displayBoard(board)
      
      moveSelection = player2.selectMove(game)
      game.takeTurn(moveSelection, player2.getPlayerMark())
      board = game.getCurrentBoard()
      userInterface.displayBoard(board)
      
      
      
    //}
    userInterface.goodbye()  
  }
 
  
  
}