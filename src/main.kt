import exceptions.BreakLoop
import exceptions.InvalidLabNumber
import lab1.Lab1
import lab1.Lab1Context
import lab2.Lab2
import lab2.Lab2Context
import lab3.Lab3
import lab3.Lab3Context
import java.lang.NumberFormatException

fun main() {

var userInput : String?

    while (true) {
        println("Введіть номер лабораторної роботи(1-3): (для виходу з програми введіть exit)")

        try {
            userInput = readLine()
            when {
                userInput.isNullOrEmpty() -> throw InvalidLabNumber("Не правильно введено номер лабораторної")
                "exit" == userInput.toLowerCase() -> throw BreakLoop()
            }

            when(userInput!!.toInt()) {
                1 -> {
                    val context = Lab1Context()
                    val lab = Lab1(context)
                    lab.init()
                }

                2 -> {
                    val context = Lab2Context()
                    val lab = Lab2(context)
                    lab.init()
                }

                3 -> {
                    val context = Lab3Context()
                    val lab = Lab3(context)
                    lab.init()
                }

                else -> {
                    throw InvalidLabNumber("Неправильно введено но номер лабораторної")
                }
            }

        } catch (e : InvalidLabNumber) {
            println(e.message)
            continue
        } catch (e : NumberFormatException) {
            println("Введіть ціле число в діапацоні від 1 до 3 [${e.message}]")
            continue;
        }  catch (e : BreakLoop) {
            break
        }

    }


}