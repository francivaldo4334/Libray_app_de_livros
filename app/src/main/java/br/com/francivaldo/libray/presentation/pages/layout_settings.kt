package br.com.francivaldo.libray.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.francivaldo.libray.R

@Composable
fun layout_settings(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){
        Spacer(modifier = Modifier.size(56.dp))
        Text(text = stringResource(R.string.settings), fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.size(8.dp))
        Box(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.onBackground))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp)
            )
            {
                Text(text = stringResource(R.string.activate_dark_theme))
            }
            Box(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.onBackground))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp)
            )
            {
                Text(text = stringResource(R.string.select_language))
            }
        }
    }
}