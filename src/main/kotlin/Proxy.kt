package org.vam

fun main() {
    val proxy = Proxy()
    proxy.request()
}

interface Subject {
    fun request()
}

class RealSubject : Subject {
    override fun request() {
        println("RealSubject.request")
    }
}

class Proxy() : Subject {

    private val realSubject: Subject = RealSubject()
    override fun request() {
        println("Proxy.request")
        realSubject.request()
    }

}