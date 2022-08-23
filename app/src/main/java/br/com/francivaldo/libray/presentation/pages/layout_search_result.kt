package br.com.francivaldo.libray.presentation.pages

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.francivaldo.libray.R
import br.com.francivaldo.libray.presentation.Common
import br.com.francivaldo.libray.presentation.bloc.SearchResultActivity
import br.com.francivaldo.libray.presentation.widget.SearchTextField
import br.com.francivaldo.libray.presentation.widget.itemSearcListColumn

@Composable
fun layout_search_result(){
    var textfieldValue by remember {
        mutableStateOf("")
    }
    val activity = LocalContext.current as Activity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(top = 16.dp, end = 16.dp, start = 16.dp)
    ){
        IconButton(onClick = {
            activity.onBackPressed()
        }) {
            Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = null,tint = MaterialTheme.colors.onBackground)
        }
        Spacer(modifier = Modifier.size(32.dp))
        SearchTextField()
        Spacer(modifier = Modifier.size(32.dp))
        itemSearcListColumn()
    }
}