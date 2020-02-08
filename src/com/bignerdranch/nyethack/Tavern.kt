package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

//var playerGold = 10
//var playerSilver = 10
//val patronList = listOf("Eli", "Mordoc", "Sophie")
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot","Fernsworth","Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
        .readText()
        .split("\r\n")

//val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
val patronGold = mutableMapOf<String, Double>()

private fun <T> Iterable<T>.random(): T = this.shuffled().first()

fun main(args: Array<String>) {
    //placeOrder()
    //placeOrder("shandy,Dragon's Breath,5.91")
    //placeOrder("elixir,Shirley's Temple,4.12")
    //println(patronList[0])

//    if(patronList.contains("Eli")) {
//        println("술집 주인이 말한다: Eli는 안쪽 방에서 카드하고 있어요.")
//    } else {
//        println("술집 주인이 말한다: eli는 여기 없어요.")
//    }

//    if(patronList.containsAll(listOf("Sophie","Mordoc"))) {
//        println("술집 주인이 말한다: 네, 모두 있어요.")
//    } else {
//        println("술집 주인이 말한다: 아니오, 나간 사람도 있습니다.")
//    }

/*    println(patronList)
    patronList.remove("Eli")
    patronList.add("Alex")
    patronList.add(0, "Alex")
    patronList[0]="Alexis"
    println(patronList)*/

//    for(patron in patronList) {
//        println("좋은 밤입니다. $patron 님")
//    }

//    patronList.forEach{ patron ->
//        println("좋은 밤입니다. $patron 님")
//    }

//    patronList.forEachIndexed{ index, patron ->
//        println("좋은 밤입니다. $patron 님 - 당신은 #${index+1} 번째입니다.")
//        placeOrder(patron, menuList.shuffled().first())
//    }
//
//    menuList.forEachIndexed { index, data ->
//        println("$index : $data")
//    }

    (0..9).forEach{
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"
        //println(name)
        uniquePatrons += name
    }
    //println(uniquePatrons)
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while(orderCount <= 9) {
        placeOrder(uniquePatrons.random(), menuList.random())
        orderCount++
    }

    displayPatronBalances()
    //println(patronGold)
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

/*fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("지갑 전체 금액: 금화 $totalPurse")
    println("금화 $price 로 술을 구입함")
    val remainingBalance = totalPurse - price
    println("남은 잔액: ${"%.2f".format(remainingBalance)}")

    val remainGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainGold
    playerSilver = remainingSilver
    displayBalance()
}*/


/*fun displayBalance() {
    println("플레이어의 지갑 잔액: 금화: $playerGold 개, 은화: $playerSilver 개")
}*/

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    //println("마드리갈은 $tavernMaster 에게 주문한다.")
    println("$patronName 은 $tavernMaster 에게 주문한다.")
    val (type, name, price) = menuData.split(",")
    val message = "$patronName 은 금화 $price 로 $name ($type)를 구입한다."
    println(message)
    performPurchase(price.toDouble(), patronName)

    val phrase = if(name == "Dragon's Breath") {
        "$patronName 이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "$patronName 이 말한다: 감사합니다. $name."
    }

    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
        phrase.replace(Regex("[aeiou]")) {
            when(it.value) {
                "a" -> "4"
                "e" -> "3"
                "i" -> "1"
                "o" -> "0"
                "u" -> "|_|"
                else -> it.value
            }
        }

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("마드리갈은 $tavernMaster 에게 주문한다.")

    val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    var price = data[2]
    val message = "마드리갈은 금화 $price 로 $name ($type)를 구입한다."
    println(message)

//    var phrase = "와, $name 진짜 좋구나!"
//    println("마드리갈이 감탄한다: ${toDragonSpeak(phrase)}")

    val phrase = if (name == "Dragon's Breath") {
        "마드리갈이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "마드리갈이 말한다: 감사합니다 $name."
    }
    println(phrase)
}