import exceptions.ConsistencyException
import kotlin.math.pow

class Lab1(
    private val k : Int,
    private val l : Int,
    private val T : Int,
    private val h : Double
): BaseLab() {

    private fun initGrid(m: Int, n: Int, t: Double): Array<DoubleArray> {

        val grid = Array(m + 1) { DoubleArray(n + 1) { .0 } }

        /**
         * початкові дані
         */
        for (i: Int in 0..n) {
            grid[0][i] = functions.mu1(i * t);
            grid[m][i] = functions.mu2(i * t)
        }

        /**
         * Крайові дані
         */
        for (i: Int in 0..m) grid[i][0] = functions.phi(i * h)

        return grid
    }

    fun getGrid(t: Double) : Array<DoubleArray> {

        if(! checkConsistency()) {
            throw ConsistencyException("Перевірка узгодженості успішно провалена.")
        }

        val m = (l / h).toInt()
        val n = (T / t).toInt()
        val grid = initGrid(m, n, t)

        /**
         * Заповнення сітки
         */
        for(j in 0 until n) {
            for (i in 1 until m) {
                grid[i][j + 1] = grid[i][j] + t * k * (grid[i + 1][j] - 2 * grid[i][j] + grid[i - 1][j]) / h.pow(2)+ t * functions.func(i * h, j * t)
            }
        }

        return grid
    }
}