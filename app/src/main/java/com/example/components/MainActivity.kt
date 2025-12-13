package com.example.components

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.components.ui.theme.ComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AlertDialogExample(
                        modifier = Modifier.padding(innerPadding)
                    )
//                    AlertDialogExampleWithAlertDialog()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    var buttonColor by remember { mutableStateOf(Color.Blue) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // BasicAlertDialog bilan custom dialog
        if (showDialog) {
            BasicAlertDialog(
                onDismissRequest = { showDialog = false },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = false
                )
            ) {
                // Card ichida dialog content
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        // Title
                        Text(
                            text = "Change Button Color",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(Modifier.height(16.dp))

                        // Message
                        Text(
                            text = "Do you want to change the color of the button to Green?",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(Modifier.height(24.dp))

                        // Buttons
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Cancel Button
                            TextButton(
                                onClick = { showDialog = false }
                            ) {
                                Text("No", fontSize = 16.sp)
                            }

                            Spacer(Modifier.width(8.dp))

                            // Confirm Button
                            Button(
                                onClick = {
                                    showDialog = false
                                    buttonColor = Color.Green
                                    Toast.makeText(
                                        context,
                                        "Button color changed!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            ) {
                                Text("Yes", fontSize = 16.sp)
                            }
                        }
                    }
                }
            }
        }

        // Main Button
        Button(
            onClick = { showDialog = true },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Show Dialog Message", fontSize = 16.sp)
        }
    }
}

//// ALTERNATIV: AlertDialog (Old but still works) bilan
@Composable
fun AlertDialogExampleWithAlertDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    var buttonColor by remember { mutableStateOf(Color.Blue) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // AlertDialog (eskiroq lekin osonroq)
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = "Change Button Color",
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {
                    Text("Do you want to change the color of the button to Green?")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            buttonColor = Color.Green
                            Toast.makeText(
                                context,
                                "Button color changed!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("No")
                    }
                }
            )
        }

        Button(
            onClick = { showDialog = true },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Show Dialog (AlertDialog)", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogExamplePreview() {
    ComponentsTheme {
        AlertDialogExample()
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogWithAlertDialogPreview() {
    ComponentsTheme {
        AlertDialogExampleWithAlertDialog()
    }
}