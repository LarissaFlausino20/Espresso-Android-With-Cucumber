package com.example.myapplication10

import android.os.Bundle
import androidx.test.runner.MonitoringInstrumentation
import cucumber.api.CucumberOptions
import cucumber.api.android.CucumberInstrumentationCore
import org.junit.Test

@CucumberOptions(
    features = ["features"],
    glue = ["com.example.heitorcolangelo.espressotests.test"],
    tags = ["@login-validando"]
)
class Instrumentation : MonitoringInstrumentation() {
    private val instrumentationCore = CucumberInstrumentationCore(this)
    override fun onCreate(arguments: Bundle) {
        super.onCreate(arguments)
        val tags: String = BuildConfig.TEST_TAGS
        if (!tags.isEmpty()) {
            arguments.putString(
                "tags",
                tags.replace(",".toRegex(), "--").replace("\\s".toRegex(), "")
            )
        }
        instrumentationCore.create(arguments)
        start()
    }

    override fun onStart() {
        super.onStart()
        waitForIdleSync()
        instrumentationCore.start()
    }

    @Test
    fun runTests() {
    }
}