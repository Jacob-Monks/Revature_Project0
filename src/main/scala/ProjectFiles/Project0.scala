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
  //When the application begins, the user will enter their name and password.
  //If they are valid, the application will ask what they wish to do given several options.
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
        try {
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
          val protein = readInt()
          print("Is all information entered correctly? Y/N\n")
          val yes = readLine()
          if(yes == "Y") {         //insert all of these values into the table
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
            val statement = connection.createStatement()
            val insert = statement.executeUpdate(
              s"""
                 |INSERT INTO dietrecord (Day, Item, Calories, TotalFat, Cholesterol, Carbohydrates, Sugars, Protein)
                 |VALUES ($date, $item, $calories, $fat, $cholesterol, $carbs, $sugars, $protein)
                 |""".stripMargin)
            println("Done!\n")
          }
          else {
            println("Returning to main menu\n")
          }
        }
        catch {
          case e:InputMismatchException => println("Please insert the correct information.\n")
        }

      }
      else if(num == "2") {
        try {
          println("Please put in some details:")
          print("Date (YYYY-MM-DD): ")
          val date = readLine()
          print("Activity: ")
          val activity = readLine()
          print("Duration (in minutes): ")
          val minutes = readLine()
          print("Is all information entered correctly? Y/N\n")
          val yes = readLine()
          if (yes == "y") {        //insert these values into the table
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
            val statement = connection.createStatement()
            val insert = statement.executeUpdate(
              s"""
                |INSERT INTO exerciserecord (Day, Activity, Minutes)
                |VALUES ($date, $activity, $minutes)
                |""".stripMargin)
            println("Done!\n")
          }
          else {
            println("Returning to main menu\n")
          }
        }
        catch {
          case e:InputMismatchException => println("Please insert the correct information.\n")
        }
      }
      else if(num == "3") {
        try {
          println("Please put in some details:")
          print("Date (YYYY-MM-DD): ")
          val date = readLine()
          print("Weight: ")
          val weight = readLine()
          print("Is all information entered correctly? Y/N\n")
          val yes = readLine()
          if (yes == "Y") {        //insert these values into the table
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
            val statement = connection.createStatement()
            val insert = statement.executeUpdate(
              s"""
                 |INSERT INTO weightrecord (Day, Pounds)
                 |VALUES ($date, $weight)
                 |""".stripMargin)
            println("Done!\n")
          }
          else {
            println("Returning to main menu\n")
          }
        }
        catch {
          case e:InputMismatchException => println("Please insert the correct information.\n")
        }
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
        println("What would you like to see?")
        println("1. Calories per day.")
        println("2. Total Fat per day.")
        println("3. Cholesterol per day.")
        println("4. Carbohydrates per day.")
        println("5. Sugar per day.")
        println("6. Protein per day.")
        val sel = readLine()
        if(sel == "1") {
          val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
          val statement = connection.createStatement()
          val result = statement.executeQuery("SELECT Day, SUM(Calories) FROM dietrecord GROUP BY Day")
          while(result.next()) {
            System.out.println(result.getString("SUM(Calories)"))
          }
        }
        else if(sel == "2") {
          val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
          val statement = connection.createStatement()
          val result = statement.executeQuery("SELECT Day, SUM(TotalFat) FROM dietrecord GROUP BY Day")
          while(result.next()) {
            System.out.println(result.getString("SUM(TotalFat)"))
          }
        }
        else if(sel == "3") {
          val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
          val statement = connection.createStatement()
          val result = statement.executeQuery("SELECT Day, SUM(Cholesterol) FROM dietrecord GROUP BY Day")
          while(result.next()) {
            System.out.println(result.getString("SUM(Cholesterol)"))
          }
        }
        else if(sel == "4") {
          val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
          val statement = connection.createStatement()
          val result = statement.executeQuery("SELECT Day, SUM(Carbohydrates) FROM dietrecord GROUP BY Day")
          while(result.next()) {
            System.out.println(result.getString("SUM(Carbohydrates)"))
          }
        }
        else if(sel == "5") {
          val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
          val statement = connection.createStatement()
          val result = statement.executeQuery("SELECT Day, SUM(Sugars) FROM dietrecord GROUP BY Day")
          while(result.next()) {
            System.out.println(result.getString("SUM(Sugars)"))
          }
        }
        else if(sel == "6") {
          val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
          val statement = connection.createStatement()
          val result = statement.executeQuery("SELECT Day, SUM(Protein) FROM dietrecord GROUP BY Day")
          while(result.next()) {
            System.out.println(result.getString("SUM(Protein)"))
          }
        }
        else {
          println("Selection was invalid, returning to main menu.\n")
        }
      }
      else if(num == "6") {
        //display the table
         val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
         val statement = connection.createStatement()
         val result = statement.executeQuery("SELECT * FROM exerciserecord")
         while(result.next()) {
           System.out.println(result.getString(""))
         }
      }
      else if(num == "7") {
        //display the table
        val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
        val statement = connection.createStatement()
        val result = statement.executeQuery("SELECT * FROM weightrecord")
        while(result.next()) {
          System.out.println(result.getString(""))
        }
        val result2 = statement.executeQuery("SELECT Pounds FROM weightrecord ORDER BY Day DESC LIMIT 1")
        val diff = goal - result2
        println(s"You are only $diff pounds away from your goal!")
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
