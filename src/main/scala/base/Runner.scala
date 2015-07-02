package base

import gui._
import players._
import scala.util.control.Breaks._

class Runner(val game: GameRules, 
             val userInterface: UserInterface, 
             val player1: Player, 
             val player2: Player){
  
  def run() : Unit = {
    startGame
    while (!game.isEnd) play 
    endGame
  }
  
  def startGame(): Unit = {
    userInterface.prepare()
    userInterface.displayBoard(game.getCurrentBoard()) 
  }
 
  def play(): Unit =  {
    firstPlay
    if (!game.isWin && !game.isDraw()) secondPlay  
  }
 
  def firstPlay(): Unit = {
    game.takeTurn(player1.selectMove(game), player1.getPlayerMark())
    displayCurrentBoard
  }
    
  def secondPlay(): Unit = {
    game.takeTurn(player2.selectMove(game), player2.getPlayerMark())
    displayCurrentBoard   
  }
  
  def displayCurrentBoard(): Unit = {
    userInterface.displayBoard(game.getCurrentBoard())
  }
 
  def endGame(): Unit = {
    userInterface.goodbye()
  }
    
  
  
}