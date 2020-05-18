package lab1


import contracts.LabContract
import exceptions.BreakLoop
import view.GridRender
import java.lang.NumberFormatException
import kotlin.math.pow

class Lab1(private val ctx : Lab1Context) : LabContract {

    override fun init() {
        println("Лабораторна робота №1 (введіть exit для виходу з лабораторної роботи)")
        while (true) {
            println("Введіть значення t: ")
            val input = readLine();

            try {
                when {
                    "exit" == input          -> throw BreakLoop();
                     input.isNullOrEmpty()   -> throw NumberFormatException()
                }

                ctx.t = input!!.toDouble()
                ctx.render.view(getGrid())


            } catch (e : NumberFormatException) {
                println("t має бути числом [${e.message}]")
                continue
            } catch (e : BreakLoop) {
                println("Закриваю першу лабораторну \n\n\n")
                break
            }
        }

    }

  private fun getGrid(): Array<DoubleArray> {

        //ToDO: Перевірити узгодженість

        val m : Int = (ctx.l / ctx.h).toInt()
        val n = (ctx.T / ctx.t).toInt()

        val grid = Array(m + 1) { DoubleArray(n + 1) { .0 } }

        /**
         * Початкові дані
         */
        for (i: Int in 0..n) {
            grid[0][i] = ctx.mu1(i * ctx.t)
            grid[m][i] = ctx.mu2(i * ctx.t)
        }

        /**
         * Крайові дані
         */
        for (i: Int in 0..m) grid[i][0] = ctx.phi(i * ctx.h)

        for(j in 0 until n) {
            for (i in 1 until m) {
                grid[i][j + 1] = grid[i][j] + ctx.t * ctx.k * (grid[i + 1][j] - 2 * grid[i][j] + grid[i - 1][j]) / ctx.h.pow(2) + ctx.t * ctx.func(i * ctx.h, j * ctx.t)
            }
        }

        return grid
    }

}