package base


class Runner(game: Game, 
             userInterface: ui.UserInterface, 
             player1: player.Player, 
             player2: player.Player){
  
  def run() : Unit = {
    while(!game.end){
      val currentMark = "x"
      val currentMove = "1"
      val currentBoard = game.board
      game.takeTurn(currentMark, currentMove, currentBoard)
      
    }
    
  }
}