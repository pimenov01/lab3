package com.example.lab3

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches

@RunWith(AndroidJUnit4::class)
class BackstackTest {
/*
    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    private fun destroyCheck() = assertTrue(rule.scenario.state == Lifecycle.State.DESTROYED)*/

    @Test
    fun exitFromFrag1() { // 1 b> exit
        //pressBackUnconditionally()
        //destroyCheck()
        launchActivity<MainActivity>()
        onView(withId(R.id.firstActivity)).check(matches(isDisplayed()))
    }
/*
    @Test
    fun exitFromFrag1_Frag2_2() { // 1 -> 2 b> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        pressBackUnconditionally()
        checkDisplay(R.id.firstActivity)
        exitFromFrag1()
    }

    @Test
    fun exitFromFrag1_Frag2_1() { // 1 -> 2 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.firstButton)
        exitFromFrag1()
    }

    @Test
    fun exitFromFrag1_Frag3_1() { // 1 -> 2 -> 3 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        performClick(R.id.firstButton)
        exitFromFrag1()
    }

    @Test
    fun exitFromFrag1_Frag3_4() { // 1 -> 2 -> 3 b> 2 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        pressBackUnconditionally()
        checkDisplay(R.id.secondActivity)
        performClick(R.id.firstButton)
        checkDisplay(R.id.firstActivity)
        exitFromFrag1()
    }

    @Test
    fun exitFromFrag1_Frag3_2() { // 1 -> 2 -> 3 -> 2 b> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        performClick(R.id.secondButton)
        pressBackUnconditionally()
        checkDisplay(R.id.firstActivity)
        exitFromFrag1()
    }*/
}