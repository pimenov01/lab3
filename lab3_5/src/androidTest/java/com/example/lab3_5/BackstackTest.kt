package com.example.lab3_5

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
    fun exitFromFrag1() { // 1 b> exit
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun exitFromFrag1_Frag2_2() { // 1 -> 2 b> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment1)
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
        checkDisplay(R.id.fragment2)
        performClick(R.id.firstButton)
        checkDisplay(R.id.fragment1)
        exitFromFrag1()
    }

    @Test
    fun exitFromFrag1_Frag3_2() { // 1 -> 2 -> 3 -> 2 b> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        performClick(R.id.secondButton)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment1)
        exitFromFrag1()
    }
}