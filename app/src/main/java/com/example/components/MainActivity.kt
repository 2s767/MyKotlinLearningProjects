package com.example.components
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val colorsName = listOf("White","Red","Blue","Green")
    val backGroundColors = listOf(Color.White, Color.Red, Color.Blue,Color.Green)
    val indexNumber = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize().background(color = backGroundColors[indexNumber.value]),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {

        colorsName.forEachIndexed { position, name ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 120.dp).clickable(
                    onClick = {
                        indexNumber.value = position
                    }
                )
            ) {
                RadioButton(selected = name == colorsName[indexNumber.value], onClick = {
                    indexNumber.value = position
                },
                    colors = RadioButtonDefaults.colors(backGroundColors[indexNumber.value])
                    )
                Text(colorsName[position])
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