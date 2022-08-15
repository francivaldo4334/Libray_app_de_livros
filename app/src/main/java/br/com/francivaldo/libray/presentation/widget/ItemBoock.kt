package br.com.francivaldo.libray.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


data class itemBoockData(val urlImage:String = "")
@Composable
fun itemBoockListRow(items:List<itemBoockData>){
    LazyRow(
        modifier = Modifier
            .padding(vertical = 16.dp)
    )
    {
        items(items){
            itemBoockUi(item = it)
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}
@Composable
fun itemBoockUi(item: itemBoockData){
    Box(
        modifier = Modifier
            .width(100.dp)
            .heightIn(140.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.primary)
    )
}