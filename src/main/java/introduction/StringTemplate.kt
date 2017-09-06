package introduction

val a = 10
val b = "b = $a"
val c = "c = ${b.length.and(10)}"
val price = """${'$'}9.99"""
val price2 = "${b.length}${'$'}"
val price3 = "9.3\$"

val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
fun getPattern(): String = """\d{2} $month \d{4}"""


fun main(args: Array<String>) {
    println(a)
    println(b)
    println(c)
    println(price)
    println(price2)
    println(price3)

    val a = "13 AUG 1992"
    println(a.matches(getPattern().toRegex()))


}
