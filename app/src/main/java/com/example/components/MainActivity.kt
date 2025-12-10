package com.example.components
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.components.ui.theme.ComponentsTheme
import org.w3c.dom.Text
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RadioButtonExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RadioButtonExample(modifier: Modifier = Modifier) {
    val countryName = remember {
        mutableStateOf("Germany")
    }
    val stateOfDropDown = remember {
        mutableStateOf(false)
    }
    val listOfCountries = listOf<String>("Germany","USA","France","Italy","BAA","Uzbekistan")
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = {
            stateOfDropDown.value = true
        })) {
            Text(countryName.value)
            Image(painter = painterResource(R.drawable.round_arrow_drop_down_circle_24,), contentDescription = "",
                Modifier.size(20.dp).clickable(onClick = {

                }))
            DropdownMenu(onDismissRequest = {
                stateOfDropDown.value = false
            }, expanded = stateOfDropDown.value  ) {
                listOfCountries.forEach {
                    it -> DropdownMenuItem(text = {Text(it)}, onClick = {
                        stateOfDropDown.value = false
                        countryName.value = it
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonExamplePreview() {
    ComponentsTheme {
        RadioButtonExample()
    }
}