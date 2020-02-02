package SendBox

//fun <T> randomOrBackupLoot(backupLoot:() -> T): T {
//    val items = listOf(Coin(14), Fedora("고풍스런 중절모", 150))
//    val randomLoot: Loot = items.shuffled().first()
//    return if (randomLoot is T) {   // 소거된 타입인 T의 인스턴스를 검사할수 없음
//        randomLoot
//    } else {
//        backupLoot()
//    }
//}
//
//fun main(args: Array<String>) {
//    randomOrBackupLoot {
//        Fedora("대체용 중절모", 15)
//    }.run {
//        println(name)
//    }
//}

inline fun <reified T> randomOrBackupLoot(backupLoot:() -> T): T {
    val items = listOf(Coin(14), Fedora("고풍스런 중절모", 150))
    val randomLoot: Loot = items.shuffled().first()
    return if (randomLoot is T) {   // 소거된 타입인 T의 인스턴스를 검사할수 없음
        randomLoot
    } else {
        backupLoot()
    }
}

fun main(args: Array<String>) {
    randomOrBackupLoot {
        Fedora("대체용 중절모", 15)
    }.run {
        println(name)
    }
}