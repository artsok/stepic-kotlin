package introduction

fun eval(expr: Expr): Int =
        when (expr) {
            is Num -> expr.value
            is Sum -> eval(expr.left)  + eval(expr.right)
            else -> throw IllegalArgumentException("Unknown expression")
        }

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun main(args: Array<String>) {
    val a:Num = Num(1)


    var b:Sum = Sum(Num(1), Num(3))

    print(eval(b))

}