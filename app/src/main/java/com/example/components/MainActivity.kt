package com.example.components
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Checkbox
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
    val genderMale  = remember {
        mutableStateOf(false)
    }
    val genderFemale  = remember {
        mutableStateOf(false)
    }
    val title = remember {
        mutableStateOf("What is your Gender ?")
    }
    fun genderChooser() {
        if(genderFemale.value && genderMale.value) title.value =  "What is your gender ? " else if (genderMale.value ) title.value =  " Your Gender is Male" else title.value = "Your Gender is Female"
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))
        Text(title.value, fontSize = 25.sp, textAlign = TextAlign.Center, color = Color.Blue)
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row( verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = genderMale.value, onCheckedChange = {
                    genderMale.value = it
                    genderFemale.value = !it
                    genderChooser()
                })
                Text("Male")
            }
            Spacer(Modifier.height(20.dp))
            Row( verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = genderFemale.value, onCheckedChange = {
                        genderFemale.value = it
                        genderMale.value = !it
                        genderChooser()
                    })
                Text("Female")
            }
        }

    }

}



@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {
    ComponentsTheme {
        Components()
    }
}