package base


class Runner(game: Game, 
             userInterface: ui.UserInterface, 
             player1: players.Player, 
             player2: players.Player){
  
  def run() : Unit = {
    while(!game.end){
      val currentMark = "x"
      val currentMove = "1"
      val currentBoard = game.board
      game.takeTurn(currentMark, currentMove)
    }
    userInterface.goodbye()  
  }
  
  
}