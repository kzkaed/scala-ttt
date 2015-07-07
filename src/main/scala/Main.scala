import players._
import ai._
import gui._
import base._

object Main {
  
  val userInterface = new TConsole
  val board = Array[String]("1","2","3","4","5","6","7","8","9")
  val game = new Game(board)
  val engine = new Negamax
  val xMark = "x"
  val oMark = "o"
  var player1 = PlayerFactory.getPlayer("human", xMark, engine, userInterface)
  var player2 = PlayerFactory.getPlayer("human", oMark, engine, userInterface)
  
  def main(args: Array[String]): Unit = {
    if (args.length > 0) {
      matchArgs(args(0))
    }
    new Runner(game, userInterface, player1, player2).run()
  }
  
  def matchArgs(arg: String): Unit = arg match {
    case "HC" =>
      println("Human Computer")
      player1 = PlayerFactory.getPlayer("human", xMark, engine, userInterface)
      player2 = PlayerFactory.getPlayer("computer", oMark, engine, userInterface)
    case "CH" =>
      println("Computer Human")
      player1 = PlayerFactory.getPlayer("computer", xMark, engine, userInterface)
      player2 = PlayerFactory.getPlayer("human", oMark, engine, userInterface)
    case "CC" =>
      println("Computer Computer")
      player1 = PlayerFactory.getPlayer("computer", xMark, engine, userInterface)
      player2 = PlayerFactory.getPlayer("computer", oMark, engine, userInterface)
    case _ => 
      println("Human Human")
      player1 = PlayerFactory.getPlayer("human", xMark, engine, userInterface)
      player2 = PlayerFactory.getPlayer("human", oMark, engine, userInterface)
   }
}