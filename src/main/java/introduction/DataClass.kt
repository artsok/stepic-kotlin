package introduction

data class DataJ(val str:String) {

    override fun toString(): String {
        return "Перегрузили функцию toString" + super.toString()
    }
}