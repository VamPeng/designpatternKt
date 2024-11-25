package org.vam


fun main() {

    val leiFengFactory = UndergraduateFactory()
    val leiFeng = leiFengFactory.createLeiFeng()

    leiFeng.buyRice()
    leiFeng.sweep()
    leiFeng.wash()

}

abstract class LeiFengFactory {
    abstract fun createLeiFeng(): LeiFeng
}

class UndergraduateFactory : LeiFengFactory() {
    override fun createLeiFeng(): LeiFeng {
        return Undergraduate()
    }
}

class SocialFactory : LeiFengFactory() {
    override fun createLeiFeng(): LeiFeng {
        return SocialPerson()
    }
}

abstract class LeiFeng {
    abstract fun buyRice()
    abstract fun sweep()
    abstract fun wash()
}

class Undergraduate : LeiFeng() {
    override fun buyRice() {
        println("大学生 Rice")
    }

    override fun sweep() {
        println("大学生 sweep")
    }

    override fun wash() {
        println("大学生 wash")
    }
}

class SocialPerson : LeiFeng() {
    override fun buyRice() {
        println("社会人 Rice")
    }

    override fun sweep() {
        println("社会人 sweep")
    }

    override fun wash() {
        println("社会人 wash")
    }
}