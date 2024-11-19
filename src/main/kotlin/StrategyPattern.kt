package org.vam


/**
 * 19/11/2024 21:58
 * author: PengYH
 * description:策略模式
 */
fun main() {
    println("strategy pattern")

    val contextA = StrategyContext(StrategyA()).apply { contextInterface() }
    val contextB = StrategyContext(StrategyB()).apply { contextInterface() }
    val contextC = StrategyContext(StrategyC()).apply { contextInterface() }
}

abstract class Strategy {
    public abstract fun algorithmInterface()
}

class StrategyA : Strategy() {
    override fun algorithmInterface() {
        println("algorithmInterfaceA")
    }
}

class StrategyB : Strategy() {
    override fun algorithmInterface() {
        println("algorithmInterfaceB")
    }
}

class StrategyC : Strategy() {
    override fun algorithmInterface() {
        println("algorithmInterfaceC")
    }
}

class StrategyContext(val strategy: Strategy) {
    fun contextInterface() {
        strategy.algorithmInterface()
    }
}