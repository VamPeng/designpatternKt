package org.vam

fun main() {
    val director = Director()

    val builderOne = ConcreteBuilderOne()
    val builderTwo = ConcreteBuilderTwo()

    director.construct(builderOne)
    val productOne = builderOne.getResult()
    productOne.show()

    director.construct(builderTwo)
    val productTwo = builderTwo.getResult()
    productTwo.show()

}

/**
 * 最终生成的产品
 */
class Product {
    val parts = mutableListOf<String>()
    fun add(part: String) {
        parts.add(part)
        println("add $part")
    }

    fun show() {
        println("product parts:")
        parts.forEach {
            println(it)
        }
    }
}

/**
 * 构造者
 */
abstract class Builder {
    abstract fun buildPartA()
    abstract fun buildPartB()
    abstract fun getResult(): Product
}

class ConcreteBuilderOne : Builder() {
    private val product = Product()
    override fun buildPartA() {
        product.add("partA")
    }

    override fun buildPartB() {
        product.add("partB")
    }

    override fun getResult(): Product {
        return product
    }

}

class ConcreteBuilderTwo : Builder() {
    private val product = Product()
    override fun buildPartA() {
        product.add("partA")
    }

    override fun buildPartB() {
        product.add("partB")
    }

    override fun getResult(): Product {
        return product
    }
}

/**
 * 指挥的角色
 */
class Director() {
    fun construct(builder: Builder) {
        builder.buildPartA()
        builder.buildPartB()
    }
}