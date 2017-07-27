package part2

/*
Objects with invoke() method can be invoked as a function. (Объект с методом invoke может быть вызван как функция)

You can add invoke extension for any class, but it's better not to overuse it:

fun Int.invoke() { println(this) }

1() //huh?..

Implement the function Invokable.invoke() so it would count a number of invocations.
*/

class Invokable {
    var numberOfInvocations: Int = 0
        private set

    operator fun invoke(): Invokable {
        numberOfInvocations++
        //println(numberOfInvocations ) //Отобразить сколько раз была вызвана фу
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()()()

operator fun Int.invoke() { println(this) }


fun main(args: Array<String>) {
    1() //Используем функцию invoke
   invokeTwice(Invokable())
}

