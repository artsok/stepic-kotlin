package part6

/**
 * Developed by Sokovets-AV on 04.09.2017.
 *
 * http://kotlinlang.ru/docs/reference/generics.html
 */

class Box<T>(t:T) {
    var value = t
}

val box: Box<Int> = Box<Int>(1)

// Но если параметры могут выведены из контекста (в аргументах конструктора или в некоторых других случаях),
// можно опустить указание типа:
val box1 = Box(1)

