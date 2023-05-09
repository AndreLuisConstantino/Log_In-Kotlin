package br.senai.sp.jandira.login_signup

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.net.Uri
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_signup.components.BottomShape
import br.senai.sp.jandira.login_signup.components.TopShape
import br.senai.sp.jandira.login_signup.dao.UserDao
import br.senai.sp.jandira.login_signup.repository.UserRepository
import br.senai.sp.jandira.login_signup.ui.theme.LoginSignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSignupTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    loginScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun loginScreen() {

    val context = LocalContext.current

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }
    
    var passwordVisibilityState by remember {
        mutableStateOf(false)
    }

    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        )
        {
            TopShape()
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
                color = Color(207, 6, 240),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.sign_to_continue),
                color = Color.Gray,
                fontSize = 16.sp
            )

        }
        Spacer(
            modifier = Modifier.height(40.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailState,
                onValueChange = {
                    emailState = it
                },
                shape = RoundedCornerShape(16.dp),
                label = { Text(text = "Email") },
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
                value = passwordState,
                onValueChange = {
                    passwordState = it
                },
                shape = RoundedCornerShape(16.dp),
                visualTransformation = if(!passwordVisibilityState) PasswordVisualTransformation() else VisualTransformation.None,
                label = { Text(text = stringResource(id = R.string.password_outlinedTextfield)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_lock_24),
                        contentDescription = null,
                        tint = Color(206, 6, 240)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                            passwordVisibilityState = !passwordVisibilityState
                    }) {
                        Icon(
                            imageVector = if(passwordVisibilityState)
                                                Icons.Default.VisibilityOff
                                            else Icons.Default.Visibility,
                            contentDescription = null
                        )
                    }
                }
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Button(
                onClick = {
                    authenticate(emailState, passwordState, context)
                },
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(Color(206, 6, 240))
            ) {
                Text(
                    text = stringResource(id = R.string.sign_in_button).uppercase(),
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
                    .height(40.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.dont_have_accont),
                    fontWeight = FontWeight(500),
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(
                    onClick = {
                        var openSignUp = Intent(context, SignUpActivity::class.java)
                        context.startActivity(openSignUp)
                    }) {
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontWeight = FontWeight.Bold,
                        color = Color(206, 6, 240),
                        fontSize = 12.sp
                    )
                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 120.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            BottomShape()
        }
    }
}

fun authenticate(email: String, password: String, context: Context) {
    val userRepository = UserRepository(context)
    val user = userRepository.authenticate(
        email,
        password
    )

    if (user != null){
        val openHome = Intent(context, Home::class.java)
        context.startActivity(openHome)
    } else {

    }
}
