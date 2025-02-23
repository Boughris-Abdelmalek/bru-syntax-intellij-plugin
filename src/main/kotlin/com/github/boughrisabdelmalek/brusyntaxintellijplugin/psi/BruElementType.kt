package com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi

import com.intellij.psi.tree.IElementType

class BruElementType(debugName: String) :
    IElementType(debugName, BruLanguage.INSTANCE)