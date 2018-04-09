package jpoint2018

import java.util.stream.Collectors


/*
В данной задаче почтовый адрес представляет собой строку вида login@domain, где

    login — это непустая строка, состоящая из строчных и прописных букв английского алфавита, точек и знаков плюс, начинающаяся с буквы,
    domain — это непустая последовательность из строчных и прописных букв английского алфавита и точек, причем точки разбивают эту последовательность на непустые строки, состоящие только из букв.

При сравнении почтовых адресов регистр букв игнорируется (адреса woRk@woRK.Ru и WORk@work.Ru эквивалентны).

Если домен почтового адреса равен gmail.com для него выполняются еще два правила:

    все точки в login игнорируются (адреса work@gmail.com и w.o.r.k@gmail.com эквивалентны),
    если в login есть один или более знаков плюс, все что следует за самым левым плюсом игнорируется (адреса work@gmail.com и work+from+home@gmail.com эквивалентны).

Вам будет заданы n почтовых адресов, требуется разбить их на группы эквивалентных адресов.

======
Входные данные
В первой строке следует целое положительное число n (1 ≤ n ≤ 2·104) — количество почтовых адресов.
В следующих n строках заданы сами адреса по одному в строке. Гарантируется, что они корректны. Все заданные адреса различны. Длина почтовых адресов не менее 3 и не более 100 символов.
======

======
Выходные данные
В первую строку выведите одно число k — количество групп эквивалентных адресов.
В следующих k строках выведите сами группы по одной группе в строке. Сначала должно идти целое число — размер текущей группы,
а затем через пробел сами почтовые адреса, которые принадлежат в текущей группе. Разрешается выводить группы и адреса в каждой группе в произвольном порядке.
Выводите почтовые адреса именно так, как они заданы во входных данных. Каждый адрес из входных данных должен принадлежать ровно одной группе.
=====
 */

const val testData = "6\nDEVELOPER.@gmail.com\nt+es+ter@GMAIL.COM\nT@bmail.com\na@gmail.com.ru\nD.eveloper@Gmail.Com\na+b@gmail.com.ru"



data class LoginDomain(var unModified: String, var modified: String)

fun main(args: Array<String>) {
    val splitText = readLine()!!.split("\n").stream().skip(1).map { //change 'readLine()!!' to testData
        val login = it.split('@').first().toLowerCase()
        LoginDomain(it, makeModified(login, it))
    }.collect(Collectors.toList()).groupBy { it.modified }
    println(splitText.size)
    splitText.onEach {
        println("${it.value.size} ${it.value.joinToString(separator = " ", transform = LoginDomain::unModified)}")
    }
}

fun makeModified(login: String, line: String): String {
    var lowerCaseText = line.toLowerCase()

    if (Regex("@gmail.com$") in lowerCaseText) {
        lowerCaseText = login.replace(".", "")

        if ("+" in lowerCaseText) {
            lowerCaseText = lowerCaseText.substringBefore("+")
        }
        lowerCaseText.plus("@gmail.com")
    }
    return lowerCaseText
}
