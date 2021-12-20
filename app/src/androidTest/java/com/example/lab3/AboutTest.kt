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
class AboutTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    private fun destroyCheck() = assertTrue(rule.scenario.state == Lifecycle.State.DESTROYED)

    @Test
    fun firstBack() {
        checkDisplay(R.id.firstActivity)
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun firstDoubleBack() {
        launchActivity<MainActivity>()
        openAbout()
        pressBackUnconditionally()
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun firstUp() {
        launchActivity<MainActivity>()
        openAbout()
        aboutUp()
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun secondBack() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.secondActivity)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun secondUp() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        openAbout()
        aboutUp()
        checkDisplay(R.id.secondActivity)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun thirdDoubleBack() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.thirdActivity)
        pressBackUnconditionally()
        checkDisplay(R.id.secondActivity)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun thirdUpBack() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        openAbout()
        aboutUp()
        checkDisplay(R.id.thirdActivity)
        pressBackUnconditionally()
        checkDisplay(R.id.secondActivity)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun thirdBackToFirst() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.thirdActivity)
        performClick(R.id.firstButton)
        firstBack()
    }

    @Test
    fun thirdUpToFirst() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        openAbout()
        aboutUp()
        checkDisplay(R.id.thirdActivity)
        performClick(R.id.firstButton)
        firstBack()
    }
}