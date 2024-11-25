package org.vam


fun main(args: Array<String>) {
    val realConcrete = ConcreteComponent()

    println("type one.")
    // 方式一，各个组件迭代持有
    val decoratorA = ConcreteDecoratorA(realConcrete)
    val decoratorB = ConcreteDecoratorB(decoratorA)
    decoratorB.operation()

    println("type second.")
    // 方式二，各个组件只持有具体实例瑞祥
    val decoratorAA = ConcreteDecoratorA(realConcrete)
    decoratorAA.operation()
    val decoratorBB = ConcreteDecoratorB(realConcrete)
    decoratorBB.operation()

}

/**
 * 抽象装饰接口
 */
interface Component {
    /**
     * 接口定义行为
     */
    abstract fun operation()
}

/**
 * 接口具体执行对象
 */
class ConcreteComponent : Component {
    override fun operation() {
        println("具体对象操作")
    }
}

/**
 * 接口开放扩展行为
 */
abstract class Decorator(val component: Component) : Component

/**
 * 接口扩展行为A
 */
class ConcreteDecoratorA(component: Component) : Decorator(component) {

    fun addBehavior() {
        println("具体装饰对象A的操作")
    }

    override fun operation() {
        addBehavior()
        component.operation()
    }
}

/**
 * 接口扩展行为B
 */
class ConcreteDecoratorB(component: Component) : Decorator(component) {

    fun addBehavior() {
        println("具体装饰对象B的操作")
    }

    override fun operation() {
        addBehavior()
        component.operation()
    }
}