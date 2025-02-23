package com.github.boughrisabdelmalek.brusyntaxintellijplugin

import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruIcon
import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class BruFileType: LanguageFileType(BruLanguage.INSTANCE) {
    companion object {
        val INSTANCE: BruFileType = BruFileType()
    }

    override fun getName(): String {
        return "Bru File"
    }

    override fun getDescription(): String {
        return "Bru language file"
    }

    override fun getDefaultExtension(): String {
        return "bru"
    }

    override fun getIcon(): Icon {
        return BruIcon.FILE
    }

}