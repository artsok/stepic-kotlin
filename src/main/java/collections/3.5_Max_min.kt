package collections

/*
Max; min

Implement Shop.getCustomerWithMaximumNumberOfOrders() and Customer.getMostExpensiveOrderedProduct()
using max, min, maxBy, or minBy.

listOf(1, 42, 4).max() == 42
listOf("a", "ab").minBy { it.length } == "a"

data class Shop(val name: String, val customers: List)

data class Customer(val name: String, val city: City, val orders: List)

data class Order(val products: List, val isDelivered: Boolean)

data class Product(val name: String, val price: Double)

max = Returns the largest element or null if there are no elements. If any of elements is NaN returns NaN.
min = Returns the smallest element or null if there are no elements. If any of elements is NaN returns NaN.
MinBy = Returns the first element yielding the smallest value of the given function or null if there are no elements.
MaxBy = Returns the first element yielding the largest value of the given function or null if there are no elements.

Read {
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/max.html
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/min.html
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/max-by.html
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/min-by.html
}
 */

// Return a customer whose order count is the highest among all customers
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = this.customers.maxBy { it.orders.size }

// Return the most expensive product which has been ordered
fun Customer.getMostExpensiveOrderedProduct(): Product? = this.orders.flatMap { it.products }.maxBy { it.price }


fun main(args: Array<String>) {
    listOf(1, 42, 4).max()
}