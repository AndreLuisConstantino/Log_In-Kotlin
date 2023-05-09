package br.senai.sp.jandira.login_signup

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_signup.components.BottomShape
import br.senai.sp.jandira.login_signup.components.TopShape
import br.senai.sp.jandira.login_signup.model.User
import br.senai.sp.jandira.login_signup.repository.UserRepository
import br.senai.sp.jandira.login_signup.ui.theme.LoginSignupTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

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

    var emailState = rememberSaveable() {
        mutableStateOf("")
    }

    var passwordState = rememberSaveable() {
        mutableStateOf("")
    }

    var phoneState = rememberSaveable() {
        mutableStateOf("")
    }

    var usernameState = rememberSaveable() {
        mutableStateOf("")
    }

    var over18State = rememberSaveable() {
        mutableStateOf(false)
    }

    //OBTER FOTO DA GALERIA DE FOTOS
    var photUri by remember {
        mutableStateOf<Uri?>(null)
    }

    //CRIAR O OBJETO QUE ABRIRÁ A GALERIA E RETORNARÁ A URI DA IMAGEM SELECIONADA
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()){
        photUri = it
    }

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(photUri).build()
    )

    var context = LocalContext.current

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
                .fillMaxSize()
                .padding(12.dp)
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f),
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
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.size(50.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.photo_camera),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(42.dp)
                        .offset(
                            x = 12.dp,
                            y = 7.dp
                        )
                        .clickable {
                            launcher.launch("image/*")

                        }
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                    visualTransformation = PasswordVisualTransformation(),
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
                        onCheckedChange = null
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = stringResource(id = R.string.over_18))
                }
                Button(
                    onClick = {
                        userSave(
                            context = context,
                            email = emailState.toString(),
                            userName = usernameState.toString(),
                            phone = phoneState.toString(),
                            password = passwordState.toString(),
                            isOver = over18State.value
                        )
                    },
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

fun userSave(
    context: Context,
    email: String,
    userName: String,
    phone: String,
    password: String,
    isOver: Boolean
) {
    val userRepository = UserRepository(context)

    //Recuperando no bando um usuário wue tenha o email informado
    var findUserByEmail = userRepository.findUserByEmail(email)

    //Se user for diferente de nulo, gravamos o usuario, senão, avisamos que o usuário e já existe
    if(findUserByEmail == null){
        val newUser = User(
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver
        )
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User created #$id ",
            Toast.LENGTH_LONG
        ).show()
    } else {
        Toast.makeText(context, "User already exists!!!", Toast.LENGTH_LONG).show()
    }
}
