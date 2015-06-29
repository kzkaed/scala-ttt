package ai

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MinimaxSpec extends FunSpec {
  val ai = new Minimax

  it("should switch players") {
    val playerMark = "o"

    assert(ai.switchPlayerMark(playerMark) === "x")
  }

}