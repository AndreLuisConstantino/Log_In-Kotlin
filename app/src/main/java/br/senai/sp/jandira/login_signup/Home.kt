package br.senai.sp.jandira.login_signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.login_signup.model.Categories
import br.senai.sp.jandira.login_signup.repository.CategoryRepository
import br.senai.sp.jandira.login_signup.ui.theme.LoginSignupTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSignupTheme {
                HomeScreen(CategoryRepository.getCategories())
            }
        }
    }
}


@Composable
fun HomeScreen(categories: List<Categories>) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = Color.White
            )
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(

            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image_paris),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = stringResource(id = R.string.categories),
                    modifier = Modifier
                        .padding(top = 14.dp, start = 16.dp)
                )
                LazyRow() {

                    items(categories) {
                        Card(
                            backgroundColor = Color(207, 6, 240),
                            modifier = Modifier
                                .size(
                                    110.dp,
                                    80.dp
                                )
                                .padding(4.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = it.icon!!,
                                    contentDescription = "sus",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(32.dp)
                                )
                                Text(text = it.name)
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LoginSignupTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen(categories = CategoryRepository.getCategories())
        }
    }
}