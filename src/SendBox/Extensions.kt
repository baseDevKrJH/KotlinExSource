package SendBox

val String.numVowels
    get() = count { "aeiouy".contains(it) }

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

infix fun String?.printWithDevault(default: String) = print(this ?: default)

//fun Any.easyPrint() = println(this)

fun <T> T.easyPrint() : T {
    println(this)
    return this
}

fun main(args: Array<String>) {
    //println("마드리갈이 그 건물에서 나왔습니다".addEnthusiasm())
    //"마드리갈이 그 건물에서 나왔습니다".addEnthusiasm().easyPrint()

    "마드리갈이 그 건물에서 나왔습니다".easyPrint().addEnthusiasm().easyPrint()

    42.easyPrint()

    "How many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDevault "기본 문자열"
}