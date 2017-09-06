package builders

/*
Html builder

1. Fill the table with the proper values from the product list.

data class Product(val description: String, val price: Double, val popularity: Int)


2. Color the table like a chess board (using getTitleColor() and getCellColor() functions above).
Pass a color as an argument to the functions tr, td.

По моему мнению, задание содержит ошибку. Правильне сделать, метод getCellColor для td, а метод getTitleColor для tr
 */

data class Product(val description: String, val price: Double, val popularity: Int)


class Attribute(val name: String, val value: String)


open class Tag(val name: String) {
    val children = arrayListOf<Tag>()
    val attributes = hashMapOf<String, String>()


    fun <T : Tag> T.set(name: String, value: String?): T? {
        return null
    }

    fun <T : Tag> Tag.doInit(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    fun text(s: Any): Text? {
        //println(s)
        children.add(Text(s.toString()))
        return Text(s.toString())
    }

    open fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent<$name${renderAttributes()}>\n")
        for (c in children) {
            c.render(builder, indent + "  ")
        }
        builder.append("$indent</$name>\n")
    }

    private fun renderAttributes(): String? {
        val builder = StringBuilder()
        for (a in attributes.keys) {
            builder.append(" $a=\"${attributes[a]}\"")
        }
        return builder.toString()
    }


    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}




class Html : Tag("html") {

    fun table(init: Table.() -> Unit): Table {
        return doInit(Table(), init)
    }

    fun center(init: Center.() -> Unit): Center  = doInit(Center(), init)

}

class Center : Tag("center")

class Table : Tag("table") {
    fun tr(color: String? = null, init: TR.() -> Unit): TR {
        return doInit(TR(), init)
    }
}

class TR : Tag("tr") {
    fun td(color: String? = null, align : String = "left", init : TD.() -> Unit): TD {
        println("Color " + color)
        return doInit(TD(), init)
    }
}

class TD : Tag("td")

class Text(val text: String) : Tag("b") {

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init()
    return html
}




fun renderProductTable(): String {
    return html {
        table {
            tr {
                td (getTitleColor(), "left", {
                    text("Price")
                })
                this.td (getTitleColor()){
                    text("Price")
                }
                td(getTitleColor()) {
                    text("Popularity")
                }
            }
            val products = getProducts()
            products.forEachIndexed  {
                idx, it ->
                tr(getCellColor(idx, 1))  {
                    td {
                        text(it.description)
                    }
                    td {
                        text(it.price)
                    }
                    td {
                        text(it.popularity)
                    }
                }
            }

        }
    }.toString()
}




fun main(args: Array<String>) {
    println(renderProductTable())
}

fun getProducts(): List<Product> {
    return listOf(Product("Test", 34.3, 10), Product("Test1", 34.3, 10));
}

fun getTitleColor() = "#b9c9fe"

fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"