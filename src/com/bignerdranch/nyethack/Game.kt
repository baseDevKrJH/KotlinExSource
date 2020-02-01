package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    Game.play()
}



object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = Townsquare()

    init {
        println("방문을 환영합니다.")
        player.castFireball()
    }
    fun play() {
        while(true) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> 명령을 입력하세요: ")
            println("최근 명령: ${readLine()}")
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })
    }
}

private fun castFireball(numFireballs: Int=2) {
    println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
}

