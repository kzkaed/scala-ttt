package ai

import base.Game
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NegamaxSpec extends FunSpec {
  val aiEngine = new Negamax
    
  it ("Turn 1: should return best move") {
    val playerMark = "x"
    val board = Array[String]("1","2","3",
                              "4","5","6",
                              "7","8","9")
    val game = new Game(board)
    assert(aiEngine.getBestMove(game, playerMark) == "1")
  }
  
   it ("Turn 2: plays next best move") {
    val playerMark = "x"
    val board = Array[String]("x","o","3",
                              "4","5","6",
                              "7","8","9")
    val game = new Game(board)
    assert(aiEngine.getBestMove(game, playerMark) == "5")
  }
   
   it ("Turn 3: plays next best move") {
    val playerMark = "x"
    val board = Array[String]("x","o","3",
                              "4","x","6",
                              "7","8","o")
    val game = new Game(board)
    assert(aiEngine.getBestMove(game, playerMark) == "4")
  }
   
   it ("Turn 4: plays next best move") {
    val playerMark = "x"
    val board = Array[String]("x","o","3",
                              "x","x","o",
                              "7","8","o")
    val game = new Game(board)
    assert(aiEngine.getBestMove(game, playerMark) == "7")
  }
}