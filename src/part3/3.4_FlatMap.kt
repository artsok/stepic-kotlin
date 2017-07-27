package part3

/*
Implement Customer.getOrderedProducts() and Shop.getAllOrderedProducts() using flatMap.

val result = listOf("abc", "12").flatMap { it.toCharList() }
result == listOf('a', 'b', 'c', '1', '2')

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>)

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double)

Read {
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/flat-map.html
}
 */

// Return all products this customer has ordered
fun Customer.getOrderedProducts(): Set<Product> = this.orders.flatMap { it.products }.toSet()

// Return all products that were ordered by at least one customer
fun Shop.getAllOrderedProducts(): Set<Product> =  this.customers.flatMap { it.getOrderedProducts() }.toSet()

