package part5

/*
String and map builders

Extension function literals are very useful for creating builders, e.g.:

fun buildString(build: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.build()
    return stringBuilder.toString()
}

val s = buildString {
    this.append("Numbers: ")
    for (i in 1..3) {
        // 'this' can be omitted
        append(i)
    }
}

s == "Numbers: 123"

Add and implement the function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
building it and returning it as a result. The usage of this function is shown below.
 */



import java.util.HashMap


fun  buildMap(hashFunction: HashMap<Int, String>.() -> Unit): Map<Int, String> {
    var hashMap = HashMap<Int,String>()
    hashMap.hashFunction()
    return hashMap
}


fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

fun buildString(buildThis: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.buildThis() //buildThis() - это название метода для StringBuilder. StringBuilder расширяем. Мы его вызываем на переданном параметре
    return stringBuilder.toString()
}

val s = buildString {
    this.append("Numbers: ")
    for (i in 1..3) {
        // 'this' can be omitted
        append(i)
    }
}

fun main(args: Array<String>) {
    println(buildString({this.append("333"); for (i in 1..3) append(i)} ))
    println(buildMap {put(0, "0"); for (i in 1..10) put(i, "$i")})
}

