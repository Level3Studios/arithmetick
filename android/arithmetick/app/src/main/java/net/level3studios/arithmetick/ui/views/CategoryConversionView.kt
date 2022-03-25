package net.level3studios.arithmetick.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.level3studios.arithmetick.ui.components.ArithmetickTopAppBar
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme
import net.level3studios.arithmetick.viewmodels.ConversionViewModel

@Composable
fun CategoryConversionView(viewModel: ConversionViewModel) {
    var inputValue by remember { mutableStateOf(TextFieldValue("")) }
    val shortText = viewModel.unitShortText.observeAsState().value

    Scaffold(topBar = { ArithmetickTopAppBar(title = viewModel.itemModel.itemTitle)}) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp))
        {
            Row(
                Modifier
                    .padding(start = 24.dp)
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                TextField(value = inputValue,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    textStyle = MaterialTheme.typography.labelMedium,
                    onValueChange = {
                        inputValue = it
                        viewModel.updateInputValue(it.text)
                    })
                Column(
                    Modifier
                        .padding(horizontal = 8.dp)
                        .height(50.dp)
                        .background(viewModel.itemModel.itemColor),
                    verticalArrangement = Arrangement.Center

                ) {
                    Text(shortText ?: "",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 12.dp))
                }
            }
            ConvertedResultsList(viewModel = viewModel)
        }
    }
}

@Composable
fun ConvertedResultsList(viewModel: ConversionViewModel) {
    val convertedList = viewModel.convertedList.observeAsState().value

    Column(
        Modifier.fillMaxWidth()) {
        Text("Results",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 12.dp))
        LazyColumn(modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer),
            contentPadding = PaddingValues(12.dp),
            content = {
                if (!convertedList.isNullOrEmpty()) {
                    items(convertedList) { item ->
                        Row(Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp)
                            .padding(vertical = 2.dp)
                            .clickable { viewModel.didSelectUnit(item.actualUnit) }) {
                            Text(item.displayValue,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                style = MaterialTheme.typography.bodyMedium)
                            Text(item.displayUnit,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = viewModel.itemModel.itemColor,
                                modifier = Modifier.padding(start = 12.dp))
                        }
                    }
                }
            })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConversionViewPreview() {
    ArithmetickTheme(useDarkTheme = false) {
        CategoryConversionView(viewModel = ConversionViewModel.testViewModel())
    }
}