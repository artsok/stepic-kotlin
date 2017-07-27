package part2

import java.time.LocalDate

/*
Kotlin for loop iterates through anything that provides an iterator.
Make the class DateRange implement Iterable<MyDate>, so that it could be iterated over.
You can use the function MyDate.nextDay().

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate>

Read {http://kotlinlang.ru/docs/reference/control-flow.html}
 */

class DateRange4(override val start: MyDate4, override val endInclusive: MyDate4): ClosedRange<MyDate4>, Iterable<MyDate4> {

        private var date:LocalDate = LocalDate.of(start.year, start.month, start.dayOfMonth)

        override fun iterator(): Iterator<MyDate4> {
        return object : Iterator<MyDate4> {
            override fun next(): MyDate4 {
                return nextDay()
            }
            override fun hasNext(): Boolean {
                return hasNextDay()
            }
        }
    }

    private fun nextDay() : MyDate4 {
        val myDate:MyDate4 = MyDate4(date.year, date.monthValue, date.dayOfMonth)
        date = date.plusDays(1)
        return myDate
    }

    private fun hasNextDay(): Boolean {
        val start = LocalDate.of(start.year, start.month, start.dayOfMonth)
        val endInclusive = LocalDate.of(endInclusive.year, endInclusive.month, endInclusive.dayOfMonth)
        if((start.isEqual(date) || start.isBefore(date))
                && (endInclusive.isAfter(date) || endInclusive.isEqual(date)))
            return true
        return false
    }


}

operator fun MyDate4.rangeTo(other: MyDate4):DateRange4 = DateRange4(this, other)

data class MyDate4(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate4>{

    override fun toString(): String {
        return "year=$year, month=$month, dayOfMonth=$dayOfMonth"
    }

    override fun compareTo(other: MyDate4): Int {
        return LocalDate.of(this.year, this.month, this.dayOfMonth)
                .compareTo(LocalDate.of(other.year, other.month, other.dayOfMonth))
    }
}

//
//fun iterateOverDateRange(firstDate: MyDate4, secondDate: MyDate4, handler: (MyDate4) -> Unit) {
//    for (date in firstDate..secondDate) {
//        handler(date)
//    }
//}



fun iterateOverDateRange(firstDate: MyDate4, secondDate: MyDate4) {
    for (date in firstDate..secondDate) {
        println(date)
    }
}

fun main(args: Array<String>) {
    val date1 = MyDate4(1988, 12, 12)
    val date2 = MyDate4(1988, 12, 15)
    iterateOverDateRange(date1, date2)


}


