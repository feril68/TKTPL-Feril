package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1

import org.junit.Test

import org.junit.Assert.*

class PhoneNumberValidatorTest {

    @Test
    fun `empty phone number is false`() {
        val result: Boolean = PhoneNumberValidator.phoneNumberValidation("")
        assertFalse(result)
    }

    @Test
    fun `not pattern 08xxx and max char phone number is false`() {
        val result: Boolean = PhoneNumberValidator.phoneNumberValidation("263718")
        assertFalse(result)
    }

    @Test
    fun `pattern 08xxx and max char 11 or 12 phone number is true`() {
        val result: Boolean = PhoneNumberValidator.phoneNumberValidation("082213131313")
        assertTrue(result)
    }

    @Test
    fun `pattern 08xxx and char less than 11 phone number is false`() {
        val result: Boolean = PhoneNumberValidator.phoneNumberValidation("082213")
        assertFalse(result)
    }
    @Test
    fun `pattern 08xxx and char more than 12 phone number is false`() {
        val result: Boolean = PhoneNumberValidator.phoneNumberValidation("0822131313131311313")
        assertFalse(result)
    }
}