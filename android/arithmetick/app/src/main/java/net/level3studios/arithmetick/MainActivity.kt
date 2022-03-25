package net.level3studios.arithmetick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.level3studios.arithmetick.models.CategoryItemModel
import net.level3studios.arithmetick.models.CategoryOption
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme
import net.level3studios.arithmetick.ui.views.CategoriesMainView
import net.level3studios.arithmetick.ui.views.CategoryConversionView
import net.level3studios.arithmetick.viewmodels.ConversionViewModel

enum class NavigationRoutes(val routeName: String) {
    HOME("home"),
    DETAIL("details")
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
                    color = MaterialTheme.colors.background
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
        startDestination = NavigationRoutes.HOME.routeName) {
        composable(NavigationRoutes.HOME.routeName) {
            CategoriesMainView(navController = navController)
        }
        // use id from backstack to get selected option
        composable(NavigationRoutes.DETAIL.routeName + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType})) {
            val categoryId = navController.currentBackStackEntry?.arguments?.getInt("categoryId") ?: 0
            val selectedOption = CategoryOption.values().first { it.id == categoryId }
            val model = CategoryItemModel(selectedOption)
            val viewModel = ConversionViewModel(model, context = LocalContext.current)
            CategoryConversionView(viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultMainLightPreview() {
    ArithmetickTheme {
        CategoriesMainView(navController = rememberNavController())
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultMainDarkPreview() {
    ArithmetickTheme(useDarkTheme = true) {
        CategoriesMainView(navController = rememberNavController())
    }
}