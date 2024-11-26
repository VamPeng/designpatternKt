package org.vam

/**
 * 门面模式
 * 模拟一个系统，该系统有3个子系统，通过一个门面类来统一调用
 */
fun main() {
    val facade = FacadeSystem()
    println()
    facade.methodOne()
    println()
    facade.methodTwo()
}

class FacadeSystem{

    private val systemOne = SystemOne()
    private val systemTwo = SystemTwo()
    private val systemThree = SystemThree()

    fun methodOne(){
        systemOne.methodOne()
        systemTwo.methodOne()
        systemThree.methodOne()
    }

    fun methodTwo(){
        systemOne.methodTwo()
        systemTwo.methodTwo()
        systemThree.methodTwo()
    }

}

class SystemOne{
    fun methodOne(){
        println("System one.methodOne")
    }
    fun methodTwo(){
        println("System one.methodTwo")
    }
}

class SystemTwo{
    fun methodOne(){
        println("System two.methodOne")
    }
    fun methodTwo(){
        println("System two.methodTwo")
    }
}

class SystemThree{
    fun methodOne(){
        println("System three.methodOne")
    }
    fun methodTwo(){
        println("System three.methodTwo")
    }
}