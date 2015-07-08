package ai
import base.GameRules

class Negamax extends Intelligence {
  var bestMoveState = ""
  
  def getBestMove(game: GameRules, playerMark: String): String = {
    val depth = 0
    calculate(game, playerMark, depth)
    bestMoveState
  }
  
  def calculate(game: GameRules, playerMark: String, depth: Int): Int = {
    if (game.isEnd) getValue(game, playerMark, depth) 
    else{
      var bestValue = -1000000000
      var nextPlayer = switch(playerMark)
      var value = 0
      
      game.availableCells.foreach { moveSelection => 
        game.takeTurn(moveSelection, playerMark)
        value = -calculate(game, nextPlayer, depth + 1)
        game.clearAt(moveSelection)
        if (value > bestValue) {
          bestValue = value
          if (depth == 0) bestMoveState = moveSelection
        }
      }
      bestValue
    }
  }
  
  private def switch(playerMark: String): String = {
    if (playerMark.contentEquals("x")) "o" else "x"
  }

  private def getValue(game: GameRules, playerMark: String, depth: Int): Int = {
    if (game.isDraw) 0
    else (-1 * depth * integerize(game, playerMark))   
  }
  
  private def integerize(game: GameRules, playerMark: String): Int = {
    if (game.winnerMark == playerMark) -1
    else 1
  } 
}