package player

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class ComputerSpec extends FunSpec {
  val ai = new Computer
  
  it("should switch players") {
    val player = "o"
    
    assert(ai.switchPlayer(player) === "x")   
  }
  
}