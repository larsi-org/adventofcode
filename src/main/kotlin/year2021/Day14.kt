package year2021

import util.asResourceFile

object Day14 {
    val mapping = IntArray(26 * 26)
    val counter = LongArray(26)

    inline fun c2n(c: Char): Int = c.code - 'A'.code

    fun step(left: Int, right: Int, n: Int) {
        val middle = mapping[26 * left + right]
        if (n == 1) {
            counter[left] = counter[left] + 1
            counter[middle] = counter[middle] + 1
        } else {
            step(left, middle, n - 1)
            step(middle, right, n - 1)
        }
    }

    fun count(input: List<String>, steps: Int): Long {
        val start = input[0]

        val linePattern = """([A-Z])([A-Z]) -> ([A-Z])""".toRegex()
        for (i in 2 until input.size) {
            val (k1, k2, v) = linePattern.matchEntire(input[i])!!.destructured
            mapping[26 * c2n(k1[0]) + c2n(k2[0])] = c2n(v[0])
        }

        for (i in 1 until start.length) {
            println(i)
            step(c2n(start[i - 1]), c2n(start[i]), steps)
        }
        counter[c2n(start[start.length - 1])] =  counter[c2n(start[start.length - 1])] + 1

        val result = counter.filter { it > 0 }.sorted()
        println(result.joinToString(" "))
        return result[result.size - 1] - result[0]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2021/Day14.txt".asResourceFile().readLines()
        println(count(input, 40))
    }
}
