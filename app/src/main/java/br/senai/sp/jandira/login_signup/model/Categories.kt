package br.senai.sp.jandira.login_signup.model

import androidx.compose.ui.graphics.painter.Painter

data class Categories(
    var id: Long = 0,
    var name: String = "",
    var icon: Painter? = null
)
