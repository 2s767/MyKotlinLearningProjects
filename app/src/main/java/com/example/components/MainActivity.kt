package com.example.components
import android.os.Bundle
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
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
                    SwitchExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SwitchExample(modifier: Modifier = Modifier) {
    val switchState = remember {
        mutableStateOf(true)
    }
    val myAlphaValue = remember {
        mutableStateOf(1F)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {

       if(switchState.value){
           myAlphaValue.value = 1f
       }else {
           myAlphaValue.value = 0F
       }

           Image(painter = painterResource(R.drawable.airport_image),"Airport logo",modifier = Modifier.alpha(myAlphaValue.value))

        Switch(checked = switchState.value, onCheckedChange = {
            switchState.value = it
        })

        Text(if(switchState.value) "Rasm ko'ringan" else "Rasm ko'rinmagan")

    }
}

@Preview(showBackground = true)
@Composable
fun SwitchExamplePreview() {
    ComponentsTheme {
        SwitchExample()
    }
}