package ProjectFiles

object Project0 {
  //This will be a diet and fitness tracking application.
  //When the application begins, the user will say what they wish to do given several options.
  def Open(): Unit = {
    println("What would you like to do?\nPlease type the option number.")
    println("1. Update Diet Record.")
    println("2. Update Exercise Record.")
    println("3. Update Weight Record.")
    println("4. Set Weight Goal.")
    println("5. View Diet Record.")
    println("6. View Exercise Record.")
    println("7. View Weight Record.")
  }
  def Select(): String = {
    import scala.io.StdIn._
    val num = readLine()
    return num
  }
  def main(args: Array[String]): Unit = {
    val check = 1
    println("Hello!")
    while(check == 1) {
      Open()
      val num = Select()
      if(num == "1") {
        println("You selected 1")
      }
      else if(num == "2") {
        println("You selected 2")
      }
      else if(num == "3") {
        println("You selected 3")
      }
      else if(num == "4") {
        println("You selected 4")
      }
      else if(num == "5") {
        println("You selected 5")
      }
      else if(num == "6") {
        println("You selected 6")
      }
      else if(num == "7") {
        println("You selected 7")
      }
      else {
        println("Please make a valid selection.")
      }
    }
  }
}
