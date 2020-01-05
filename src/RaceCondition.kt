class Weapon(val name:String)
class Player {
    var weapon: Weapon? = Weapon("Ebony Kris")

    fun printWeaponName() {
        if(weapon != null) {
//            println(weapon.name)
        }
    }
}

fun main(args: Array<String>) {
    Player().printWeaponName()
}