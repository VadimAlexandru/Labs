
import exceptions.ConsistencyException
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin

fun main()  {
    val lab1 = Lab1(5, 1,1,0.1)

    lab1
        .phi { 10 * cos((PI/ 2) * it) }
        .mu1 { 10 * exp(it) }
        .mu2 { sin(it) }
        .func { x, _ -> 2 * sin(2 * x) * sin(x) }

    try {
       val grid =  lab1.getGrid(0.5)

        /**
         * grid render view
         */
        grid.map { l -> l.map { print("${(it.toFloat())} ") }; println() }

    } catch (e: ConsistencyException) {
        println(e.message)
    }

}

