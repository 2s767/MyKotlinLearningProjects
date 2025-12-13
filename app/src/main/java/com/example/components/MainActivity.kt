package com.example.components
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.example.components.ui.theme.ComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OptionsMenuExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionsMenuExample(modifier: Modifier = Modifier) {
    var dropDownMenuStatus by remember {
        mutableStateOf(false)
    }
    var centerText by remember {
        mutableStateOf("This is default text")
    }
   Scaffold(
       topBar = {
           TopAppBar(
               title = {
                   Column() {
                       Text("Main title", fontSize = 20.sp, color = Color.White)

                       Text("Subtitle ", fontSize = 16.sp, color = Color.White)
                   }

               },
               navigationIcon = {
                   IconButton(onClick = {
                        centerText = "Navigation button is clicked"
                   }) {
                       Icon(Icons.Default.Menu, contentDescription = "Navigation Icon")
                   }
               },
               actions = {
                   IconButton(onClick = {
                       centerText = "Share button is clicked"
                   }) {
                       Icon(Icons.Outlined.Share,"Share Button")
                   }
                   IconButton(onClick = {
                       centerText = "Search button is clicked"
                   }) {
                       Icon(Icons.Outlined.Search,"Search Button")
                   }
                   IconButton(onClick = {
                       centerText = "MoreVert button is clicked"
                       dropDownMenuStatus = true
                   }) {
                       Icon(Icons.Outlined.MoreVert,"MoreVert Button")
                       DropdownMenu(expanded = dropDownMenuStatus, onDismissRequest = {
                           dropDownMenuStatus = false
                       }) {
                           DropdownMenuItem(text = {
                               Text("Settings")
                           }, onClick = {
                               centerText = "Settings is clicked"
                               dropDownMenuStatus = false
                           } )
                           DropdownMenuItem(text = {
                               Text("Log Out")
                           }, onClick = {
                               centerText = "Log out is clicked"
                               dropDownMenuStatus = false
                           } )
                       }
                   }
               },
               colors = TopAppBarDefaults.topAppBarColors(
                   containerColor = colorResource(R.color.purple_700),
                   navigationIconContentColor = Color.White,
                   actionIconContentColor = Color.White


               )
           )
       },
       content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(centerText)
            }
       }
   )
}