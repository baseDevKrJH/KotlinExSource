package NyetHack

fun main(args: Array<String>) {
/*
    var signatureDrink = "맥주"
    signatureDrink = null
*/
/*
    var beverage = readLine()?.capitalize()
*/
    var beverage = readLine()?.let{
        if(it.isNotBlank()) {
            it.capitalize()
        } else {
            "맥주"
        }
    }
//    beverage = null

    println(beverage)
}