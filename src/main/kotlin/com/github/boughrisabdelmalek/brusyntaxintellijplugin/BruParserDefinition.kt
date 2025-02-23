// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.boughrisabdelmalek.brusyntaxintellijplugin

import com.github.boughrisabdelmalek.brusyntaxintellijplugin.parser.BruParser
import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruFile
import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruLanguage
import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruTokenSets
import com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi.BruTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

internal class BruParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return BruLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return BruTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return BruParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return BruFile(viewProvider)
    }

    override fun createElement(node: ASTNode): PsiElement {
        return BruTypes.Factory.createElement(node)
    }

}

val FILE: IFileElementType = IFileElementType(BruLanguage.INSTANCE)