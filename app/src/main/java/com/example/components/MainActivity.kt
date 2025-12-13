package com.example.components
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.components.ui.theme.ComponentsTheme
import kotlinx.coroutines.launch


// COROUTINE HAQIDA TO'LIQ MA'LUMOT PDF SHAKLIDA PROJECT ICHIDA SAQLANGAN !
// app/sampledata/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SnackBarMessage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("ShowToast")
@Composable
fun SnackBarMessage(modifier: Modifier = Modifier) {
    val mySnackbarHostState = remember {  // remember - rekompositsiya vaqtida holatni saqlaydi
        SnackbarHostState()  // Snackbar holatini boshqaradi . Bu state orqali snackbar ko'rsatiladi va yashiriladi
    }
//-----------------------------------------------------------------------------------------------

    /*
    Coroutine nima?
    Coroutine - bu Kotlin tilida asinxron (async) kod yozish uchun ishlatiladigan mexanizm. Oddiy qilib aytganda, bu yengil oğirlikdagi thread (light-weight thread).

------------------------------------------------
    1. Oddiy misolda tushuntirish
    ❌ Muammo (Coroutine'siz):

    Button(onClick = {
    // Bu kod UI thread'da ishlaydi
    downloadLargeFile() // 10 soniya davom etadi
    updateUI() // Bu yerga 10 soniyadan keyin yetib keladi
    // Dastur 10 soniya "muzlab" turadi! 😱
})

✅ Yechim (Coroutine bilan):
Button(onClick = {
    coroutineScope.launch {
        downloadLargeFile() // Orqa fonda ishlaydi
        updateUI() // Tugagach UI yangilanadi
        // Dastur muzlamaydi! 😊
    }
})
-------------------------------------------------
     */


//-----------------------------------------------------------------------------------------------


    // Snackbar asinxron ishlaydi shuning uchun coroutine scope kerak.
    val myCoroutineScope = rememberCoroutineScope()  // -> Composable ichida coroutine ishlatish uchun

    val myContext = LocalContext.current // Android Context ni olish


    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = mySnackbarHostState
            ){
                Snackbar(snackbarData = it, containerColor = Color.Green, contentColor = Color.White, actionColor = Color.Black)
            }
        },

        content = { contentPadding ->
            Column(modifier = Modifier.fillMaxSize().padding(contentPadding),
            verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(onClick = {
                    myCoroutineScope.launch {
                     val resultOfSnackbar =   mySnackbarHostState.showSnackbar(
                            message = "This is the Snackbar Message",
                            actionLabel = "Show Toast",
                            duration = SnackbarDuration.Indefinite,
                            withDismissAction = true

                        )

                        if(resultOfSnackbar == SnackbarResult.ActionPerformed){
                            Toast.makeText(myContext,"Action Performed",Toast.LENGTH_LONG).show()
                        }

                    }

                }) {
                    Text("Show Snackbar Message ")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SnackBarMessagePreview() {
    ComponentsTheme {
        SnackBarMessage()
    }
}