package part3

/*
This part was inspired by GS Collections Kata.

Default collections in Kotlin are Java collections, but there are lots of useful extension functions for them. For example, operations that transform a collection to another one, starting with 'to': toSet or toList.

Implement an extension function Shop.getSetOfCustomers().

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>)

Read {
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-list.html
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-set.html
https://github.com/goldmansachs/gs-collections-kata
}
 */



data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>)

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double)

data class City(val name: String)

fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()