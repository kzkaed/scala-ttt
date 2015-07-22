package users

import mocks.MockIO
import mocks.MockGame
import base._
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ValidatorSpec extends FunSpec{
  val validator = new Validator
 
 it("validates input available"){
    val cell = "1"
    val availableCells = List("1","2")
    assert(validator.validate(cell, availableCells) == "1")
  }
  
  it("validates input not available"){
    val cell = "3"
    val availableCells = List("1","2")
    assert(validator.validate(cell, availableCells) == "invalid")
  }
  
  
}