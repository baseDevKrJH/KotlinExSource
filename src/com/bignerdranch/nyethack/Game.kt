package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    //val name="마드리갈"
//    var healthPoints = 89
//    val isBlessed = true
//    val isImmortal = false

    val player = Player()
    player.castFireball()

//    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
//    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(player/*auraColor, isBlessed, player.name, healthStatus*/)

//    castFireball()

//    if(isBlessed && healthPoints > 50 || isImmortal) {
//    if(auraVisible) {
//        println("GREEN")
//    } else {
//        println("NONE")
//    }
//
//    if(healthPoints == 100) {
//        println(name + " 최상의 상태임!")
//    } else if(healthPoints >= 90) {
//        println(name + " 약간의 찰과상만 있음.")
//    } else if(healthPoints >= 75) {
//        if(isBlessed) {
//            println(name + " 경미한 상처가 있지만 빨리 치유됨!")
//        } else {
//            println(name + " 경미한 상처만 있음.")
//        }
//    } else if(healthPoints >= 15) {
//        println(name + " 많이 다친 것 같음.")
//    } else {
//        println(name + " 최악의 상태임!")
//    }



    //println(name + " " + healthStatus)


}

private fun printPlayerStatus(player: Player/*auraColor: String, isBlessed: Boolean, name: String, healthStatus: String*/) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

/*
private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}
*/

/*
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
        100 -> "최상의 상태임!"
        in 90..99 -> "약간의찰과상만 있음."
        in 75..89 -> if (isBlessed) {
            "경미한 상처가 있지만 빨리 치유되고 있음!"
        } else {
            "경미한 상처가 있음."
        }
        in 15..74 -> "많이 다친 것 같음"
        else -> "최악의 상태임!"
    }
    return healthStatus
}
*/

private fun castFireball(numFireballs: Int=2) {
    println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
}

