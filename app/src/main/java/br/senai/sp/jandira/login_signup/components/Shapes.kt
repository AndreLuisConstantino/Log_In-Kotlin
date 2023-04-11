package br.senai.sp.jandira.login_signup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopShape() {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(50.dp),
        //backgroundColor = Brush.horizontalGradient(listOf(Color.Magenta, Color.Yellow)),
        shape = RoundedCornerShape(bottomStart = 16.dp)
    ) {
        Box(modifier = Modifier.background(color = Color(206, 6, 240)))
    }
}

@Composable
fun BottomShape() {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(50.dp),
        backgroundColor = Color(206, 6, 240),
        shape = RoundedCornerShape(topEnd = 16.dp)
    ) {}
}

@Preview
@Composable
fun TopShapePreview() {
    TopShape()
}

@Preview
@Composable
fun BottomShapePreview() {
    BottomShape()
}