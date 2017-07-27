package part3

/*
Group By

Implement Shop.groupCustomersByCity() using groupBy.

val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length() }
result == mapOf(1 to listOf("a", "b"), 2 to listOf("ba", "ad"), 3 to listOf("ccc"))

data class Shop(val name: String, val customers: List)

data class Customer(val name: String, val city: City, val orders: List)

Read {
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/group-by.html
}
 */

// Return a map of the customers living in each city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = this.customers.groupBy { it.city }