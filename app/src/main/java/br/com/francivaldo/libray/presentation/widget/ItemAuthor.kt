package br.com.francivaldo.libray.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

data class itemAuthorData(val urlImage:String = "")
@Composable
fun itemAuthorListRow(items:List<itemAuthorData>){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(vertical = 16.dp)
    )
    {
        items(items){
            itemAuthorUi(item = it)
        }
    }
}
@Composable
fun itemAuthorUi(item: itemAuthorData){
    Box(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
    )
}