package base

import users._
import players._

class Runner(val game: GameRules, 
             val userInterface: UserInterface, 
             val player1: Player, 
             val player2: Player){
  
  def run(): Unit = {
    startGame()
    while (!game.isEnd) {
      play() 
    }
    endGame()
  }
  
  def startGame(): Unit = {
    userInterface.prepare()
    displayCurrentBoard()
  }
  
  def play(): Unit =  {
    makeMove(player1)
    if (!game.isEnd) {  
      makeMove(player2)  
    }
  }
 
  def makeMove(player: Player) = {
    game.takeTurn(player.selectMove(game), player.playerMark()) 
    displayCurrentBoard()
  }

  def displayCurrentBoard(): Unit = {
    userInterface.displayBoard(game.board)
  }
  
  def endGame(): Unit = {
    userInterface.displayGameResult(player1.playerMark, player2.playerMark, game: GameRules)
    userInterface.goodbye()
  }
 
}