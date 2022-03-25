package net.level3studios.arithmetick.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.level3studios.arithmetick.models.CategoryItemModel
import net.level3studios.arithmetick.models.CategoryOption
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArithmetickCategoriesGridView(navController: NavController) {
    val gridCells = GridCells.Fixed(2)
    val gridPadding = PaddingValues(horizontal = 12.dp, vertical = 16.dp)
    val dataItems = CategoryOption.values().map { CategoryItemModel(it) }

    LazyVerticalGrid(cells = gridCells,
        contentPadding = gridPadding,
        content = {
            items(dataItems) { item ->
                ArithmetickCardView(categoryItem = item, navController = navController)
            }
        } )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GridLightPreview() {
    ArithmetickTheme(useDarkTheme = false) {
        ArithmetickCategoriesGridView(navController = rememberNavController())
    }
}