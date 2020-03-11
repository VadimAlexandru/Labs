open class BaseLab {

    protected val functions = Functions()

    fun phi(phi: (x: Double) -> Double) : BaseLab {
        functions.phi = phi
        return this
    }

    fun mu1(mu1: (t: Double) -> Double) : BaseLab {
        functions.mu1 = mu1
        return this
    }

    fun mu2(mu2: (t: Double) -> Double) : BaseLab {
        functions.mu2 = mu2
        return this
    }

    fun func(func: (x: Double, t: Double) -> Double) : BaseLab {
        functions.func = func
        return this
    }

    /**
     * Перевірка узгодженості
     */
    fun checkConsistency()  = functions.phi(.0) == functions.mu1(.0)

}