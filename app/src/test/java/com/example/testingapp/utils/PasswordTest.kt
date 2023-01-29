package com.example.testingapp.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PasswordTest {

    lateinit var helper: Helper

    @Before
    fun setUp() {
        helper = Helper()
    }

    @Test
    fun validatePassword_blankInput_expectedRequired() {
        val result = helper.validatePassword("   ")
        assertEquals("Password is required field", result)
    }

    @Test
    fun validatePassword_2ChrInput_expectedRequired() {
        val result = helper.validatePassword("ab")
        assertEquals("Length of the password should be greater than 6", result)
    }

    @Test
    fun validatePassword_CorrectInput_expectedRequired() {
        val result = helper.validatePassword("123456")
        assertEquals("Valid", result)
    }

    @Test
    fun validatePassword_16ChrInput_expectedRequired() {
        val result = helper.validatePassword("123456123456123456")
        assertEquals("Length of the password be less than 15", result)
    }
}