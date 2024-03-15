package org.example

import com.biped.automator.core.AutomatorRunner
import com.biped.automator.core.Scenario

fun main() {
    println("Hello World!")
    AutomatorTestSuite().printMe()
}

@Scenario(1)
@AutomatorRunner
class MyTestClass(){
    fun blabla(){
        print("haha")
    }
}

@Scenario(2)
@AutomatorRunner
class OtherMyTestClass(){
    fun blabla(){
        print("haha")
    }
}

@Scenario(3)
@AutomatorRunner
class OneMoreMyTestClass(){
    fun blabla(){
        print("haha")
    }
}