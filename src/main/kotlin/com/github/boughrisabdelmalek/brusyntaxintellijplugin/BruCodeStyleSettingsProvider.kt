// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.github.boughrisabdelmalek.brusyntaxintellijplugin

import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruLanguage
import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleConfigurable
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

internal class BruCodeStyleSettingsProvider : CodeStyleSettingsProvider() {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings {
        return BruCodeStyleSettings(settings)
    }

    override fun getConfigurableDisplayName(): String {
        return "Bru"
    }

    override fun createConfigurable(
        settings: CodeStyleSettings,
        modelSettings: CodeStyleSettings
    ): CodeStyleConfigurable {
        return object : CodeStyleAbstractConfigurable(settings, modelSettings, this.configurableDisplayName) {
            override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
                return BruCodeStyleMainPanel(
                    currentSettings, settings
                )
            }
        }
    }

    private class BruCodeStyleMainPanel(currentSettings: CodeStyleSettings?, settings: CodeStyleSettings) :
        TabbedLanguageCodeStylePanel(BruLanguage.INSTANCE, currentSettings, settings)
}