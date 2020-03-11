import kotlin.math.pow

class Lab1(
    private val k : Int,
    private val l : Int,
    private val T : Int, // нахера ця змінна
    private val h : Double
) {

    var phi: (x: Double) -> Double = { x -> x }
    var mu1: (t: Double) -> Double = { t -> t }
    var mu2: (t: Double) -> Double = { t -> t }
    var func: (x: Double, t: Double) -> Double = { x, _ -> x }

    private fun initGrid(m: Int, n: Int, t: Double): Array<DoubleArray> {

        val grid = Array(m + 1) { DoubleArray(n + 1) { .0 } }

        // початкові дані
        for (i: Int in 0..n) {
            grid[0][i] = mu1(i * t)
            grid[m][i] = mu2(i * t)
        }

        //Крайові дані
        for (i: Int in 0..m) grid[i][0] = phi(i * h)

        return grid
    }
    fun getGrid(t: Double) : Array<DoubleArray> {

        val m = (l / h).toInt()
        val n = (l / t).toInt()

        val grid = initGrid(m, n, t)

        //Заповнення матриці
        for(j in 0 until n) {
            for (i in 1 until m) {
                grid[i][j + 1] = grid[i][j] + t * k * (grid[i + 1][j] - 2 * grid[i][j] + grid[i - 1][j]) / h.pow(2)+ t * func(i * h, t)
            }
        }

        // matrix render
        grid.map { line -> line.map { x ->  print("${(x.toFloat())} ") }; println() }

        return grid;
    }
}