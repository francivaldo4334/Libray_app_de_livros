package br.com.francivaldo.libray.presentation.widget

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.francivaldo.libray.R
import br.com.francivaldo.libray.presentation.Screen

private enum class ItemSelected{
    ic_search,
    ic_library,
    ic_settings
}
private data class ItemData(@DrawableRes val icRes:Int, val itemSelected: ItemSelected, val onClick:()->Unit)
@Composable
private fun ItemUI(itemSelected: ItemSelected, itemData: ItemData){
    val size:Dp by  animateDpAsState(
        targetValue = if(itemSelected == itemData.itemSelected) 40.dp else 24.dp,
        animationSpec = tween(
            durationMillis = 300,
            easing = FastOutSlowInEasing
        )
    )
    val width = ((LocalConfiguration.current.screenWidthDp - 32)/3).dp
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(width)
            .fillMaxHeight()
            .clickable(onClick = itemData.onClick)
    ){
        Icon(
            painter = painterResource(id = itemData.icRes),
            contentDescription = null,
            tint = if(itemSelected == itemData.itemSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
            modifier = Modifier
                .size(size)
        )
    }
}
@Composable
fun BottomNavigationBar(navController: NavController){
    var item by remember {
        mutableStateOf(ItemSelected.ic_search)
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colors.background)
    ) {
        val listItems = listOf<ItemData>(
            ItemData(R.drawable.ic_search_page, ItemSelected.ic_search) {
                item = ItemSelected.ic_search
                //TODO//
                navController.navigate(Screen.Search().route) {
                    popUpTo(0)
                }
            },
            ItemData(R.drawable.ic_library_page, ItemSelected.ic_library) {
                item = ItemSelected.ic_library
                //TODO//
                navController.navigate(Screen.Library().route) {
                    popUpTo(0)
                }
            },
            ItemData(R.drawable.ic_settings_page, ItemSelected.ic_settings) {
                item = ItemSelected.ic_settings
                //TODO//
                navController.navigate(Screen.Settings().route) {
                    popUpTo(0)
                }
            },
        )
        LazyRow(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(listItems) {
                ItemUI(itemSelected = item, itemData = it)
            }
        }
    }
}