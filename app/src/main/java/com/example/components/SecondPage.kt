package com.example.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPage(navController: NavController, id : Int){
    val country = retrieveCountries()
    val selectedCountry = country[id - 1]
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Details")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.Outlined.ArrowBack,"arrow back")
                    }
                }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(it).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
               items(
                   count = 1,
                   itemContent = { index ->
                       Spacer(Modifier.height(60.dp))
                       Image(painter = painterResource(selectedCountry.countryImage),selectedCountry.countryName,
                           modifier = Modifier.size(300.dp,200.dp)
                           )
                       Spacer(modifier = Modifier.height(40.dp))
                       Text(selectedCountry.countryName, fontSize = 24.sp)
                       Spacer(modifier = Modifier.height(10.dp))
                       Text(selectedCountry.countryDescription, fontSize = 16.sp)
                   }
               )
            }
        }
    )
}