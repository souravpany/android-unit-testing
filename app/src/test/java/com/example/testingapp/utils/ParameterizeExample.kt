package com.example.testingapp.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizeExample(val input: String, val expectedResult: Boolean) {

    @Test
    fun isPallindrome() {
        val helper = Helper()
        val result = helper.isPallindrome(input)
        Assert.assertEquals(expectedResult, result)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is pallindrome - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }

}