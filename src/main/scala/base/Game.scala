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
   
   def isWinAcross: Boolean = {
     isDistinctSizeOne(rows(board.toList)).contains(true)
   }
   
   def isWinDown: Boolean = {   
    isDistinctSizeOne(columns(board.toList)).contains(true)
   }
   
   def isWinDiagonal: Boolean = {
    isDistinctSizeOne(diagonals(board.toList)).contains(true)
   } 
   
   def isDistinctSizeOne(groups: List[List[String]]): List[Boolean] = {
     val result = groups flatMap { group =>
       if ((group.distinct).size == 1) Seq(true)
       else Seq(false)}
     result.toList
   }
   
   def rows(cells: List[String]): List[List[String]] = {
     cells.grouped(winSize(cells)).toList
   }
    
   def columns(cells: List[String]): List[List[String]] = {
     cells.grouped(winSize(cells)).toList.transpose
   }
    
   def diagonals(cells: List[String]) = {
    List( diagnol(cells.grouped(winSize(cells)).toList) , diagnol(cells.grouped(winSize(cells)).toList.reverse))
   }
   
   @annotation.tailrec
   final def diagnol(groupedCells: List[List[String]], result: List[String] = Nil): List[String] = {
      if (groupedCells.isEmpty) result
      else 
      diagnol(getTailCellsOfGroup (groupedCells.tail), appendDiagnolCell(groupedCells, result))
    }
   
   private def getTailCellsOfGroup (tailCells: List[List[String]]): List[List[String]] = {
     tailCells map(_.tail)
   }
   
   private def appendDiagnolCell(groupedCells: List[List[String]], result: List[String]): List[String] = {
     result :+ groupedCells.head.head
   }
   
   def winSize(b: List[String]): Int = {
     scala.math.sqrt(b.size).toInt
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
    
}