package mocks

import ai.Intelligence
import base.GameRules

class MockIntelligence extends Intelligence {
  
  def getBestMove(game: GameRules, playerMark: String): String = {
    game.availableCells().head
  }
    
  
}