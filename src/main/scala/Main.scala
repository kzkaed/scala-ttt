import players._
import ai._
import ui._
import base._

object Main {
  def main(args: Array[String]): Unit = {
    println("start")
      
    val userInterface = new Terminal
    val board = Array[String]("1","2","3","4","5","6","7","8","9")
    val game = new Game(board)
    val engine = new Minimax
    var player1 = players.PlayerFactory.getPlayer("human", engine)
    var player2 = PlayerFactory.getPlayer("human", engine)
 
    
    if (args.length > 0) {
      if( args(0).contentEquals("HC") ) {
        args.foreach { arg => println(arg)}
        player1 = PlayerFactory.getPlayer("human", engine)
        player2 = PlayerFactory.getPlayer("computer", engine)
      }  
    }
    
    val runner = new base.Runner(game, userInterface, player1, player2)
   
    runner.run()
  }
}