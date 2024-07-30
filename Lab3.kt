
abstract class Food(val name: String, val price: Float) {
    abstract fun cook(): String
}

class Burger(name: String, price: Float) : Food(name, price) {
    override fun cook() = "Asar la hamburguesa a la parrilla durante 5 minutos por lado."
}

class Pizza(name: String, price: Float) : Food(name, price) {
    override fun cook() = "Hornear la pizza en el horno a 200°C durante 15 minutos."
}

interface Dessert {
    fun eat(): String
}

class IceCream(name: String, price: Float) : Food(name, price), Dessert {
    override fun cook() = "Enfriar el helado en el congelador durante 2 horas."
    override fun eat() = "Comer el helado con una cuchara y disfrutar!"
}

abstract class Drink(name: String, price: Float) : Food(name, price) {
    abstract fun pour(): String
}

class Juice(name: String, price: Float) : Drink(name, price) {
    override fun cook() = "Exprimir el jugo de la fruta fresca."
    override fun pour() = "Verter el jugo en un vaso fresco."
}

fun Food.discountedPrice(percent: Int): Float {
    val discount = price * (percent / 100.0f)
    return price - discount
}

fun main() {
    val burger = Burger("Hamburguesa Clásica", 10.0f)
    val pizza = Pizza("Pizza Margherita", 15.0f)
    val iceCream = IceCream("Helado de Chocolate", 5.0f)
    val juice = Juice("Jugo de Naranja", 3.0f)

    println("Cocinar alimentos:")
    println(burger.cook())
    println(pizza.cook())
    println(iceCream.cook())
    println(juice.cook())

    println("Comer helado:")
    println(iceCream.eat())

    val discountedPrice = burger.discountedPrice(10)
    println("Precio con descuento de la hamburguesa: $discountedPrice")
}