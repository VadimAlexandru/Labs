package lab3

import contracts.LabContract
import exceptions.BreakLoop
import java.lang.NumberFormatException

class Lab3(private val ctx : Lab3Context) : LabContract {

    private var iterateCount = 0

    override fun init() {
        println("Лабораторна робота №3 (введіть exit для виходу з лабораторної роботи)")
        while (true) {
            println("Введіть значення epsilon: ")
            val input = readLine()

            try {
                when {
                    "exit" == input          -> throw BreakLoop();
                     input.isNullOrEmpty()   -> throw NumberFormatException()
                }
                ctx.epsilon = input!!.toDouble()


                val grid = getGrid()
                println("iterate count $iterateCount")
                ctx.render.view(grid)

            } catch (e : NumberFormatException) {
                println("t має бути числом [${e.message}]")
                continue
            } catch (e : BreakLoop) {
                println("Закриваю першу лабораторну \n\n\n")
                break
            }
        }

    }


    private fun getGrid() : Array<DoubleArray> {

        iterateCount = 0

        val m = (ctx.l / ctx.h).toInt()
        val n = (ctx.k / ctx.g).toInt()
        val grid = Array(m + 1) { DoubleArray(n + 1) { .0 } }

        for (i in 0 until m) {
            grid[i][0] = ctx.phi1(i * ctx.h)
            grid[i][n - 1] = ctx.phi2(i * ctx.h)
        }

        for (i in 0 until n) {
            grid[0][i] = ctx.psy1(i * ctx.g)
            grid[m][i] = ctx.psy2(i * ctx.g)
        }

        return simpleIterationRecursive(m,n, grid)
    }

    private fun simpleIterationRecursive(m : Int, n : Int, grid : Array<DoubleArray>) : Array<DoubleArray> {

        iterateCount ++
        var max = -.1

        for (i in 1 until m) {
            for (j in 1 until n) {
                val nextValue = ctx.g * (grid[i - 1][j] + grid[i + 1][j]) + ctx.h * (grid[i][j - 1] + grid[i][j + 1]) - ctx.g * ctx.h * ctx.func(i * ctx.h, j * ctx.g)
                max = maxOf(max, kotlin.math.abs(grid[i][j] - nextValue))
                grid[i][j] = nextValue
            }
        }

        return if(max > ctx.epsilon) {
            simpleIterationRecursive(m,n,grid)
        } else {
            grid
        }

    }







}