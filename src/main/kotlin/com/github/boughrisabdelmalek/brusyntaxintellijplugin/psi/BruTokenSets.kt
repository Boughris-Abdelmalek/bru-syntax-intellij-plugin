package com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi

import com.intellij.psi.tree.TokenSet

interface BruTokenSets {
    companion object {
        val IDENTIFIERS: TokenSet = TokenSet.create(BruTypes.KEY)

        val COMMENTS: TokenSet = TokenSet.create(BruTypes.COMMENT)

        val DIGIT: TokenSet = TokenSet.create(BruTypes.DIGIT)
    }
}