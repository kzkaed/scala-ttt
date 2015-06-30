import players._
import ai._
import ui._
import base._

object Main {
  def main(args: Array[String]): Unit = {
      
    val userInterface = new MTerminal
    val board = Array[String]("1","2","3","4","5","6","7","8","9")
    val game = new Game(board)
    val engine = new Minimax
    val xMark = "x"
    val oMark = "o"
    var player1 = players.PlayerFactory.getPlayer("human", xMark, engine, userInterface)
    var player2 = PlayerFactory.getPlayer("human", oMark, engine, userInterface)
 
    if (args.length > 0) {
      if( args(0).contentEquals("HC") ) {
        player1 = PlayerFactory.getPlayer("human", xMark, engine, userInterface)
        player2 = PlayerFactory.getPlayer("computer",oMark, engine,userInterface)
      }  
    }
    
    val runner = new base.Runner(game, userInterface, player1, player2)
   
    runner.run()
  }
}