package br.com.francivaldo.libray.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class itemSearchData(val urlImage:String = "",val title:String,val author:String,val description:String)
@Composable
fun itemSearcListColumn(items:List<itemSearchData>){
    LazyColumn()
    {
        items(items){
            itemSearcUi(item = it)
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}
@Composable
fun itemSearcUi(item: itemSearchData){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row() {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .heightIn(140.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colors.primary)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column() {
                Text(text = item.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = item.author, fontSize = 14.sp)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = item.description, fontSize = 10.sp)
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(1.dp)
                .background(MaterialTheme.colors.surface)
        )
    }
}