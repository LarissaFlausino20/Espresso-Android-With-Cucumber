package com.example.myapplication10

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class TesteFormatoBasico {

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testeLogin() {
        onView(withText("Aplicativo de Testes")).check(matches(isDisplayed()))
        onView(withId(R.id.field_email)).perform(typeText("qazando@gmail.com"))
        closeSoftKeyboard()
        onView(withId(R.id.field_pass)).perform(typeText("12345678"))
        closeSoftKeyboard()
        onView(withId(R.id.btn_login1)).perform(click())
        onView(withText("Logado com sucesso")).check(matches(isDisplayed()))
        onView(withText("Voltar")).perform(click())
        onView(withText("Aplicativo de Testes")).check(matches(isDisplayed()))
    }

    @Test
    fun testefalha() {
        onView(withText("Aplicativo de Test234234es")).check(matches(isDisplayed()))

    }
}