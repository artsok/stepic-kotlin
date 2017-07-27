package part2

import java.time.LocalDate

/*
In Kotlin 'in' checks are translated to the corresponding contains calls:

val list = listOf("a", "b")
"a" in list  // list.contains("a")
"a" !in list // !list.contains("a")


data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate>

Read about ranges. Add a method fun contains(d: MyDate) to the class DateRange to allow in checks with a range of dates.

Read {http://kotlinlang.org/docs/reference/ranges.html
http://kotlinlang.ru/docs/reference/ranges.html}
 */



class DateRange(val start: MyDate2, val endInclusive: MyDate2) : Comparable<DateRange> {
    override fun compareTo(other: DateRange): Int {
        return this.hashCode().compareTo(other.hashCode())
    }

    override fun hashCode(): Int {
        return (this.start.year + this.start.month + this.start.dayOfMonth) *
                (this.endInclusive.year + this.endInclusive.month + this.endInclusive.dayOfMonth) * 31
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as DateRange

        if (start != other.start) return false
        if (endInclusive != other.endInclusive) return false

        return true
    }

    operator fun contains(date: MyDate2): Boolean {
        val start = LocalDate.of(start.year, start.month, start.dayOfMonth)
        val endInclusive = LocalDate.of(endInclusive.year, endInclusive.month, endInclusive.dayOfMonth)
        val checkDate= LocalDate.of(date.year, date.month, date.dayOfMonth)

        if((start.isEqual(checkDate) || start.isBefore(checkDate))
                && (endInclusive.isAfter(checkDate) || endInclusive.isEqual(checkDate)))
            return true
        return false
    }
}



data class MyDate2(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate2> {
        override fun compareTo(other: MyDate2): Int {
            return LocalDate.of(this.year, this.month, this.dayOfMonth)
                .compareTo(LocalDate.of(other.year, other.month, other.dayOfMonth))
    }
}


fun checkInRange(date: MyDate2, first: MyDate2, last: MyDate2): Boolean {
    return date in DateRange(first, last)
}


fun main(args: Array<String>) {
    val a = LocalDate.of(1988, 12, 12)
    val b = LocalDate.of(1989, 12, 12)
    val c = LocalDate.of(1990, 12, 12)


    println(c.isAfter(b)) //1990.12.12 идет после 1989.12.12
    println(a.isBefore(b)) //1988.12.12 идет до 1989.12.12


    val a1 = MyDate2(1988, 12, 12)
    val b1 = MyDate2(1978, 12, 12)
    val c1 = MyDate2(1990, 12, 12)
    println(checkInRange(b1, a1, c1)) //Проверка входит ли дата b1 в период a1 и c1

    val a11 = DateRange(a1, c1)
    val a12 = DateRange(a1, c1)

    println("a11 compareTo a12 = ${a11.compareTo(a12)}")
}