package ai

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NegaMaxSuite extends FunSuite {
  val ai = new NegaMax
  
  test("sets next player") {
    val player = "o"
    
  assert(ai.nextPlayer(player) === "o")
    
    
    
  }
  
}