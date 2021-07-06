package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    private val sequence = Array(10) { 0L }

    fun decomposeNumber(number: Int): Array<Int>? {
        val result = getNextNumber(0, mySquare(number.toLong()), number.toLong() - 1)
        return if (!result || (number < 0)) {
            null
        } else {
            getIntArray(sequence)
        }
    }

    private fun getNextNumber(position: Int, rest: Long, start: Long): Boolean {

        if (rest == 0L) {
            for (i in position..sequence.lastIndex) {
                sequence[i] = 0
            }
            return true
        }
        sequence[position] = start
        while (true) {
            val newRest = rest - mySquare(sequence[position])
            val newStart = sqrt(x = newRest.toDouble()).toLong()
            if (sequence[position] <= newStart) return false

            val result = getNextNumber(position + 1, newRest, newStart)
            if (result) {
                return true
            } else {
                sequence[position] = sequence[position] - 1
            }
        }
    }

    // Получение квадрата числа
    private fun mySquare(x: Long): Long {
        return (x * x)
    }

    // Преобразование рабочего массива в нужный
    private fun getIntArray(sequence: Array<Long>): Array<Int> {
        var size = 0
        for (e in sequence) {
            if (e > 0) size++
        }
        val array = Array(size) { 0 }
        for (i in array.indices) {
            array[i] = sequence[size - 1 - i].toInt()
        }
        return array
    }
}
