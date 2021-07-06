package subtask1

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        for (x in 1..array[1]) {
            val m = factorial(array[1]) / (factorial(x) * factorial(array[1] - x))
            if (m == array[0].toLong()) {
                return x
            }
        }
        return null
    }

    private fun factorial(n: Int): Long {
        return if (n > 1) (n.toLong() * factorial(n - 1)) else 1
    }
}
