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
        //===============================================updating the dietrecord=======================================
        try {
          println("Would you like to add or delete data?")
          println("1. Add")
          println("2. Delete")
          val ad = readLine()
          if(ad == "1") {
            //============================================adding a record to dietrecord================================
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
            val protein = readLine()
            print("Is all information entered correctly? Y/N\n")
            val yes = readLine()
            if(yes == "Y" || yes == "y") {
              //=================================insert all of these values into the table=============================
              val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
              val statement = connection.createStatement()
              val insert = statement.executeUpdate(
                s"""
                   |INSERT INTO dietrecord (Day, Item, Calories, TotalFat, Cholesterol, Carbohydrates, Sugar, Protein)
                   |VALUES ('$date', "$item", $calories, $fat, $cholesterol, $carbs, $sugars, $protein)
                   |""".stripMargin)
              println("Done!\n")
            }
            else {
              println("Returning to main menu\n")
            }
          }
          else if(ad == "2") {
            //===================================deleting a record from dietrecord=====================================
            println("What date is the data under?")
            val date = readLine()
            println("What is the name of the item?")
            val item = readLine()
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
            val statement = connection.createStatement()
            val delete = statement.executeUpdate(
              s"""
                 |DELETE FROM dietrecord WHERE Day = '$date' AND item = "$item"
                 |""".stripMargin)
            println("Done!\n")
          }
          else {
            println("Selection was invalid, returning to main menu.\n")
          }
        }
        catch {
          case e:InputMismatchException => println("Please insert the correct information.\n")
        }
      }
      else if(num == "2") {
        //======================================updating the exerciserecord============================================
        try {
          println("Would you like to add or delete data?")
          println("1. Add")
          println("2. Delete")
          val ad = readLine()
          if(ad == "1") {
            //=======================================adding a record to exerciserecord=================================
            println("Please put in some details:")
            print("Date (YYYY-MM-DD): ")
            val date = readLine()
            print("Activity: ")
            val activity = readLine()
            print("Duration (in minutes): ")
            val minutes = readLine()
            print("Is all information entered correctly? Y/N\n")
            val yes = readLine()
            if (yes == "y" || yes == "Y") {
              //===============================insert these values into the table======================================
              val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
              val statement = connection.createStatement()
              val insert = statement.executeUpdate(
                s"""
                   |INSERT INTO exerciserecord (Day, Activity, Minutes)
                   |VALUES ('$date', "$activity", $minutes)
                   |""".stripMargin)
              println("Done!\n")
            }
            else {
              println("Returning to main menu\n")
            }
          }
          else if (ad == "2") {
            //========================================deleting a record from exerciserecord============================
            println("What date is the data under?")
            val date = readLine()
            println("What is the name of the activity?")
            val activity = readLine()
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
            val statement = connection.createStatement()
            val delete = statement.executeUpdate(
              s"""
                 |DELETE FROM exerciserecord WHERE Day = '$date' AND Activity = "$activity"
                 |""".stripMargin)
            println("Done!\n")
          }
          else {
            println("Selection was invalid, returning to main menu.\n")
          }
        }
        catch {
          case e:InputMismatchException => println("Please insert the correct information.\n")
        }
      }
        //==========================================updating the weightrecord==========================================
      else if(num == "3") {
        try {
          println("Would you like to add or delete data?")
          println("1. Add")
          println("2. Delete")
          val ad = readLine()
          if (ad == "1") {
            //========================================adding a record to weightrecord==================================
            println("Please put in some details:")
            print("Date (YYYY-MM-DD): ")
            val date = readLine()
            print("Weight: ")
            val weight = readLine()
            print("Is all information entered correctly? Y/N\n")
            val yes = readLine()
            if (yes == "Y" || yes == "y") {
              //===================================insert these values into the table==================================
              val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
              val statement = connection.createStatement()
              val insert = statement.executeUpdate(
                s"""
                   |INSERT INTO weightrecord (Day, Pounds)
                   |VALUES ('$date', $weight)
                   |""".stripMargin)
              println("Done!\n")
            }
            else {
              println("Returning to main menu\n")
            }
          }
          else if (ad == "2") {
            //====================================deleting a record from weightrecord==================================
            println("What date is the data under?")
            val date = readLine()
            println("What is the weight?")
            val pounds = readLine()
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
            val statement = connection.createStatement()
            val delete = statement.executeUpdate(
              s"""
                 |DELETE FROM weightrecord WHERE Day = '$date' AND Pounds = $pounds
                 |""".stripMargin)
            println("Done!\n")
          }
          else {
            println("Selection was invalid, returning to main menu.\n")
          }
        }
        catch {
          case e:InputMismatchException => println("Please insert the correct information.\n")
        }
      }
        //=========================================setting new weight goal=============================================
      else if(num == "4") {
        println("What is your goal?")
        print("Pounds: ")
        goal = readLine().toInt
        println("We'll make sure you get there.\n")
      }
        //=======================================viewing from the dietrecord===========================================
      else if(num == "5") {
        //display the table
          val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
          val statement = connection.createStatement()
          val result = statement.executeQuery(
            """
              |SELECT Day, SUM(Calories), SUM(TotalFat), SUM(Cholesterol),
              |SUM(Carbohydrates), SUM(Sugar), SUM(Protein) FROM dietrecord GROUP BY Day
              |""".stripMargin)
          while(result.next()) {
            System.out.print(result.getString("Day"))
            print("\t\t")
            System.out.print(result.getString("SUM(Calories)"))
            print("\t\t")
            System.out.print(result.getString("SUM(TotalFat)"))
            print("\t\t")
            System.out.print(result.getString("SUM(Cholesterol)"))
            print("\t\t")
            System.out.print(result.getString("SUM(Carbohydrates)"))
            print("\t\t")
            System.out.print(result.getString("SUM(Sugar)"))
            print("\t\t")
            System.out.println(result.getString("SUM(Protein)"))
          }
          println("Done!\n")
      }
        //==============================================view the exerciserecord========================================
      else if(num == "6") {
        //display the table
         val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
         val statement = connection.createStatement()
         val result = statement.executeQuery("SELECT * FROM exerciserecord")
         while(result.next()) {
           System.out.print(result.getString("Day"))
           print("  ")
           System.out.print(result.getString("Minutes"))
           print("\t")
           System.out.println(result.getString("Activity"))
         }
        println("Done!\n")
      }
        //============================================view the weightrecord============================================
      else if(num == "7") {
        //display the table
        val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project0", "root", "CW987rq2#")
        val statement = connection.createStatement()
        val result = statement.executeQuery("SELECT * FROM weightrecord")
        while(result.next()) {
          System.out.print(result.getString("Day"))
          print("  ")
          System.out.println(result.getString("Pounds"))
        }
        println
        val result2 = statement.executeQuery("SELECT Pounds FROM weightrecord ORDER BY Day DESC LIMIT 1")
        var pounds = ""
        while(result2.next()) {
          pounds = result2.getString("Pounds")
        }
        val diff = goal - pounds.toInt
        println(s"You are only $diff pounds away from your goal!\n")
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
