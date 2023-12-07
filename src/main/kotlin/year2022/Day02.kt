package year2022

import util.asResourceFile

object Day02 {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day02.txt".asResourceFile().readLines()

        val shapeValue: HashMap<String, Int> = hashMapOf("X" to 1, "Y" to 2, "Z" to 3)

        val winValue = mapOf(
            "A" to mapOf("X" to 3, "Y" to 6, "Z" to 0),
            "B" to mapOf("X" to 0, "Y" to 3, "Z" to 6),
            "C" to mapOf("X" to 6, "Y" to 0, "Z" to 3)
        )

        val shape = mapOf(
            "A" to mapOf("X" to "Z", "Y" to "X", "Z" to "Y"),
            "B" to mapOf("X" to "X", "Y" to "Y", "Z" to "Z"),
            "C" to mapOf("X" to "Y", "Y" to "Z", "Z" to "X")
        )

        val sum1 = input.sumOf {
            val (x, y) = it.split(" ")
            shapeValue[y]?.plus(winValue[x]?.get(y)!!)!!
        }
        println(sum1)

        val sum2 = input.sumOf {
            val (x, y) = it.split(" ")
            val currentShape = shape[x]?.get(y)!!
            shapeValue[currentShape]?.plus(winValue[x]?.get(currentShape)!!)!!
        }
        println(sum2)
    }
}
