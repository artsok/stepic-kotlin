package introduction

class Java {

    val text = """
        |Tell me and I forget.
        |Teach me and I remember.
        |Involve me and I learn.
        |(Benjamin Franklin)
        """


    fun containsEven(collection: Collection<Int>): Boolean = collection.any { number -> number % 2 == 0 }

    val containsEvenList:List<Int> = listOf(1, 2, 3, 4, 5)

    fun foo(name:String, number:Int = 42, toUpperCase:Boolean = false):String {
        return (if(toUpperCase) name.toUpperCase() else name) + number
    }

    fun useFoo() = listOf(
            foo("a"),
            foo("b", number = 1),
            foo("c", toUpperCase = true),
            foo(name = "d", number = 2, toUpperCase = true)
    )
}

fun main(args: Array<String>) {
    var a = Java()
    print("ABC\n123\n456".trimMargin())

    print(a.text.trimMargin())
}
