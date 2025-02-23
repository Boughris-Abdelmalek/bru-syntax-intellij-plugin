package com.github.boughrisabdelmalek.brusyntaxintellijplugin.psi

import com.intellij.openapi.util.IconLoader.getIcon
import javax.swing.Icon

const val ICON_PATH: String = "META-INF/pluginIcon.svg"

object BruIcon {
    val FILE: Icon = getIcon(ICON_PATH, BruIcon::class.java)
}