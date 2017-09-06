package conventions

import conventions.TimeInterval.YEAR
import conventions.TimeInterval.DAY
import conventions.TimeInterval.WEEK
import java.time.LocalDate


/*
Implement a kind of date arithmetic. Support adding years, weeks and days to a date. You could be able to write the code
like this: date + YEAR * 2 + WEEK * 3 + DAY * 15.

At first, add an extension function 'plus()' to MyDate, taking a TimeInterval as an argument.
Use an utility function MyDate.addTimeIntervals().

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
...
}

Then, try to support adding several time intervals to a date. You may need an extra class.

Read {http://kotlinlang.org/docs/reference/operator-overloading.html}
 */

data class MyDate5(val year:Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate5>{

    var zero = false
    var zeroHashSet = HashSet<String>()

    fun isZero(str:String,int:Int):Int {
        when(str) {
            "YEAR" -> {
                if(int == 0) {
                    zeroHashSet.add("YEAR")
                    return 1
                }
            }
            "MONTH" -> {
                if(int == 0) {
                    zeroHashSet.add("MONTH")
                    return 1
                }
            }
            "DAY" -> {
                if(int == 0) {
                    zeroHashSet.add("DAY")
                    return 1
                }
            }
        }
        return int
    }

    fun correctData(str:String,int:Int):Int {
        if(zeroHashSet.contains(str)) {
            return int - 1
        }
        return int
    }

    override fun toString(): String {
        return "year=$year, month=$month, dayOfMonth=$dayOfMonth"
    }

    override fun compareTo(other: MyDate5): Int {
        return LocalDate.of(this.year, this.month, this.dayOfMonth)
                .compareTo(LocalDate.of(other.year, other.month, other.dayOfMonth))
    }

    operator fun plus(timeInterval:TimeInterval): MyDate5 = addTimeIntervals(timeInterval)

}

enum class TimeInterval {
    YEAR,
    WEEK,
    DAY;
    var value:Int = 1

    operator fun times(param:Int):TimeInterval {
        value = param
        when(this) {
            YEAR -> return YEAR
            WEEK -> return WEEK
            DAY -> return DAY
        }
    }
}


fun MyDate5.addTimeIntervals(timeInterval: TimeInterval): MyDate5 {
    var date:LocalDate
    when (timeInterval) {
        YEAR -> {
            return MyDate5(this.year + timeInterval.value, this.month, this.dayOfMonth)
        }
        WEEK -> {
            date = LocalDate
                    .of(isZero("YEAR", this.year), isZero("MONTH",this.month), isZero("DAY",this.dayOfMonth))
                    .plusWeeks(timeInterval.value.toLong())


            return MyDate5(correctData("YEAR",date.year), correctData("MONTH", date.monthValue),
                    correctData("DAY", date.dayOfMonth))
        }
        DAY -> {
            date = LocalDate
                    .of(isZero("YEAR", this.year), isZero("MONTH",this.month), isZero("DAY",this.dayOfMonth))
                    .plusDays(timeInterval.value.toLong())

            //return MyDate5(date.year, date.monthValue, date.dayOfMonth)

            return MyDate5(correctData("YEAR",date.year), correctData("MONTH", date.monthValue),
                    correctData("DAY", date.dayOfMonth))
        }
    }
}


fun main(args: Array<String>) {


    val date:MyDate5 = MyDate5(1988, 1, 0)
    println(date + YEAR + WEEK)
    //println(date + YEAR * 2 + WEEK * 3 + DAY * 15)
}