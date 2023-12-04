package year2022

import util.asResourceFile

object Day01 {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day01.txt".asResourceFile().readLines()
        val sums = mutableListOf<Int>()
        var currentSum = 0
        for (line in input) {
            val nmbr = line.toIntOrNull()
            if (nmbr == null) {
                sums.add(currentSum)
                currentSum = 0
            } else {
                currentSum += nmbr
            }
        }
        sums.add(currentSum)

        val sumsSorted = sums.sortedDescending()

        println(sumsSorted)
        println(sumsSorted[0])
        println(sumsSorted.take(3).sum())
    }
}
