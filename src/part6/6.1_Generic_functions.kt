package part6

import java.util.*

/*
Generic functions

Make the following code compile by implementing a partitionTo function that splits a collection into
two collections according to the predicate.

There is a partition() function in the standard library that always returns two newly created lists.
You should write a function that splits the collection into two collections given as arguments.
The signature of the toCollection() function from the standard library may help you.

Read {
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/partition.html
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-collection.html
http://kotlinlang.ru/docs/reference/generics.html
}
 */


fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    assert(words == listOf("a", "c"))
    assert(lines == listOf("a b", "d e"))
}

fun main(args: Array<String>) {
    partitionWordsAndLines()
    partitionLettersAndOtherSymbols()

}

private fun <T : Any> Iterable<T>.partitionTo(one: MutableCollection<T>, second: MutableCollection<T>, predicate: (T) -> Boolean)
        : Pair<MutableCollection<T>, MutableCollection<T>> {
    for (item in this) {
        if (predicate(item)) {
            one.add(item)
        } else {
            second.add(item)
        }
    }
    return Pair(one, second)
}

//Функция два - Проверка #2
fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    println(letters == setOf('a', 'r'))
    println(other == setOf('%', '}'))
}


public fun <T, C : MutableCollection<in T>> Iterable<T>.toCollection(destination: C): C {
    for (item in this) {
        destination.add(item)
    }
    return destination
}


public inline fun <T> Iterable<T>.partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>> {
    val first = ArrayList<T>()
    val second = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}
