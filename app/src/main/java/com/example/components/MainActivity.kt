package com.example.components
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.components.ui.theme.ComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Components(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Components(modifier: Modifier = Modifier) {
    val myButtonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val myButtonText = remember {
        mutableStateOf("Press me")
    }

    val myTextFieldValue = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.airport_image), "", contentScale = ContentScale.Fit,  alignment = Alignment.TopStart,modifier = Modifier.size(300.dp),)
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                myButtonBackgroundColor.value = Color.Blue
                myButtonText.value = "Text changed"
            },
            modifier = Modifier.size(250.dp, 60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = myButtonBackgroundColor.value)
        ) {
            Text(myButtonText.value, textAlign = TextAlign.Center, fontSize = 25.sp)
        }

        Spacer(Modifier.height(16.dp))
        TextField(value = myTextFieldValue.value,onValueChange = {
            myTextFieldValue.value = it
        },
        label = {Text("Enter your name ")},
        modifier = Modifier.width(250.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Red,
                focusedContainerColor = Color.Blue
            ),

            textStyle = TextStyle.Default.copy(fontSize = 23.sp, color = Color.Black),
            maxLines = 4,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {
    ComponentsTheme {
        Components()
    }
}