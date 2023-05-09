package br.senai.sp.jandira.login_signup.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.login_signup.R
import br.senai.sp.jandira.login_signup.model.Categories

class CategoryRepository {
    companion object{
        @Composable
        fun getCategories(): List<Categories> {
            return listOf(
                Categories(id = 1, name = "Montain", icon = painterResource(id = R.drawable.montanhas)),
                Categories(id = 2, name = "Beach", icon = painterResource(id = R.drawable.praia)),
                Categories(id = 3, name = "Snow", icon = painterResource(id = R.drawable.ski)),
                Categories(id = 4, name = "Montain", icon = painterResource(id = R.drawable.montanhas))
            )
        }
    }

}