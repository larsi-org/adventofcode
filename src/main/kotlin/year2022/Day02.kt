package year2022

import util.asResourceFile

object Day02 {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day02.txt".asResourceFile().readLines()

        val shapeValue: HashMap<String, Int> = hashMapOf("X" to 1, "Y" to 2, "Z" to 3)

        val winValue: HashMap<String, HashMap<String, Int>> = HashMap<String, HashMap<String, Int>>()
        winValue["A"] = hashMapOf("X" to 3, "Y" to 6, "Z" to 0)
        winValue["B"] = hashMapOf("X" to 0, "Y" to 3, "Z" to 6)
        winValue["C"] = hashMapOf("X" to 6, "Y" to 0, "Z" to 3)

        val shape: HashMap<String, HashMap<String, String>> = HashMap<String, HashMap<String, String>>()
        shape["A"] = hashMapOf("X" to "Z", "Y" to "X", "Z" to "Y")
        shape["B"] = hashMapOf("X" to "X", "Y" to "Y", "Z" to "Z")
        shape["C"] = hashMapOf("X" to "Y", "Y" to "Z", "Z" to "X")

        var currentSum = 0
        for (line in input) {
            val (x, y) = line.split(" ")
            currentSum += shapeValue[y]?.plus(winValue[x]?.get(y)!!)!!
        }
        println(currentSum)

        currentSum = 0
        for (line in input) {
            val (x, y) = line.split(" ")
            val currentShape = shape[x]?.get(y)!!
            currentSum += shapeValue[currentShape]?.plus(winValue[x]?.get(currentShape)!!)!!
        }
        println(currentSum)
    }
}
