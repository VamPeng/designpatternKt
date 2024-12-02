package org.vam


fun main() {
    val subject = ConcreteSubject()
    val observer = ConcreteObserver()
    subject.attach(observer)

    subject.state = "hello"
    subject.notifyUpdate()
}

interface ISubject {

    fun attach(observer: Observer)
    fun detach(observer: Observer)

    fun notifyUpdate()

}

class ConcreteSubject : ISubject {
    val observers = mutableListOf<Observer>()
    var state: String = ""
    override fun attach(observer: Observer) {
        observers.add(observer)
    }

    override fun detach(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyUpdate() {
        val iterator = observers.iterator()
        while (iterator.hasNext()){
            val next = iterator.next()
            next.update(state)
        }
    }

}

interface Observer {

    fun update(value: Any)

}

class ConcreteObserver : Observer {

    override fun update(value: Any) {
        println("update $value")
    }

}