package com.example.myapplication10.pageObjects.Login.robot

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.myapplication10.R
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.BTN_VOLTAR
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.EMAIL_SUCESSO
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.SENHA_SUCESSO
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.TEXTO_LOGADO
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.TITULO_APLICATIVO

class RobotLogin {

    fun validarTituloNaTela() {
        onView(withText(TITULO_APLICATIVO)).check(matches(isDisplayed()))
    }

    fun escreverEmail() {
        onView(withId(CAMPO_EMAIL)).perform(typeText(EMAIL_SUCESSO))
    }

    fun fecharTeclado() {
        closeSoftKeyboard()
    }

    fun escreverSenha() {
        onView(withId(R.id.field_pass)).perform(typeText(SENHA_SUCESSO))
    }

    fun clicarEmLogar() {
        onView(withId(R.id.btn_login1)).perform(ViewActions.click())
    }

    fun validarUsuarioLogado() {
        onView(withText(TEXTO_LOGADO)).check(matches(isDisplayed()))
    }

    fun clicarEmVoltar() {
        onView(withText(BTN_VOLTAR)).perform(ViewActions.click())
    }

    companion object {
        private val CAMPO_EMAIL = R.id.field_email
    }
}