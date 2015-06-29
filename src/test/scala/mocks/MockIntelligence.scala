package mocks

import ai.Intelligence
import base.Game

class MockIntelligence extends Intelligence {
  
  def getBestMove(game: Game): String = {
    "9"
  }
    
  
}