package conventions

/*
Read about destructuring declarations and make the following code compile by adding one word.

Read {http://kotlinlang.ru/docs/reference/multi-declarations.html}
 */

data class MyDate7(val year: Int, val month: Int, val dayOfMonth: Int)

fun isLeapDay(date: MyDate): Boolean {

    val (year, month, dayOfMonth) = date

    // 29 February of a leap year
    return year % 4 == 0 && month == 2 && dayOfMonth == 29
}