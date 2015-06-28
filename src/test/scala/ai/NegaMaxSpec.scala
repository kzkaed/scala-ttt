package ai

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NegaMaxSpec extends FunSpec {
  val ai = new Negamax
  
  it("should switch players") {
    val player = "o"
    
    assert(ai.switchPlayer(player) === "x")   
  }
  
}