package com.github.boughrisabdelmalek.brusyntaxintellijplugin

import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class BruSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return BruLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey?> {
        if (tokenType == BruTypes.SEPARATOR) {
            return SEPARATOR_KEYS
        }
        if (tokenType == BruTypes.DIGIT) {
            return DIGIT_KEYS
        }
        if (tokenType == BruTypes.KEY) {
            return KEY_KEYS
        }
        if (tokenType == BruTypes.VALUE) {
            return VALUE_KEYS
        }
        if (tokenType == BruTypes.COMMENT) {
            return COMMENT_KEYS
        }
        if (tokenType == TokenType.BAD_CHARACTER) {
            return BAD_CHAR_KEYS
        }
        return EMPTY_KEYS
    }

    companion object {
        val SEPARATOR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "BRU_SEPARATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        val KEY: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("BRU_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("BRU_VALUE", DefaultLanguageHighlighterColors.STRING)
        val DIGIT: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("BRU_DIGIT", DefaultLanguageHighlighterColors.NUMBER)
        val COMMENT: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("BRU_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("BRU_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)


        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val DIGIT_KEYS = arrayOf(DIGIT)
        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)
    }
}