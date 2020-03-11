
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin


fun main() {

    val lab1 = Lab1(5, 1,1,0.1)

    lab1.phi = {
        10 * cos((3.14 / 2) * it)
    }
    lab1.mu1 = {
        10 * exp(it)
    }
    lab1.mu2 = {
        sin(it)
    }
    lab1.func = { x, _ ->
        2 * sin(2 * x) * sin(x)
    }

    lab1.getGrid(0.5)

}

