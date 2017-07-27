package part3

/*
reduce vs  fold
Kotlin also provides a very commonly used function named fold which does the same thing as reduce.
The difference between the two is that fold takes an explicit initial value, whereas reduce uses the first element from the list as the initial value.

Implement Shop.getSetOfProductsOrderedByEveryCustomer() using fold.

listOf(1, 2, 3, 4).fold(1, {
    partProduct, element ->
    element * partProduct
}) == 24

data class Shop(val name: String, val customers: List)

data class Customer(val name: String, val city: City, val orders: List)

data class Order(val products: List, val isDelivered: Boolean)

https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/fold.html
 */

// Return the set of products that were ordered by every customer {Вернуть продукты, которые были заказаны каждым покупателем}
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    return this.customers.fold(this.customers.get(0).getOrderedProducts(), {element, it ->
        element.intersect(it.getOrderedProducts())
     })
}



fun main(args: Array<String>) {
    val productsA:List<Product> = listOf(
            Product("A", 12.5),
            Product("B", 13.5),
            Product("C", 14.5))

    val productsB:List<Product> = listOf(
            Product("A", 12.5),
            Product("D", 13.5),
            Product("E", 14.5))

    val productsC:List<Product> = listOf(
            Product("A", 12.5),
            Product("F", 13.5),
            Product("H", 14.5))


    val customerA:Customer =
            Customer("Artem Sokovets", City("Saint-Petersburg"), listOf(
                    Order(productsA, true),
                    Order(productsB, false)))

    val customerB:Customer =
            Customer("Alexandra Sokovets", City("Saint-Petersburg"), listOf(
                    Order(productsC, true)))


    val shop:Shop = Shop("SokovetsShop", listOf(customerA))

    println(shop.getSetOfProductsOrderedByEveryCustomer())


}