package collections

/*
Filter; map

Implement extension functions Shop.getCitiesCustomersAreFrom() and Shop.getCustomersFrom() using functions map and filter.

val numbers = listOf(1, -1, 2)
numbers.filter { it > 0 } == listOf(1, 2)
numbers.map { it * it } == listOf(1, 1, 4)


data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>)


data class City(val name: String)

Read {
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/filter.html
}

 */


// Return the set of cities the customers are from
fun Shop.getCitiesCustomersAreFrom(): Set<City> = this.customers.map { it -> it.city }.toSet()

// Return a list of the customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> = this.customers.filter { it.city == city }.toList()

