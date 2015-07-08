package gui

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CommunicationSpec extends FunSpec{
 
  describe("messages"){
    it("welcome"){  
      assert(Communication.messages('welcome) == "Welcome to Scala Tic Tac Toe") 
    }
    it("enter"){  
      assert(Communication.messages('enter) == "Enter cell number: ") 
    }
    it("incorrect"){  
      assert(Communication.messages('incorrect) == "Incorrect input, try again.") 
    }
    it("win"){  
      assert(Communication.messages('win) == " Wins!") 
    }
    it("draw"){  
      assert(Communication.messages('draw) == "It is a draw.") 
    }
    it("goodbye"){  
      assert(Communication.messages('goodbye) == "Goodbye") 
    }
  }
}