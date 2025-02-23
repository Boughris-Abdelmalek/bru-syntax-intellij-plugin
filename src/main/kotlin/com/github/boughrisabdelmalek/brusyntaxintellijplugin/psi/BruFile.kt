package com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi

import com.github.boughrisabdelmalek.brusyntaxintellijplugin.BruFileType
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class BruFile(viewProvider: FileViewProvider) :
    PsiFileBase(viewProvider, BruLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return BruFileType.INSTANCE
    }

    override fun toString(): String {
        return "Simple File"
    }
}