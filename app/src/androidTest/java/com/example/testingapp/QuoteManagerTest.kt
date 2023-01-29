package com.example.testingapp

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.testingapp.data.Quote
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    private lateinit var quoteManager: QuoteManager
    private lateinit var context: Context

    @Before
    fun setUp() {
        quoteManager = QuoteManager()
        context = ApplicationProvider.getApplicationContext()
    }

    @Test(expected = FileNotFoundException::class)
    fun popularQuoteFromAssets() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.popularQuoteFromAssets(context, "")
    }

    @Test
    fun popularQuoteFromAssets_ValidJSON_expected_count() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.popularQuoteFromAssets(context, "quote.json")
        assertEquals(10, quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_expected_CorrectQuote() {

        //Arrange
        quoteManager.populateQuotes(
            arrayOf(
                Quote(text = "This is the first quote", author = "1"),
                Quote(text = "This is the second quote", author = "2"),
                Quote(text = "This is the third quote", author = "3")
            )
        )

        //Act
        val quote = quoteManager.getPreviousQuote()

        //Assert
        assertEquals("1", quote.author)

    }

    @Test
    fun testNextQuote_expected_CorrectQuote() {

        //Arrange
        quoteManager.populateQuotes(
            arrayOf(
                Quote(text = "This is the first quote", author = "1"),
                Quote(text = "This is the second quote", author = "2"),
                Quote(text = "This is the third quote", author = "3")
            )
        )

        //Act
        val quote = quoteManager.getNextQuote()

        //Assert
        assertEquals("2", quote.author)

    }
}