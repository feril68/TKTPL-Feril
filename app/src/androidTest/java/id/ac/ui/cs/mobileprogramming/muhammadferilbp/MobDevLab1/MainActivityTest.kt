package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setUp() {
        val intent = Intent()
        mActivityTestRule.launchActivity(intent)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testLab2FerilTextIsDisplayed(){
        onView(withId(R.id.textView)).check(ViewAssertions.matches(withText("Lab 2 Feril")))
    }

    @Test
    fun testPhoneNumberValidatorTextIsDisplayed(){
        onView(withId(R.id.textView2)).check(ViewAssertions.matches(withSubstring("Phone Number Validator")))
    }

    @Test
    fun testButtonIsClickedAndInputEmptyTriggerFalseText(){
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.phoneNumberShow)).check(ViewAssertions.matches(withText("false")))
    }

    @Test
    fun testInputPhoneNumberWrongPatternThanClickButtonShowFalseText(){
        onView(withId(R.id.editTextPhone)).perform(replaceText("1231212"))
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.phoneNumberShow)).check(ViewAssertions.matches(withText("false")))
    }

    @Test
    fun testInputPhoneNumberPattern08xxxAndChar11or12ThanClickButtonShowTrueText(){
        onView(withId(R.id.editTextPhone)).perform(replaceText("082213137164"))
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.phoneNumberShow)).check(ViewAssertions.matches(withText("true")))
    }

    @Test
    fun testInputPhoneNumberPattern08xxxAndCharLessThan11ThanClickButtonShowFalseText(){
        onView(withId(R.id.editTextPhone)).perform(replaceText("0822131"))
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.phoneNumberShow)).check(ViewAssertions.matches(withText("false")))
    }

    @Test
    fun testInputPhoneNumberPattern08xxxAndCharMoreThan12ThanClickButtonShowFalseText(){
        onView(withId(R.id.editTextPhone)).perform(replaceText("08221313716412312"))
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.phoneNumberShow)).check(ViewAssertions.matches(withText("false")))
    }
}