import players._
import ai._
import gui._  
import base._

class Setup {
  val userInterface = new TConsole
  val gameboard = new GameBoard(3)
  val game = new Game(gameboard.board)
  val engine = new Negamax
  val defaultPlayer1 = new Human(Mark.x, userInterface) 
  val defaultPlayer2 = new Human(Mark.o, userInterface) 
  
   def matchArgs(arg: String): List[Any] = arg match {
    case "HC" =>
      new Human(Mark.x, userInterface) :: new Computer(Mark.o, engine) :: List()
    case "CH" =>
      new Computer(Mark.x, engine):: new Human(Mark.o, userInterface) :: List()
    case "CC" =>
      new Computer(Mark.x, engine):: new Computer(Mark.o, engine) :: List()
    case _ => 
      defaultPlayer1 :: defaultPlayer2 :: List()
   }
  
}