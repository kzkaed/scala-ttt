package ai

class NegaMax {
  
  def nextPlayer(player: Char): Char = {
    if (player == 'x') 'o' else 'x'  
  }
  
}