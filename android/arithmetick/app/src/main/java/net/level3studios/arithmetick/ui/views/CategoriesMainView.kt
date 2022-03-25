package net.level3studios.arithmetick.ui.views

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.level3studios.arithmetick.ui.components.ArithmetickCategoriesGridView
import net.level3studios.arithmetick.ui.components.ArithmetickTopAppBar
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesMainView(navController: NavController) {
    
    Scaffold(topBar = { ArithmetickTopAppBar(title = "Categories") }) {
        ArithmetickCategoriesGridView(navController = navController)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainViewLightPreview() {
    CategoriesMainView(navController = rememberNavController())
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainViewDarkPreview() {
    ArithmetickTheme(useDarkTheme = true) {
        CategoriesMainView(navController = rememberNavController())
    }
}