package net.level3studios.arithmetick

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.level3studios.arithmetick.models.CategoryModel
import net.level3studios.arithmetick.models.CategoryOption
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme
import net.level3studios.arithmetick.viewmodels.ConverterViewModel
import net.level3studios.arithmetick.views.CategoryView
import net.level3studios.arithmetick.views.ConverterView

enum class NavigationRoutes(val routeName: String) {
    CategoryView("home"),
    ConverterView("converter")
}

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
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

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = NavigationRoutes.CategoryView.routeName) {
        composable(NavigationRoutes.CategoryView.routeName) {
            CategoryView(navController)
        }
        //use backstack to get id for selected category
        composable(NavigationRoutes.ConverterView.routeName  + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType})) {
            val categoryId = navController.currentBackStackEntry?.arguments?.getInt("categoryId") ?: 0
            val selectedOption = CategoryOption.values().first { it.id == categoryId }
            val model = CategoryModel(selectedOption)
            val viewModel = ConverterViewModel(model)
            ConverterView(viewModel = viewModel)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainLightPreview() {
    ArithmetickTheme {
        NavigationComponent(navController = rememberNavController())
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainDarkPreview() {
    ArithmetickTheme(useDarkTheme = true) {
        NavigationComponent(navController = rememberNavController())
    }
}