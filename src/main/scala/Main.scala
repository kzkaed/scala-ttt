import players._
import ai._
import users._
import base._

object Main { 
  def main(args: Array[String]): Unit = {
    val setup = new Setup()
    if (args.length > 0) {
      val players = setup.matchArgs(args(0))  
      val player1 = players.head.asInstanceOf[Player]
      val player2 = players.last.asInstanceOf[Player]
      new Runner(setup.game, setup.userInterface, player1, player2).run()
    }else {     
      new Runner(setup.game, setup.userInterface, setup.defaultPlayer1, setup.defaultPlayer2 ).run()
    }
      
  }
 
}