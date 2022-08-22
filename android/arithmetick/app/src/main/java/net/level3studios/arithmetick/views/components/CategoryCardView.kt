package net.level3studios.arithmetick.views.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.level3studios.arithmetick.NavigationRoutes
import net.level3studios.arithmetick.models.CategoryModel
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme
import net.level3studios.arithmetick.views.components.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CategoryCardView(category: CategoryModel, navController: NavController) {
    val cardModifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    val imageModifier = Modifier
        .size(48.dp)
        .clip(CircleShape)
        .background(category.itemColor)
        .padding(12.dp)
    Card(shape = Shapes.medium,
        backgroundColor = MaterialTheme.colorScheme.surface,
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.outline),
        elevation = 6.dp,
        modifier = cardModifier,
        onClick = { navController.navigate(NavigationRoutes.ConverterView.routeName + "/${category.option.id}")}) {
        Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Image(
                painter = painterResource(id = category.itemIcon),
                contentDescription = "Row Icon",
                modifier = imageModifier,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.White)
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(category.displayLabel,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth())
                Text("${category.availableUnits.count()}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightCardPreview() {
    ArithmetickTheme {
        CategoryCardView(category = CategoryModel.testModel(), rememberNavController())
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DarkCardPreview() {
    ArithmetickTheme(useDarkTheme = true) {
        CategoryCardView(category = CategoryModel.testModel(), rememberNavController())
    }
}