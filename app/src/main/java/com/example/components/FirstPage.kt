package com.example.components
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstPage(navController: NavController) {
    val nameTextField = remember { mutableStateOf("") }
    val ageTextField = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("First Page")
                },

                )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = nameTextField.value, onValueChange = { value ->
                        nameTextField.value = value
                    },
                    label = {
                        Text("Name")
                    })
                Spacer(Modifier.height(8.dp))
                TextField(
                    value = ageTextField.value, onValueChange = { value ->
                        ageTextField.value = value
                    },
                    label = {
                        Text("Age")
                    }
                )

                Button(
                    onClick = {
                        navController.navigate("SecondPage"){
//                           popUpTo("FirstPage"){inclusive = true}
                        }
                    },
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(2.dp, color = Color.Blue),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        "Send Button",
                        color = Color.Blue
                    )
                }
            }
        }
    )
}