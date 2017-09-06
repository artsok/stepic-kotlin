package conventions


import conventions.TimeInterval1.*
import java.time.LocalDate



data class MyDate6(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate6>{

    override fun toString(): String {
        return "year=$year, month=$month, dayOfMonth=$dayOfMonth"
    }

    override fun compareTo(other: MyDate6): Int {
        return LocalDate.of(this.year, this.month, this.dayOfMonth)
                .compareTo(LocalDate.of(other.year, other.month, other.dayOfMonth))
    }
}

enum class TimeInterval1 {
    YEAR,
    WEEK,
    DAY;
    var value:Int = 1

    operator fun times(param:Int):TimeInterval1 {
        value = param
        when(this) {
            YEAR -> return YEAR
            WEEK -> return WEEK
            DAY -> return DAY
        }
    }
}

operator fun MyDate6.plus(timeInterval: TimeInterval1): MyDate6 = addTimeIntervals(timeInterval)

fun MyDate6.addTimeIntervals(timeInterval: TimeInterval1): MyDate6 {

    when (timeInterval) {
        YEAR -> {
            return MyDate6(this.year + timeInterval.value, this.month, this.dayOfMonth)
        }
        WEEK -> {
            var pointDays = 0
            var pointMonth = 0
            if(timeInterval.value * 7 > 31) {
                pointDays = timeInterval.value * 7 - 31
                pointMonth = 1
                return MyDate6(this.year, pointMonth, pointDays)
            }
            else if(this.dayOfMonth  + timeInterval.value * 7 > 31 ) {
                pointDays = this.dayOfMonth  + timeInterval.value * 7 - 31
                pointMonth = 1
                return MyDate6(this.year, pointMonth, pointDays)
            }
            return MyDate6(this.year, this.month, this.dayOfMonth  + timeInterval.value * 7)
        }
        DAY -> {
            var pointDays = 0
            var pointMonth = 0
            if(this.dayOfMonth  + timeInterval.value > 31 ) {
                pointDays = this.dayOfMonth  + timeInterval.value  - 31
                pointMonth = 1
                return MyDate6(this.year, pointMonth, pointDays)
            }
            return MyDate6(this.year, this.month, this.dayOfMonth  + timeInterval.value)
        }
    }

}

fun task1(today: MyDate6): MyDate6 {
    return today + YEAR + WEEK //2014 5 1
}

fun task2(today: MyDate6): MyDate6 {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

fun task3(today: MyDate6): MyDate6 {
    return today + DAY * 5
}

fun main(args: Array<String>) {
    /*
    Даты для проверки:
2014 5 1 YEAR 1
2015 5 1 WEEK 1
2014 0 1 YEAR 2
2016 0 1 WEEK 3
2016 0 22 DAY 5
     */
    println(task3(MyDate6(2016, 0 ,22)))

}