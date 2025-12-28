package com.example.components
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.components.ui.theme.ComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
               MyNavigation()
            }
        }
    }
}
@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "FirstPage"){
        composable("FirstPage") {
            FirstPage(navController = navController)
        }

        composable("SecondPage/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            val countryId = it.arguments?.getInt("id")
            countryId?.let {id ->
                SecondPage(navController = navController, id = id)
            }

        }
    }
}
//@Composable
//fun MyNavigationController() {
//    val navigationController = rememberNavController()
//
//    NavHost(navController = navigationController, startDestination = "FirstPage") {
//        composable(route = "FirstPage") {
//            FirstPage(navigationController)
//        }
//        composable(
//            "SecondPage/{name}/{age}", arguments = listOf(
//            navArgument("name") {
//                type = NavType.StringType
//            },
//            navArgument("age") {
//                type = NavType.IntType
//            }
//        )) { navBackStackEntry ->
//            val name = navBackStackEntry.arguments?.getString("name")
//            val age = navBackStackEntry.arguments?.getInt("age")
//
//            name?.let {  // let bu agar name null bo'lmasa tanaga kirdiradi
//                    username ->
//                age?.let { userAge ->
//                    SecondPage(navigationController, username, userAge)
//                }
//            }
//
//        }
//    }
//}