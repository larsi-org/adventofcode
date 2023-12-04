package year2022

import util.asResourceFile

object Day05 {
    fun part(input: List<String>, fn: (List<ArrayDeque<Char>>, Int, Int, Int) -> Unit): String {
        var separatorLine  = 0
        while (separatorLine < input.size && input[separatorLine] != "") separatorLine += 1
        println("separatorLine: $separatorLine")

        val cntQueues = input[separatorLine - 1].trim().split("[ ]+".toRegex()).size
        println("Queues: $cntQueues")

        val stacks = (1..cntQueues).map { ArrayDeque<Char>() }

        for (i in separatorLine - 2 downTo 0) {
            for (n in 0 until cntQueues) {
                val l = input[i]
                val idx = 1 + 4 * n
                val x = if (idx < l.length) l[idx] else ' '
                if (x != ' ') stacks[n].addLast(x)
            }
        }
        println(stacks)

        // "move 1 from 5 to 6"
        val linePattern = """move ([0-9]+) from ([0-9]+) to ([0-9]+)""".toRegex()
        for (i in separatorLine + 1 until input.size) {
            val (n, f, t) = linePattern.matchEntire(input[i])!!.destructured
            fn(stacks, n.toInt(), f.toInt() - 1, t.toInt() - 1)
        }
        println(stacks)

        return stacks.map { it.last() }.joinToString("")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day05.txt".asResourceFile().readLines()
        println(part(input) { stacks, n, f, t ->
            for (i in 0 until n) stacks[t].addLast(stacks[f].removeLast())
        })
        println(part(input) { stacks, n, f, t ->
            val temp = ArrayDeque<Char>()
            for (i in 0 until n) temp.addLast(stacks[f].removeLast())
            for (i in 0 until n) stacks[t].addLast(temp.removeLast())
        })
    }
}
