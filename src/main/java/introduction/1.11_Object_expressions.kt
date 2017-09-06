package introduction

/**
Object expressions

Read about object expressions that play the same role in Kotlin as anonymous classes in Java.

Add an object expression that provides a comparator to sort a list in a descending order using
java.util.Collections class. In Kotlin you use Kotlin library extensions instead of java.util.Collections,
but this example is still a good demonstration of mixing Kotlin and Java code.

Read {http://kotlinlang.ru/docs/reference/object-declarations.html}
**/

import java.util.*
import kotlin.Comparator

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o2.compareTo(o1)
        }

    })
    return arrayList
}

fun main(args: Array<String>) {
    print(getList())
}