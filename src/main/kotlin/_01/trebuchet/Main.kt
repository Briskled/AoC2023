package _01.trebuchet

import kotlin.math.max
import org.springframework.core.io.ClassPathResource

val map = mapOf(
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9",
)

fun main(args: Array<String>) {
    val lines = ClassPathResource("_01/trebuchet/input.txt").file.readLines()
    var sum = 0
    lines.forEach { line ->
        var firstIndexOfWord = line.length+1
        var firstWord: String? = null
        var lastIndexOfWord = -1
        var lastWord: String? = null
        val firstIndexOfDigit = line.indexOfFirst { it.isDigit() }
        val firstDigit = line.first { it.isDigit() }
        val lastIndexOfDigit = line.indexOfLast { it.isDigit() }
        val lastDigit = line.last { it.isDigit() }

        map.keys.forEach { v ->
            val firstIndex = line.indexOf(v)
            val lastIndex = line.lastIndexOf(v)

            if(firstIndex == -1 || lastIndex == -1)
                return@forEach

            if(firstIndex < firstIndexOfWord) {
                firstIndexOfWord = firstIndex
                firstWord = v
            }
            if(lastIndex > lastIndexOfWord) {
                lastIndexOfWord = lastIndex
                lastWord = v
            }
        }

        val n1 = if(firstIndexOfWord < firstIndexOfDigit) map[firstWord]!! else "$firstDigit"
        val n2 = if(lastIndexOfWord > lastIndexOfDigit) map[lastWord]!! else "$lastDigit"

        sum += "$n1$n2".toInt()
    }

    println(sum)
}
