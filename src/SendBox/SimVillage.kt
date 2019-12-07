package EX02

fun main(args: Array<String>) {
// case 1
/*
    println({
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }())
*/

// case 2
/*
    val greetingFunction: () -> String = {
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }

    println(greetingFunction())
*/

// case 3
/*
    val greetingFunction: (String) -> String = { playerName ->
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }

    println(greetingFunction("김선달"))
*/

// case 4
/*
    val greetingFunction: (String) -> String = {
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, $it 님! (copyright $currentYear)"
    }

    println(greetingFunction("김선달"))
*/

// case 5
/*
    val greetingFunction: (String, Int) -> String = {playerName, numBuildings ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }

    println(greetingFunction("김선달", 2))
*/

// case6
/*
    val greetingFunction = {playerName: String, numBuildings: Int ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }

    println(greetingFunction("김선달", 2))
*/

// case7
/*
    val greetingFunction = { playerName: String, numBuildings: Int ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }

    EX02.runSimulation("김선달", greetingFunction)
*/

// case8
/*
    runSimulation("김선달") { playerName, numBuildings ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }
*/

// case9
/*
    runSimulation("김선달", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }
*/

// case10
    runSimulation()
}
/*
inline fun runSimulation(playerName: String,
                         costPrinter: (Int) -> Unit,
                         greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}
*/
/*
fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("건축 비용: ${cost * numBuildings}")
}
*/

fun runSimulation() {
    val greetingFuncion = configureGreetingFunction()
    println(greetingFuncion("김선달"))
    println(greetingFuncion("김선달"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "병원"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2019
        numBuildings += 1
        println("$numBuildings 채의 $structureType 이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName! (copyright $currentYear)"
    }
}