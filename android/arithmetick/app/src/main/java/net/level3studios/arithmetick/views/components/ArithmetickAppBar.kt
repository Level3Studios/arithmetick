package net.level3studios.arithmetick.views.components

import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import net.level3studios.arithmetick.views.components.ui.theme.ArithmetickTheme


@Composable
fun ArithmetickTopBar(title: String) {
    LargeTopAppBar(title = { Text(text = title)},
    colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary,
    titleContentColor = MaterialTheme.colorScheme.onPrimary))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopBarLightPreview() {
    ArithmetickTheme {
        ArithmetickTopBar("Categories")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopBarDarkPreview() {
    ArithmetickTheme(darkTheme = true) {
        ArithmetickTopBar(title = "Categories")
    }
}