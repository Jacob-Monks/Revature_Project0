package ProjectFiles

import sun.jvm.hotspot.HelloWorld.e

import java.lang.Exception
import scala.sys.exit
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement
import java.sql.ResultSet
import java.util.InputMismatchException
import scala.util.control.Exception
import scala.io.StdIn._

object Project0 {
  //This will be a diet and fitness tracking application.
  //When the application begins, the user will say what they wish to do given several options.
  var goal: Int = 0
  def UserPass(): Int = {
    print("Username: ")
    val user = readLine()
    print("Password: ")
    val pass = readLine()
    if(user == "Jacob" & pass == "Monks") {
      println("Hello!")
      val check = 1
      return check
    }
    else {
      println("Username or Password was incorrect.")
      val check = 0
      return check
    }
  }
  def Select(): String = {
    println("What would you like to do?\nPlease type the option number.")
    println("1. Update Diet Record.")
    println("2. Update Exercise Record.")
    println("3. Update Weight Record.")
    println("4. Set Weight Goal.")
    println("5. View Diet Record.")
    println("6. View Exercise Record.")
    println("7. View Weight Record.")
    println("8. Exit")
    import scala.io.StdIn._
    val num = readLine()
    return num
  }
  def main(args: Array[String]): Unit = {
    val check = UserPass()
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
        val protein = readLine().toInt
        //insert all of these values into the table
/*
        try {
          val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
          val statement = connection.createStatement()
          val insert = statement.executeUpdate("INSERT INTO")

        }
        catch {
          case e:InputMismatchException => println("Please insert the correct information.")
        }

 */
      }
      else if(num == "2") {
        println("Please put in some details:")
        print("Date (YYYY-MM-DD): ")
        val date = readLine()
        print("Activity: ")
        val activity = readLine()
        print("Duration (in minutes): ")
        val minutes = readLine()
        //insert these values into the table
      }
      else if(num == "3") {
        println("Please put in some details:")
        print("Date (YYYY-MM-DD): ")
        val date = readLine()
        print("Weight: ")
        val weight = readLine()
        //insert these values into the table
      }
      else if(num == "4") {
        println("What is your goal?")
        print("Pounds: ")
        goal = readLine().toInt
        //read the last input in weight record and say how close they are
        println("We'll make sure you get there.\n")
      }
      else if(num == "5") {
        //display the table
      }
      else if(num == "6") {
        //display the table
      }
      else if(num == "7") {
        //display the table
      }
      else if(num == "8") {
        exit
      }
      else {
        println("Please make a valid selection.\n")
      }
    }
  }
}
