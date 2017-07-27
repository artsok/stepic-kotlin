package part2

import java.time.LocalDate

/*
Implement the function MyDate.rangeTo(). This allows you to create a range of dates using the following syntax:

MyDate(2015, 5, 11)..MyDate(2015, 5, 12)

Note that now the class DateRange implements the standard ClosedRange interface and inherits contains method implementation.
 */

operator fun MyDate3.rangeTo(other: MyDate3):DateRange3 = DateRange3(this, other)


class DateRange3(override val start: MyDate3, override val endInclusive: MyDate3): ClosedRange<MyDate3>


data class MyDate3(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate3>{
    override fun compareTo(other: MyDate3): Int {
        return LocalDate.of(this.year, this.month, this.dayOfMonth)
                .compareTo(LocalDate.of(other.year, other.month, other.dayOfMonth))
    }
}


fun checkInRange(date: MyDate3, first: MyDate3, last: MyDate3): Boolean {
    println("hello 3")
    return date in first..last
}

fun main(args: Array<String>) {

    val a = MyDate2(1988, 12, 12)
    val b = MyDate2(1989, 12, 12)
    val c = MyDate2(1990, 12, 12)
    println(checkInRange(b, a, c))
}