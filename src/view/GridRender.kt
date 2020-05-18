package view

class GridRender {
    fun view (grid : Array<DoubleArray>) {

        println("lines: ${grid.size}")
        println("columns: ${grid[0].size}")

        grid.map { l -> l.map { print("${it.toFloat()} ") }; println() }
    }
}