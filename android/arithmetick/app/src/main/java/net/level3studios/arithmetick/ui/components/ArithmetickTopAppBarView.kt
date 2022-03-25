package net.level3studios.arithmetick.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme


@Composable
fun ArithmetickTopAppBar(title: String) {
    TopAppBar(title = { Text(title,
        color = MaterialTheme.colorScheme.onPrimary)},
    backgroundColor = MaterialTheme.colorScheme.primary)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TopBarLightPreview() {
    ArithmetickTheme {
        ArithmetickTopAppBar("Title")
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TopBarDarkPreview() {
    ArithmetickTheme(useDarkTheme = true) {
        ArithmetickTopAppBar("Title")
    }
}
