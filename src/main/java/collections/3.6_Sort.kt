package collections

/*
Sort

Implement Shop.getCustomersSortedByNumberOfOrders() using sorted or sortedBy.

listOf("bbb", "a", "cc").sorted() == listOf("a", "bbb", "cc")
listOf("bbb", "a", "cc").sortedBy { it.length } == listOf("a", "cc", "bbb")

data class Shop(val name: String, val customers: List)

data class Customer(val name: String, val city: City, val orders: List)

Read {
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sorted.html
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sorted-by.html
}

SortedBy = Returns a list of all elements sorted according to natural sort order of the value returned by specified selector function.


 */

// Return a list of customers, sorted by the ascending number of orders they made
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = this.customers.sortedBy {it.orders.size}

