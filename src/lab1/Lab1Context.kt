package lab1

import view.GridRender

/**
 * @author Vadim Alexandru
 */
class Lab1Context {

    var k = 4
    var l = 1
    var T = 1
    var h = .1
    var t = .001

    var render = GridRender()

    var phi: (x: Double) -> Double = {
        5 * (1 - it)
    }
    var mu1: (t: Double) -> Double = {
        5 * kotlin.math.exp(-it)
    }
    var mu2: (t: Double) -> Double = {
        it
    }
    var func: (x: Double, t: Double) -> Double = {
            x,t -> t * x
    }

}