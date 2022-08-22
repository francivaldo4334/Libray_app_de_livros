package br.com.francivaldo.libray.presentation.widget

import androidx.compose.foundation.Image
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
import br.com.francivaldo.libray.presentation.Common
import br.com.francivaldo.libray.presentation.model.UiModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun itemSearcListColumn(){
    LazyColumn()
    {
        items(Common.getMyViewModel().bookList){
            itemSearcUi(item = it)
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}
@Composable
fun itemSearcUi(item: UiModel){
    val image = rememberAsyncImagePainter(model = item.image_url)
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row() {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .heightIn(140.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colors.onPrimary)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column() {
                Text(text = item.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = item.author, fontSize = 14.sp, maxLines = 1)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = item.description, fontSize = 10.sp, maxLines = 7)
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