package com.github.boughrisabdelmalek.brusyntaxintellijplugin

import com.intellij.lexer.FlexAdapter

class BruLexerAdapter : FlexAdapter(BruLexer(null))