package game

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NegaMaxSuite extends FunSuite {
  val game = new Game
  
  test("it has a board") {
  val aBoard = List('1','2','3','4','5','6','7','8','9')
  assert(game.board == aBoard) 
  }
  
  test("can process a turn with an x"){
    val board = List('1','2','3','4','5','6','7','8','9')
    val move = 1.toChar
    val mark = 'x'
    
    assert(game.takeTurn(mark, move, board) == List('x','2','3','4','5','6','7','8','9') )
  }
}