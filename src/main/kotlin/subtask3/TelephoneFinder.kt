package subtask3

import java.lang.StringBuilder

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val numberLong = number.toLongOrNull() ?: -1            // Проверка корректности телефонного номера
        return if (numberLong < 0) {
            null
        } else {
            getNewPhones(number)
        }
    }

    // Получить список номеров телефонов соседей для данного номера
    private fun getNewPhones(number: String): Array<String> {
        val phonesList = mutableListOf<String>()                // Создаем пустой список для хранения полученных номеров
        val numberString = StringBuilder(number)                // Преобразуем String в StringBuilder, чтобы легче было работать со строкой
        for ((i, figure) in number.withIndex()) {               // Для каждой цифры в строке ищем соседей
            val numberSet = getNumberSet(figure)                // Получаем набор соседей для данной цифры
            for (newFigure in numberSet) {                      // Заменяем выбранную цифру на соседние цифры
                numberString[i] = newFigure
                phonesList.add(numberString.toString())
                //println(numberString)
            }
            numberString[i] = figure                            // Восстанавливаем исходный номер телефона
        }
        return phonesList.toTypedArray()                        // Возвращаем полученный список номеров
    }

    // Получить набор соседей для выбранной цифры
    private fun getNumberSet(number: Char): Array<Char> {
        return when (number) {
            '1' -> arrayOf('2', '4')
            '2' -> arrayOf('1', '3', '5')
            '3' -> arrayOf('2', '6')
            '4' -> arrayOf('1', '5', '7')
            '5' -> arrayOf('2', '4', '6', '8')
            '6' -> arrayOf('3', '5', '9')
            '7' -> arrayOf('4', '8')
            '8' -> arrayOf('5', '7', '9', '0')
            '9' -> arrayOf('6', '8')
            else -> arrayOf('8')
        }
    }
}
