package com.example.coolcalc

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun two_multiplied_by_two_is_4() {
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.multiply)).perform(click())
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.evaluate)).perform(click())
        onView(withText("4.0")).check(matches(isDisplayed()))
    }

    @Test
    fun clear_screen() {
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.multiply)).perform(click())
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.clear)).perform(click())
        onView(withText("")).check(matches(isDisplayed()))
    }

    @Test
    fun add_zero_if_period_clicked_before_number_value() {
        onView(withId(R.id.decimal)).perform(click())
        onView(withText("0.")).check(matches(isDisplayed()))
    }
}