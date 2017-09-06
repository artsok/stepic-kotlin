//package part5
//
//
///*
//Пример: Типобезопасные строители
//https://try.kotlinlang.org/#/Examples/Longer%20examples/HTML%20Builder/HTML%20Builder.kt
//http://kotlinlang.ru/docs/reference/type-safe-builders.html
//
//
//
// */
//fun main(args: Array<String>) {
//    val result =
//            html {
//                head {
//                    title { +"XML encoding with Kotlin" }
//                }
//                body {
//                    h1 { +"XML encoding with Kotlin" }
//                    p { +"this format can be used as an alternative markup to XML" }
//
//                    // an element with attributes and text content
//                    a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }
//
//                    // mixed content
//                    p {
//                        +"This is some"
//                        b { +"mixed" }
//                        +"text. For more see the"
//                        a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }
//                        +"project"
//                    }
//                    p { +"some text" }
//
//                    // content generated from command-line arguments
//                    p {
//                        +"Command line arguments were:"
//                        ul {
//                            for (arg in listOf("Test1", "Test2", "Test3"))
//                                li { +arg }
//                        }
//                    }
//                }
//            }
//    println(result)
//}
//
//interface Element {
//    fun render(builder: StringBuilder, indent: String)
//}
//
//class TextElement(val text: String) : Element {
//    override fun render(builder: StringBuilder, indent: String) {
//        builder.append("$indent$text\n")
//    }
//}
//
//abstract class Tag(val name: String) : Element {
//    val children = arrayListOf<Element>()
//    val attributes = hashMapOf<String, String>()
//
//    /**
//     * Инициализация тэг.
//     */
//    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
//        tag.init()
//        children.add(tag)
//        return tag
//    }
//
//    override fun render(builder: StringBuilder, indent: String) {
//        builder.append("$indent<$name${renderAttributes()}>\n")
//        for (c in children) {
//            c.render(builder, indent + "  ")
//        }
//        builder.append("$indent</$name>\n")
//    }
//
//    private fun renderAttributes(): String? {
//        val builder = StringBuilder()
//        for (a in attributes.keys) {
//            builder.append(" $a=\"${attributes[a]}\"")
//        }
//        return builder.toString()
//    }
//
//
//    override fun toString(): String {
//        val builder = StringBuilder()
//        render(builder, "")
//        return builder.toString()
//    }
//}
//
///*
//Абстрактный класс, унаследован от абстрактного класса Tag.
//Перегружен унарный оператор "+"
//В коллекцию children, которая находится в классе Tag, добавляется элемент TextElement унаследованный от Element
//children = arrayListOf<Element>()
// */
//abstract class TagWithText(name: String) : Tag(name) {
//    operator fun String.unaryPlus() {
//        children.add(TextElement(this))
//    }
//}
//
////HTML — это класс, который описывает тэг <html>, т.е. он определяет потомков, таких как <head> и <body>.
//class HTML() : TagWithText("html") {
//    fun head(init: Head.() -> Unit) = initTag(Head(), init)
//
//    //Единственное отличие в том, что они добавляют отстроенные экземпляры в коллекцию children заключающего экземпляра HTML
//    fun body(init: Body.() -> Unit) = initTag(Body(), init)
//}
//
//class Head() : TagWithText("head") {
//    fun title(init: Title.() -> Unit) = initTag(Title(), init)
//}
//
//class Title() : TagWithText("title")
//
//abstract class BodyTag(name: String) : TagWithText(name) {
//    fun b(init: B.() -> Unit) = initTag(B(), init)
//    fun p(init: P.() -> Unit) = initTag(P(), init)
//    fun h1(init: H1.() -> Unit) = initTag(H1(), init)
//    fun ul(init: UL.() -> Unit) = initTag(UL(), init)
//    fun a(href: String, init: A.() -> Unit) {
//        val a = initTag(A(), init)
//        a.href = href
//    }
//}
//
//class Body() : BodyTag("body")
//
//class UL() : BodyTag("ul") {
//    fun li(init: LI.() -> Unit) = initTag(LI(), init)
//}
//
//class B() : BodyTag("b")
//class LI() : BodyTag("li")
//class P() : BodyTag("p")
//class H1() : BodyTag("h1")
//
//class A() : BodyTag("a") {
//    public var href: String
//        get() = attributes["href"]!!
//        set(value) {
//            attributes["href"] = value
//        }
//}
//
//
///*
//Эта функция принимает один параметр-функцию под названием init.
//Тип этой функции: HTML.() -> Unit — функциональный тип с объектом-приёмником.
//Это значит, что нам нужно передать экземпляр класса HTML (приёмник) в функцию,
//и мы сможем обращаться к членам объекта в теле этой функции.
//Обращение происходит через ключевое слово this:
// */
//fun html(init: HTML.() -> Unit): HTML {
//    val html = HTML()
//    html.init()
//    return html
//}