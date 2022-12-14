package br.com.francivaldo.libray.presentation.pages

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.francivaldo.libray.R
import br.com.francivaldo.libray.presentation.Common
import br.com.francivaldo.libray.presentation.bloc.SearchResultActivity
import br.com.francivaldo.libray.presentation.widget.*

@Composable
fun layout_search(){
    val listItem = listOf<itemBoockData>(
        itemBoockData(),
        itemBoockData(),
        itemBoockData(),
        itemBoockData(),
        itemBoockData(),
    )
    val listItemAuthor = listOf<itemAuthorData>(
        itemAuthorData(),
        itemAuthorData(),
        itemAuthorData(),
        itemAuthorData(),
        itemAuthorData(),
        itemAuthorData(),
        itemAuthorData(),
    )
    val activity = LocalContext.current as Activity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(start = 16.dp)
    ){
        Spacer(modifier = Modifier.size(32.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp)){
            Text(
                text = stringResource(R.string.search),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.size(32.dp))
        SearchTextField{
            activity.startActivity(Intent(activity, SearchResultActivity::class.java))
        }
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = stringResource(R.string.brazilians),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        itemBoockListRow(items = listItem)
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = stringResource(R.string.popular_authors),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        itemAuthorListRow(items = listItemAuthor)

    }
}