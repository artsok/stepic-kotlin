package test

class MainClass {

    fun printaa(a: Int): Unit {
        print(a)
    }
}

fun main(args:Array<String>) {
    //MainClass().printaa(1)
    //println(reformat("paaaa", normalizeCase = false))
    //var a:ArrayList<String> = arrayListOf("a", "b", "c")

    println(arrayListOf("a", "b", "c").joinToString(prefix = "[", postfix = "]"))
}


class Address {
    var name: String = "test"
    val test: Int = 1
    val city: String? = "test"
}

fun copyAddress():Address? {
    val result = Address()
    return null
}


fun reformat(str:String, normalizeCase: Boolean = true):String? {
    var sdt:String = str.replace("a.*", "b")
    return sdt
}


fun joinOptions(options: Collection<String>) = options.joinToString(",", "[", "]")