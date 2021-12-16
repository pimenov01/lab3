package com.example.lab3_5

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun fromFirst() {
        checkDisplay(R.id.fragment1)
        openAbout() // 1 -> About
        checkDisplay(R.id.activity_about)

        aboutUp()
        checkDisplay(R.id.fragment1)

        performClick(R.id.secondButton) // 1 -> 2
        checkDisplay(R.id.fragment2)
    }

    @Test
    fun fromSecond() {
        performClick(R.id.secondButton)
        checkDisplay(R.id.fragment2)

        openAbout()
        checkDisplay(R.id.activity_about) // 2 -> About
        aboutUp()
        checkDisplay(R.id.fragment2)

        performClick(R.id.firstButton) // 2 -> 1
        checkDisplay(R.id.fragment1)
        performClick(R.id.secondButton)
        checkDisplay(R.id.fragment2)

        performClick(R.id.thirdButton) // 2 -> 3
        checkDisplay(R.id.fragment3)
    }

    @Test
    fun fromThird() {
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        checkDisplay(R.id.fragment3)

        openAbout()
        checkDisplay(R.id.activity_about) // 3 -> About
        aboutUp()
        checkDisplay(R.id.fragment3)

        performClick(R.id.secondButton) // 3 -> 2
        checkDisplay(R.id.fragment2)
        performClick(R.id.thirdButton)
        checkDisplay(R.id.fragment3)

        performClick(R.id.firstButton) // 3 -> 1
        checkDisplay(R.id.fragment1)
    }
}