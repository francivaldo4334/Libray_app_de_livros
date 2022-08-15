package br.com.francivaldo.libray.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.francivaldo.libray.R
import br.com.francivaldo.libray.presentation.widget.itemBoockData
import br.com.francivaldo.libray.presentation.widget.itemBoockListRow

@Composable
fun layout_library(){
    val listItem = listOf<itemBoockData>(
        itemBoockData(),
        itemBoockData(),
        itemBoockData(),
        itemBoockData(),
        itemBoockData(),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
    ){
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = stringResource(R.string.library),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = stringResource(R.string.first_shelf),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        itemBoockListRow(items = listItem)
        Text(
            text = stringResource(R.string.second_shelf),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        itemBoockListRow(items = listItem)

    }
}