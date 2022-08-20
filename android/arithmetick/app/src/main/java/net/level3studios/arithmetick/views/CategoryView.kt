package net.level3studios.arithmetick.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arithmetick.views.ui.theme.ArithmetickTheme
import net.level3studios.arithmetick.models.CategoryModel
import net.level3studios.arithmetick.views.components.ArithmetickTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryView(navController: NavController) {
    Scaffold(topBar = { ArithmetickTopBar(title = "Categories")}) {
        CategoryGridView()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryGridView() {
    val gridCells = GridCells.Fixed(2)
    val gridPadding = PaddingValues(horizontal = 12.dp, vertical = 16.dp)
    val dataItems = CategoryModel.allCategories()
    
    LazyVerticalGrid(cells = gridCells,
        contentPadding = gridPadding,
        content = {
        items(dataItems) { item ->
            Text(item.displayLabel)
        }
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightCategoryPreview() {
    ArithmetickTheme {
        CategoryView(navController = rememberNavController())
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DarkCategoryPreview() {
    ArithmetickTheme(darkTheme = true) {
        CategoryView(navController = rememberNavController())
    }
}