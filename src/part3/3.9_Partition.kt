package part3

/*
Partition (Раздел)

Implement Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered() using partition.

val numbers = listOf(1, 3, -4, 2, -11)
val (positive, negative) = numbers.partition { it > 0 }
positive == listOf(1, 3, 2)
negative == listOf(-4, -11)

data class Shop(val name: String, val customers: List)

data class Customer(val name: String, val city: City, val orders: List)

data class Order(val products: List, val isDelivered: Boolean)

Note that destructuring declaration syntax is used in this example.

Read {
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/partition.html
    http://kotlinlang.org/docs/reference/multi-declarations.html
}
 */

// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> =
        this.customers.partition {
            it.orders.filter { it.isDelivered == false }.count() > it.orders.filter { it.isDelivered == true }.count()}.first.toSet()
