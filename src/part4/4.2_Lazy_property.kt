package part4


/*

Lazy property

Add a custom getter to make the 'lazy' val really lazy. It should be initialized by the invocation of 'initializer()'
at the moment of the first access.

You can add as many additional properties as you need.

Do not use delegated properties!

 */



class LazyProperty(val initializer: () -> Int ) {

    val lazyDelegates: String by lazy {
        println("computed!")
        "Hello"
    }

    var a:Int? = null

    val lazy: Int
        get() {
            if(a == null) {
                a = initializer.invoke()
            }
            return (a as Int)
        }


}


fun main(args: Array<String>) {
    val a: LazyProperty = LazyProperty({5})
    println(a.lazy)
    println(a.lazy)

    println(a.lazyDelegates)
    println(a.lazyDelegates)

    println(a.initializer)
    println(a.initializer())
}