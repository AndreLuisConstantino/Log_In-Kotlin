package br.senai.sp.jandira.login_signup

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_signup.ui.theme.LoginSignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSignupTheme {
                loginScreen()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun loginScreen(){

    var emailState = rememberSaveable{
        mutableStateOf("")
    }

    var passwordState = rememberSaveable {
        mutableStateOf("")
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            )
            {
                Surface(
                    modifier = Modifier
                        .width(140.dp)
                        .height(50.dp),
                    color = Color(206, 6, 240),
                    shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 16.dp)
                ) {}
            }
            Spacer(
                modifier = Modifier.height(120.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                Text(
                    text = stringResource(id = R.string.login_text),
                    color = Color(206, 6, 240),
                    fontSize = 70.sp,
                    fontWeight = FontWeight(700)
                )
                Text(
                    text = stringResource(id = R.string.sign_to_continue),
                    color = Color.Gray,
                    fontSize = 20.sp
                )

            }
            Spacer(
                modifier =Modifier.height(40.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.End
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    shape = RoundedCornerShape(16.dp),
                    label = {Text(text = "Email")},
                    leadingIcon = { 
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            tint = Color(206, 6, 240)
                        )
                    }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                    },
                    shape = RoundedCornerShape(16.dp),
                    label = {Text(text = stringResource(id = R.string.password_outlinedTextfield))},
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = null,
                            tint = Color(206, 6, 240)
                        )
                    }
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(Color(206, 6, 240))
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_in_button),
                        color = Color.White
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = null,
                        tint = Color(255, 255, 255, 255)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .height(30.dp)

                ) {
                }
            }
        }
    }
}