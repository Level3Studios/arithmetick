package net.level3studios.arithmetick.views.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme


@Composable
fun ArithmetickTopBar(title: String) {
    LargeTopAppBar(title = { Text(text = title)},
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary))
}

@Composable
fun ArithmetickCompactTopBar(title: String) {
    SmallTopAppBar(title = { Text(text = title)},
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
    ArithmetickTheme(useDarkTheme = true) {
        ArithmetickTopBar(title = "Categories")
    }
}