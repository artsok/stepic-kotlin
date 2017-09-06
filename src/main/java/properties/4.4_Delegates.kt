package properties

/*

Delegates

You may declare your own delegates. Implement the methods of the class 'EffectiveDate' so it can be delegated to.
Store only the time in milliseconds in 'timeInMillis' property.

Use the extension functions MyDate.toMillis() and Long.toDate().

Read {
https://kotlinlang.org/docs/reference/delegated-properties.html#property-delegate-requirements
http://www.kotlinlang.ru/docs/reference/delegated-properties.html
}
 */

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {


    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        println("$thisRef, спасибо за делегирование мне '${property.name}'!")
        return timeInMillis?.toDate() ?: MyDate(1990, 0, 0)
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        println("$value было присвоено значению '${property.name} в $thisRef.'")
        this.timeInMillis = value.toMillis()
    }
}

fun  Long.toDate():MyDate {
    val instant: Instant = Instant.ofEpochMilli(this)
    val date:LocalDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC)
    return MyDate(date.year, date.monthValue, date.dayOfMonth)
}

fun MyDate.toMillis(): Long? {
    return LocalDate.of(this.year, this.month, this.dayOfMonth).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()
}

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        if (this.year.compareTo(other.year) == 0) {
            if (this.month.compareTo(other.month) == 0) {
                return this.dayOfMonth.compareTo(other.dayOfMonth)
            } else {
                return this.month.compareTo(other.month)
            }
        }
        return this.year.compareTo(other.year)
    }


}


fun main(args: Array<String>) {
    val p:D = D()
    p.date = MyDate(2010, 9, 1)
    println(p.date)
}