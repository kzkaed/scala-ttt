package base

class Game(var board: Array[String]) extends GameRules {
  
   def takeTurn(moveSelection: String, playerMark: String): Array[String] = {
     board.update(getNumber(moveSelection), playerMark)
     board
   }
   
   def isEnd: Boolean = { 
     isWin || isDraw 
   }
    
   def isWin: Boolean = { 
     isWinDiagonal || isWinDown || isWinAcross
   }
 
   def isDraw: Boolean = { 
     boardSet.size == 2 && !isWin
   }
      
   def availableCells: List[String] = { 
     eliminateTakenCells.toList.sorted
   }
          
   def winnerMark: String = {
     if (numberOfXs > numberOfOs) Mark.x
     else Mark.o
   }
   
   def clearAt(cell: String): Unit = {
     board(cell.toInt - 1) = cell
   }
   
   def clearBoard(): Unit = {  
     board = ((1 to boardSize) map(_.toString)).toArray
   }
   
   def isWinAcross: Boolean = {    
     var result = false
     val rows = board.grouped(winSize).toList
     rows foreach { row => 
       if((row.distinct).size == 1){
         result = true
       }   
     }
     result
   }
   
   def isWinDown: Boolean = {
    
     (List(board(0), board(3),board(6)).distinct).size == 1 ||
     (List(board(1), board(4),board(7)).distinct).size == 1 ||
     (List(board(2), board(5),board(8)).distinct).size == 1
   }
   
   def isWinDiagonal: Boolean = {
    (List(board(0), board(4),board(8)).distinct).size == 1 ||
    (List(board(2), board(4),board(6)).distinct).size == 1
   }  
   
   private def getNumber (moveSelection: String): Int = {
     moveSelection.toInt - 1
   }
   
    private def numberOfXs: Int = {
     board.filter { cell => cell == Mark.x }.length
   }
   
   private def numberOfOs: Int = {
     board.filter { cell => cell == Mark.o }.length
   }
   
   private def eliminateTakenCells: Set[String] = {
     boardSet.&~(Set( Mark.x, Mark.o ))
   }
   
   private def boardSet: Set[String] = {
     board.toSet
   }
   
   def boardSize(): Int = {
     board.size
   }
   
   def winSize(): Int = {
     scala.math.sqrt(boardSize).toInt
   }
    
}