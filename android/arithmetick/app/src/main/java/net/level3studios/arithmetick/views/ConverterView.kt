package net.level3studios.arithmetick.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import net.level3studios.arithmetick.ui.theme.ArithmetickTheme
import net.level3studios.arithmetick.viewmodels.ConverterViewModel
import net.level3studios.arithmetick.views.components.ArithmetickCompactTopBar


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ConverterView(viewModel: ConverterViewModel) {
    var inputValue by remember { mutableStateOf(TextFieldValue("")) }
    val shortText = viewModel.unitShortText.observeAsState().value

    Scaffold(topBar = { ArithmetickCompactTopBar(title = viewModel.option.displayLabel)}) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)) {
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
                        .background(viewModel.option.itemColor),
                    verticalArrangement = Arrangement.Center) {
                    Text(shortText ?: "",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 12.dp))
                }
            }
            ConvertedResultList(viewModel = viewModel)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ConvertedResultList(viewModel: ConverterViewModel) {
    val convertedItems = viewModel.convertedList.observeAsState().value

    Column(Modifier.fillMaxWidth()) {
        Text("Results",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 12.dp))
        LazyColumn(contentPadding = PaddingValues(12.dp),
            content = {
                if (!convertedItems.isNullOrEmpty()) {
                    items(convertedItems) { item ->
                        Row(Modifier.fillMaxWidth()
                            .padding(start = 12.dp)
                            .clickable { viewModel.didSelectUnit(item.actualUnit) }) {
                            Text(text = item.displayValue,
                                style = MaterialTheme.typography.bodyMedium)
                            Text(text = item.displayUnit,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = viewModel.option.itemColor,
                                modifier = Modifier.padding(start = 8.dp))

                        }
                    }
                }
            })
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightConverterPreview() {
    ArithmetickTheme {
        ConverterView(ConverterViewModel.testViewModel())
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DarkConverterPreview() {
    ArithmetickTheme(useDarkTheme = true) {
        ConverterView(ConverterViewModel.testViewModel())
    }
}