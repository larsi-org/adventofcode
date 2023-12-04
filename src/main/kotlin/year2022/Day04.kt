package year2022

import util.asResourceFile

object Day04 {
    fun part(input: List<String>, fn: (Set<Int>, Set<Int>) -> Boolean): Int {
        val linePattern = """([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)""".toRegex()
        return input.count {
            val (a1, a2, b1, b2) = linePattern.matchEntire(it)!!.destructured
            val s1 = (a1.toInt()..a2.toInt()).toSet()
            val s2 = (b1.toInt()..b2.toInt()).toSet()
            fn(s1, s2)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day04.txt".asResourceFile().readLines()
        println(part(input) { s1, s2 ->
            val s12 = s1.intersect(s2)
            s12 == s1 || s12 == s2
        })
        println(part(input) { s1, s2 ->
            s1.intersect(s2) != emptySet<Int>()
        })
    }
}
