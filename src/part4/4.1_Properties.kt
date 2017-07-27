package part4

/*
Read about properties in Kotlin.

Add a custom setter to PropertyExample.propertyWithCounter so that the counter property is incremented every
time propertyWithCounter is assigned to.

Read {
http://kotlinlang.ru/docs/reference/properties.html
http://kotlinlang.org/docs/reference/properties.html#properties-and-fields
}
 */

class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set (value) {
            field = value
            counter++
        }
}

fun main(args: Array<String>) {
    val a:PropertyExample = PropertyExample()
    a.propertyWithCounter = null
    a.propertyWithCounter = 1
    a.propertyWithCounter = 1
    a.propertyWithCounter = 1
}