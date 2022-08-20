package net.level3studios.arithmetick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme
import net.level3studios.arithmetick.views.CategoryView

enum class NavigationRoutes(val routeName: String) {
    CategoryView("home"),
    ConverterView("converter")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ArithmetickTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationComponent(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController,
    startDestination = NavigationRoutes.CategoryView.routeName) {
        composable(NavigationRoutes.CategoryView.routeName) {
            CategoryView(navController)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainLightPreview() {
    ArithmetickTheme {
        NavigationComponent(navController = rememberNavController())
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainDarkPreview() {
    ArithmetickTheme(useDarkTheme = true) {
        NavigationComponent(navController = rememberNavController())
    }
}