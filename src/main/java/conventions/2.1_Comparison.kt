package conventions

import java.time.LocalDate

/**
Read about operator overloading to learn how different conventions for operations like ==, <, + work in Kotlin.
Add the function compareTo to the class MyDate to make it comparable.
After that the code below date1 < date2 will start to compile.

In Kotlin when you override a member, the modifier override is mandatory.
Reed {http://kotlinlang.org/docs/reference/operator-overloading.html}
 */

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
//    override fun compareTo(other: MyDate): Int {
//        return LocalDate.of(this.year, this.month, this.dayOfMonth)
//                .compareTo(LocalDate.of(other.year, other.month, other.dayOfMonth))
//    }
    override fun compareTo(other:MyDate): Int {
        if(this.year.compareTo(other.year) == 0) {
            if(this.month.compareTo(other.month) == 0) {
                return this.dayOfMonth.compareTo(other.dayOfMonth);
            }
            else {
                return this.month.compareTo(other.month);
            }
        }
        return this.year.compareTo(other.year);
    }

}

fun compare(date1: MyDate, date2: MyDate) = date1 >= date2


fun main(args: Array<String>) {
    val myDate1 = MyDate(1988, 7, 4)
    val myDate2 = MyDate(2016, 9, 18)
    val myDate3 = MyDate(1988, 7, 4)

    println(compare(myDate1,myDate2))
    println(compare(myDate1, myDate3))
}