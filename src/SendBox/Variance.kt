package SendBox

class Barrel<out T>(val item: T)

fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("평범한 중절모", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    // 제너릭 타입은 Loot와 Fedora간의 슈퍼-서브관계를 컴파일러가 무시
    lootBarrel = fedoraBarrel   // Barrel<Fedora> Rarrel<Loot> ( 제네릭 인스턴스는 원시 타입과 제네릭 타입이 결합된 것이 자신의 타입이 됨 )

    var myFedora: Fedora = lootBarrel.item
}