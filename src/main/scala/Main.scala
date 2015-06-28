
object Main {
  def main(args: Array[String]): Unit = {
    println("start")
   
    val userInterface = new ui.Console
    val board = List[String]("1","2","3","4","5","6","7","8","9")
    val game = new base.Game(board)
    val aIEngine = new player.Computer
    
    val player1 = new player.Human
    val player2 = new player.Human
    
    val runner = new base.Runner(game, userInterface, player1, player2)
   
    runner.run()
  }
}