package com.example.lab3

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecreateTest {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    private fun rotateScreen() {
        rule.scenario.onActivity {
            it.apply {
                requestedOrientation = (requestedOrientation + 1) % 2
            }
        }
        Thread.sleep(1000)
    }


    @Test
    fun fromFirst() {
        checkDisplay(R.id.firstActivity)
        rotateScreen()
        checkDisplay(R.id.firstActivity)
    }

    @Test
    fun fromSecond3() {
        performClick(R.id.secondButton)
        rotateScreen()
        checkDisplay(R.id.secondActivity)
        performClick(R.id.thirdButton)
        checkDisplay(R.id.thirdActivity)
    }

    @Test
    fun fromSecond1() {
        performClick(R.id.secondButton)
        rotateScreen()
        checkDisplay(R.id.secondActivity)
        performClick(R.id.firstButton)
        checkDisplay(R.id.firstActivity)
    }

    @Test
    fun fromThird1() {
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        rotateScreen()
        checkDisplay(R.id.thirdActivity)
        performClick(R.id.firstButton)
        checkDisplay(R.id.firstActivity)
    }

    @Test
    fun fromThird2() {
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        rotateScreen()
        checkDisplay(R.id.thirdActivity)
        performClick(R.id.secondButton)
        checkDisplay(R.id.secondActivity)
    }


}