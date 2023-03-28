package br.senai.sp.jandira.login_signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_signup.components.BottomShape
import br.senai.sp.jandira.login_signup.components.TopShape
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
            TopShape()
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
                text = stringResource(id = R.string.create_new_accont),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .align(alignment = Alignment.Center)
                        .border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Magenta,
                                    Color.White
                                )
                            ),
                            shape = CircleShape
                        ),
                    shape = CircleShape

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.photo_camera), contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(42.dp)
                        .offset(
                            x = 12.dp,
                            y = 7.dp
                        )
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = usernameState.value,
                    onValueChange = {
                        usernameState.value = it
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
                    value = phoneState.value,
                    onValueChange = {
                        phoneState.value = it
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
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
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
                    value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
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
                BottomShape()
            }
        }
    }
