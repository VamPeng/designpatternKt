package org.vam

/**
 * 18/11/2024 22:43
 * author: PengYH
 * description: 简单工厂模式
 */
fun main() {
    val list = listOf("+", "-", "*", "/")
    list.forEach {
        println(
            OperationFactory
                .createOperation(it).also { operate -> operate.numberOne = 1.0;operate.numberTwo = 2.0 }
                .getResult()
        )
    }
}

object OperationFactory {
    fun createOperation(operate: String): Operation = when (operate) {
        "+" -> OperationAdd()
        "-" -> OperationSub()
        "*" -> OperationMul()
        "/" -> OperationDiv()
        else -> throw IllegalArgumentException("不支持该运算符")
    }
}

open class Operation {

    var numberOne: Double = 0.0

    var numberTwo: Double = 0.0

    open fun getResult(): Double = 0.0
}

class OperationAdd : Operation() {
    override fun getResult() = numberOne + numberTwo
}

class OperationSub : Operation() {
    override fun getResult() = numberOne - numberTwo
}

class OperationMul : Operation() {
    override fun getResult() = numberOne * numberTwo
}

class OperationDiv : Operation() {
    override fun getResult(): Double {
        return if (numberTwo == 0.0) {
            throw IllegalArgumentException("除数不能为0")
        } else {
            numberOne / numberTwo
        }
    }
}