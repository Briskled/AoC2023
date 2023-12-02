package _02.cube_conundrum

import kotlin.math.max

class Game(
    val id: Int,
    val green: Int,
    val red: Int,
    val blue: Int,
) {
    companion object {
        private val groupRegex = Regex("(\\d+) (red|green|blue)")
        private val gameRegex = Regex("Game (\\d+): ([a-z\\d,; ]+)")

        // format: [GAME [ID]: [PULLS [GROUP]]]
        fun parse(input: String): Game {
            val gameMatch = gameRegex.find(input)!!
            val (id, pullsInput) = gameMatch.destructured

            var green=0
            var red=0
            var blue=0
            val pulls = pullsInput.split(";")

            pulls.forEach { pull ->
                pull.split(",").forEach {group ->
                    val groupMatch = groupRegex.find(group)!!
                    val (amountStr, color) = groupMatch.destructured

                    val amount = amountStr.toInt()
                    when(color) {
                        "red" -> red = max(red, amount)
                        "green" -> green = max(green, amount)
                        "blue" -> blue = max(blue, amount)
                    }
                }
            }

            return Game(id.toInt(), green, red, blue)
        }
    }
}