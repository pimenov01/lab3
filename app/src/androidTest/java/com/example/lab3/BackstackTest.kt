package com.example.lab3

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackstackTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    private fun destroyCheck() = assertTrue(rule.scenario.state == Lifecycle.State.DESTROYED)

    @Test
    fun fromFirst() { // 1 b> exit
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun fromSecondBack() { // 1 -> 2 b> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        pressBackUnconditionally()
        checkDisplay(R.id.firstActivity)
        fromFirst()
    }

    @Test
    fun fromSecond() { // 1 -> 2 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.firstButton)
        fromFirst()
    }

    @Test
    fun fromThird() { // 1 -> 2 -> 3 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        performClick(R.id.firstButton)
        fromFirst()
    }

    @Test
    fun fromThirdBack() { // 1 -> 2 -> 3 b> 2 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        pressBackUnconditionally()
        checkDisplay(R.id.secondActivity)
        performClick(R.id.firstButton)
        checkDisplay(R.id.firstActivity)
        fromFirst()
    }

    @Test
    fun fromThirdViaSecond() { // 1 -> 2 -> 3 -> 2 b> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        performClick(R.id.secondButton)
        pressBackUnconditionally()
        checkDisplay(R.id.firstActivity)
        fromFirst()
    }
}