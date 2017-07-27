package part4

/*

Delegates example

Read about delegated properties and make the property lazy by using delegates.

Read {
http://kotlinlang.org/docs/reference/delegated-properties.html

Существует несколько основных видов свойств, которые мы реализовываем каждый раз вручную в случае их надобности.
Однако намного удобнее было бы реализовать их раз и навсегда и положить в какую-нибудь библиотеку. Примеры таких свойств:
    ленивые свойства (lazy properties): значение вычисляется один раз, при первом обращении
    свойства, на события об изменении которых можно подписаться (observable properties)
    свойства, хранимые в ассоциативном списке, а не в отдельных полях
}
 */

class LazyPropertyDelegated(val initializer: () -> Int) {
    val lazyValue: Int by lazy {
        println("Lazy")
        initializer.invoke()
    }
}

fun main(args: Array<String>) {
    val a: LazyPropertyDelegated = LazyPropertyDelegated ({5})
    println(a.lazyValue)
    println(a.lazyValue)

}