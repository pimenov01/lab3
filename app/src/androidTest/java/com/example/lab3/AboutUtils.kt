package com.example.lab3

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert

private fun openAboutViaOptions() {
    openContextualActionModeOverflowMenu()
    onView(withText(R.string.title_about))
        .perform(click())
}

fun openAbout() = openAboutViaOptions()

fun checkDisplay(viewId: Int) {
    onView(withId(viewId)).check(matches(isDisplayed()))
}
fun performClick(viewId: Int) {
    onView(withId(viewId)).perform(click())
}
fun aboutUp() {
    onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
        .perform(click())
}
