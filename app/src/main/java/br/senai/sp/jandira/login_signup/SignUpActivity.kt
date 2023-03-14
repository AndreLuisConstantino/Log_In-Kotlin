package br.senai.sp.jandira.login_signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_signup.ui.theme.LoginSignupTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    singUpScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun singUpScreen() {

    var emailState = rememberSaveable {
        mutableStateOf("")
    }

    var passwordState = rememberSaveable {
        mutableStateOf("")
    }

    var phoneState = rememberSaveable {
        mutableStateOf("")
    }

    var usernameState = rememberSaveable {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(50.dp),
                backgroundColor = Color(206, 6, 240),
                shape = RoundedCornerShape(bottomStart = 16.dp)
            ) {}
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.sign_up),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(206, 6, 240)
            )
            Text(
                text = stringResource(id = R.string.dont_have_accont),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {

                    },
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.username_outlinedTextfield)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = null,
                            tint = Color(206, 6, 240)
                        )
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {

                    },
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.phone_outlinedTextfield)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_phone_android_24),
                            contentDescription = null,
                            tint = Color(206, 6, 240)
                        )
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {

                    },
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.email_outlinedTextfield)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            tint = Color(206, 6, 240)
                        )
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {

                    },
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = stringResource(id = R.string.password_outlinedTextfield)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = null,
                            tint = Color(206, 6, 240)
                        )
                    }
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 20.dp, bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = null)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = stringResource(id = R.string.over_18))
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(Color(206, 6, 240))
                ) {
                    Text(
                        text = stringResource(id = R.string.create_accont).uppercase(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = stringResource(id = R.string.already_have_accont),
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.sign_in),
                        fontWeight = FontWeight.Bold,
                        color = Color(206, 6, 240),
                        fontSize = 12.sp
                    )
                }
            }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .height(50.dp),
                    backgroundColor = Color(206, 6, 240),
                    shape = RoundedCornerShape(topEnd = 16.dp)
                ) {}
            }
        }
    }
