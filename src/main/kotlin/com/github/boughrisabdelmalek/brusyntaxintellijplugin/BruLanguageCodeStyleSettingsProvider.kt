// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.github.boughrisabdelmalek.brusyntaxintellijplugin

import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruLanguage
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider

internal class BruLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
    override fun getLanguage(): Language {
        return BruLanguage.INSTANCE
    }

    override fun customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: SettingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS")
            consumer.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Separator")
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
            consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE")
        }
    }

    override fun getCodeSample(settingsType: SettingsType): String {
        return """
        ver = 1.0
        type = "example"
        name = "Sample"
        method = "GET"
        url = "https://example.com/api"
        params = {
            "param1": "value1",
            "param2": "value2"
        }
        body-mode = "json"
        body = {
            "key": "value"
        }
        script = {
            // JavaScript code here
        }
        assert = {
            "status": 200
        }
        vars = {
            "var1": "value1"
        }
        response-example = {
            "key": "value"
        }
        readme = "This is a sample configuration."
        """.trimIndent()
    }
}