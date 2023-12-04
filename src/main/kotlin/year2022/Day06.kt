package year2022

import util.asResourceFile

object Day06 {
    private fun part(input: String, lngth: Int): Int {
        input.windowed(lngth).forEachIndexed { i, v ->
            if (v.toSet().size == lngth) return lngth + i
        }
        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day06.txt".asResourceFile().readLines()[0]
        println(part(input, 4))
        println(part(input, 14))
    }
}
