package part3

/*

All, Any and other predicates

Implement all the functions below using all, any, count, find.

val numbers = listOf(-1, 0, 2)
val isZero: (Int) -> Boolean = { it == 0 }
numbers.any(isZero) == true
numbers.all(isZero) == false
numbers.count(isZero) == 1
numbers.find { it > 0 } == 2


data class Shop(val name: String, val customers: List)

data class City(val name: String)

data class Customer(val name: String, val city: City, val orders: List)

Read {
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/all.html
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/any.html
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/count.html
}
 */

// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = this.customers.all {it.city == city }

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = this.customers.any { it.city == city }

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = this.customers.count { it.city == city }

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = this.customers.find { it.city == city }

