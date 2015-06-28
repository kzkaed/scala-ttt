package player

class Computer extends Player {
  
  def switchPlayer(player: String): String = {
    if (player == "x") "o" else "x"  
  }
  
}