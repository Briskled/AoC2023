package _02.cube_conundrum

import org.springframework.core.io.ClassPathResource

fun main(args: Array<String>) {
    val games = ClassPathResource("_02/cube_conundrum/input.txt").file
        .readLines()
        .map { Game.parse(it) }

    part1(games)
    part2(games)
}

fun part1(games: List<Game>) {
    val idSum = games.filter { it.red <= 12 && it.green <= 13 && it.blue <= 14 }
        .sumOf { it.id}
    println("Solution for Part 1: $idSum")
}

fun part2(games: List<Game>) {
    val powerSum = games.sumOf { it.red * it.green * it.blue }
    println("Solution for Part 2: $powerSum")
}

