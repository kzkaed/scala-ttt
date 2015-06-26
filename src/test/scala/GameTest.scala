package main.scala

import org.scalatest._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner



@RunWith(classOf[JUnitRunner])
class GameSuite extends FunSuite {
  
  test("changes to lower case") {
    val gameChanger = new Game
    assert(gameChanger.change2("HELP") === "help")
  }

}


