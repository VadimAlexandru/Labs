
import exceptions.ConsistencyException
import java.lang.NumberFormatException


fun main()  {

    val messages : Map<String, String> = mapOf(
        "exit_info" to "Для виходу введіть exit",
        "error_input" to "t має бути числом",
        "input_t" to "Введіть значення t: ",
        "exit" to "Ok"
    )

    val lab1 = Lab1(4, 1,1,0.1)
    lab1.phi { 5 * (1 - it)  }
        .mu1 { 5 * kotlin.math.exp(-it) }
        .mu2 { it }
        .func { x,t -> t * x }

    println(messages["exit_info"])

    var input : String?

    while(true) {
        print(messages["input_t"])
        input = readLine()

        if(input.isNullOrEmpty()) {
            println(messages["error_input"])
            continue
        }

        if(input.toLowerCase() == "exit") {
            println(messages["exit"])
            break
        }

        try {
            val t = input.toDouble()
            val grid = lab1.getGrid(t)

            /**
             * grid render view
             */
            grid.map { l -> l.map { print("${(it.toFloat())} ") }; println() }

        } catch (e: NumberFormatException) {
            println("${messages["error_input"]} [${e.message}]")
            continue
        } catch (e: ConsistencyException) {
            println(e.message)
            continue
        }

    }
}

