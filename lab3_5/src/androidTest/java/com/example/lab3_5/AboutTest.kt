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
class AboutTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    private fun destroyCheck() = assertTrue(rule.scenario.state == Lifecycle.State.DESTROYED)

    @Test
    fun firstBack() {
        checkDisplay(R.id.fragment1)
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun frag1_back() {
        launchActivity<MainActivity>()
        openAbout()
        pressBackUnconditionally()
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun frag1_up() {
        //launchActivity<MainActivity>()
        openAbout()
        aboutUp()
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun frag2_back() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.fragment2)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun frag2_up() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        openAbout()
        aboutUp()
        checkDisplay(R.id.fragment2)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun frag3_back_back() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.fragment3)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment2)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun frag3_up_back() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        openAbout()
        aboutUp()
        checkDisplay(R.id.fragment3)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment2)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun frag3_back_toFirst() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.fragment3)
        performClick(R.id.firstButton)
        firstBack()
    }

    @Test
    fun frag3_up_toFirst() {
        launchActivity<MainActivity>()
        performClick(R.id.secondButton)
        performClick(R.id.thirdButton)
        openAbout()
        aboutUp()
        checkDisplay(R.id.fragment3)
        performClick(R.id.firstButton)
        firstBack()
    }
}