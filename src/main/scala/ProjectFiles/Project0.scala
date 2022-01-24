package ProjectFiles

object Project0 {
  //This will be a diet and fitness tracking application.
  //When the application begins, the user will say what they wish to do given several options.
  def Select(): String = {
    println("What would you like to do?\nPlease type the option number.")
    println("1. Update Diet Record.")
    println("2. Update Exercise Record.")
    println("3. Update Weight Record.")
    println("4. Set Weight Goal.")
    println("5. View Diet Record.")
    println("6. View Exercise Record.")
    println("7. View Weight Record.")
    import scala.io.StdIn._
    val num = readLine()
    return num
  }
  def main(args: Array[String]): Unit = {
    import scala.io.StdIn._
    val check = 1
    println("Hello!")
    while(check == 1) {
      val num = Select()
      if(num == "1") {
        println("Please put in some details:")
        print("Date (YYYY-MM-DD): ")
        val date = readLine()
        print("Item: ")
        val item = readLine()
        print("Calories: ")
        val calories = readLine()
        print("Total Fat (in g): ")
        val fat = readLine()
        print("Cholesterol (in mg): ")
        val cholesterol = readLine()
        print("Carbohydrates (in g): ")
        val carbs = readLine()
        print("Sugars (in g): ")
        val sugars = readLine()
        print("Protein (in g): ")
        readLine()
      }
      else if(num == "2") {
        println("Please put in some details:")
        print("Date (YYYY-MM-DD): ")
        val date = readLine()
        print("Activity: ")
        val activity = readLine()
        print("Duration (in minutes): ")
        val minutes = readLine()
      }
      else if(num == "3") {

      }
      else if(num == "4") {

      }
      else if(num == "5") {

      }
      else if(num == "6") {

      }
      else if(num == "7") {

      }
      else {
        println("Please make a valid selection.")
      }
    }
  }
}
