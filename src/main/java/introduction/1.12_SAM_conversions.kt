package introduction

/**
When an object implements a SAM interface (one with a Single Abstract Method), you can pass a lambda instead.
Read more about SAM-conversions.
In the previous example change an object expression to a lambda.

Read {https://kotlinlang.org/docs/reference/java-interop.html#sam-conversions}
 */

import java.util.*

fun getListSAM(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList) { o1, o2 -> o2.compareTo(o1) }
    return arrayList
}