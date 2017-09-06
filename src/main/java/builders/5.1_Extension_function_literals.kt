package builders

/*

Extension function literals

Read about function literals with receiver.

You can declare isEven (четный) and isOdd (нечетный) as values, that can be called as extension functions.
Complete the declarations below.

Read {
https://kotlinlang.org/docs/reference/lambdas.html#function-literals-with-receiver
http://www.kotlinlang.ru/docs/reference/lambdas.html
}

 */

fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this%2 == 0 }
    val isOdd: Int.() -> Boolean = { this%2 == 1 }
    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}