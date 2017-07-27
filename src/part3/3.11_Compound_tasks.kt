package part3

/*
Compound tasks

Implement Customer.getMostExpensiveDeliveredProduct() and Shop.getNumberOfTimesProductWasOrdered() using functions from the Kotlin standard library.

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>)

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double)

 */

// Return the most expensive product among all delivered products
// (use the Order.isDelivered flag)
fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return this.orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

// Return how many times the given product was ordered.
// Note: a customer may order the same product for several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return this.customers.flatMap { it.orders }.filter { it.products.contains(product) }.count()
}
