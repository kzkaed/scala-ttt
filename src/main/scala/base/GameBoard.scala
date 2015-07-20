package base


class GameBoard (val size: Int) {
  var board = Array[String]("1","2","3","4","5","6","7","8","9")

    def clearBoard(): Unit = {  
     board = ((1 to 9) map(_.toString)).toArray
   }
  
  def isAcross: Boolean = {
     (List(board(0), board(1),board(2)).distinct).size == 1 ||
     (List(board(3), board(4),board(5)).distinct).size == 1 || 
     (List(board(6), board(7),board(8)).distinct).size == 1
   }
  
   def isDown: Boolean = {
     (List(board(0), board(3),board(6)).distinct).size == 1 ||
     (List(board(1), board(4),board(7)).distinct).size == 1 ||
     (List(board(2), board(5),board(8)).distinct).size == 1
   }
        
    def isDiagonal: Boolean = {
     (List(board(0), board(4),board(8)).distinct).size == 1 ||
     (List(board(2), board(4),board(6)).distinct).size == 1
   } 
}