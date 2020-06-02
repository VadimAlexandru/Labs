package lab4


import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

fun main(){
    val n = 20
    val m = 20
    val h = 0.1
    val g = 0.1
    val u = Array(n+1){Array(m+1){0.0} }
    for (i in 0..n){
        u[i][0] = i*h
        if (i<=n/2) u[i][m] = 2.0
        if (i>=n/2) u[i][m/2] = i*h
    }
    for (j in 0..m){
        u[0][j] = 0.0
        if (j<=m/2) u[n][j]= 2.0
        if (j>=m/2) u[n/2][j] = 1.0
    }
    val a: Array<Array<Double>> = Array(n+1){Array(m+1){0.0} }
    var max: Double
    do {
        for (i in 1 until n)
            for (j in 1 until m)
                a[i][j] = u[i][j]
        max = 0.0
        for (i in 1 until n/2)
            for (j in 1 until m) {
                u[i][j+1] =
                    (g*g * (u[i - 1][j] + u[i + 1][j]) + h*h * (u[i][j - 1] + u[i][j + 1]) - h*h*g*g * sin( j * g))/(2*(h*h+g*g))
                if (abs(u[i][j] - a[i][j]) >max) max = abs(u[i][j] - a[i][j])
            }
        for (i in n/2 until n)
            for (j in 1 until m/2) {
                u[i][j+1] =
                    (g*g * (u[i - 1][j] + u[i + 1][j]) + h*h * (u[i][j - 1] + u[i][j + 1]) - h*h*g*g * sin( j * g))/(2*(h*h+g*g))
                if (abs(u[i][j] - a[i][j]) >max) max = abs(u[i][j] - a[i][j])
            }
    }while (max!!>0.0001)
    for (i in 0..n/2)
        for (j in 0..m)
            println("u( ${(i*h).toString().substring(0,3)} ; ${(j*g).toString().substring(0,3)} ) = ${u[i][j]}")
    for (i in n/2..n)
        for (j in 0..m/2)
            println("u( ${(i*h).toString().substring(0,3)} ; ${(j*g).toString().substring(0,3)} ) = ${u[i][j]}")


}
