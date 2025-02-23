package com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi

import com.intellij.psi.tree.IElementType

class BruTokenType(debugName: String) :
    IElementType(debugName, BruLanguage.INSTANCE) {
    override fun toString(): String {
        return "BruTokenType.${super.toString()}"
    }
}