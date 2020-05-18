package lab3

import view.GridRender
import kotlin.math.exp
import kotlin.math.pow

class Lab3Context {
    var render = GridRender()
    var k = 4
    var l = 2
    var h = .1
    var g = .1

    var epsilon = .001

    var phi1 : (x : Double) -> Double =  {
        it.pow(2) * exp(-it)
    }

    var phi2 : (x : Double) -> Double = {
        4 * exp(it)
    }

    var psy1 : (y : Double) -> Double = {
        it
    }

    var psy2 : (y : Double) -> Double = {
        4 * exp(it - 2)
    }

    var func : (x : Double, y : Double) -> Double = {
        x,y -> x.pow(2) + y.pow(2)
    }
}