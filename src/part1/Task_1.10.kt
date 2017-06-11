package part1


/**
 * Read about extension functions.
 * Then implement extension functions Int.r() and Pair.r() and make them convert Int and Pair to RationalNumber.
 */

fun Int.r(): RationalNumber = RationalNumber(this, 0)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(this.first, this.second)

data class RationalNumber(val numerator: Int, val denominator: Int)

fun String.TAD2(string:String):String {
    return "Test Automation Day 2 SBT"
}

fun main(args: Array<String>) {
    println("2".TAD2("2"))
}

