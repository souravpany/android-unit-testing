package com.example.testingapp.utils

class Helper {

    fun isPallindrome(input: String): Boolean {

        var i = 0
        var j = input.length - 1
        var result = true

        while (i < j) {
            if (input[i] != input[j]) {
                result = false
                break
            }
            i++
            j--
        }

        return result

    }

    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }
        input.length < 6 -> {
            "Length of the password should be greater than 6"
        }
        input.length > 15 -> {
            "Length of the password be less than 15"
        }
        else -> {
            "Valid"
        }
    }
}