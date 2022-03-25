package net.level3studios.arithmetick.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.level3studios.arithmetick.NavigationRoutes
import net.level3studios.arithmetick.models.CategoryItemModel
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme
import net.level3studios.arithmetick.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArithmetickCardView(categoryItem: CategoryItemModel, navController: NavController) {
    val cardModifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    Card(shape = Shapes.medium,
        elevation = 6.dp,
        modifier = cardModifier,
        backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
        onClick = { navController.navigate(NavigationRoutes.DETAIL.routeName + "/${categoryItem.option.id}") }) {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(categoryItem.itemColor),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = categoryItem.itemIconId),
                    contentDescription = "Row Icon")
            }
            Column(modifier = Modifier.padding(horizontal = 8.dp,
                vertical = 4.dp)) {
                Text(categoryItem.itemTitle,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(text = "${categoryItem.conversionOptions.size}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CardViewPreview() {
    ArithmetickTheme(useDarkTheme = false) {
        ArithmetickCardView(CategoryItemModel.testModel(), navController = rememberNavController())
    }
}