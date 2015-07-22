package users

class Validator {
      
  def validate(cell: String, availableCells: List[String]):String = {
    if(isValid(cell,availableCells)) cell
    else "invalid"  
  }
  
  private def isValid(cell: String, availableCells: List[String]): Boolean = {
    availableCells.contains(cell)
  }
  
}