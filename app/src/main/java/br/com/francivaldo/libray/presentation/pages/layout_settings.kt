package br.com.francivaldo.libray.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.francivaldo.libray.R
import br.com.francivaldo.libray.presentation.Common

@Composable
fun layout_settings(){
    val textportugues:String = stringResource(R.string.portugues)
    val textingles:String = stringResource(R.string.ingles)
    var textlanguage by remember {
        mutableStateOf(textportugues)
    }
    var menuExpanded by remember {
        mutableStateOf(false)
    }
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp)
            )
            {
                Text(text = stringResource(R.string.activate_dark_theme))
                Switch(
                    checked = Common.isDark,
                    onCheckedChange = {Common.isDark = it}
                )
            }
            Box(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.onBackground))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp)
            )
            {
                Text(text = stringResource(R.string.select_language))
                Box(
                    modifier = Modifier
                        .height(32.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colors.surface)
                        .padding(start = 16.dp)
                        .clickable {
                            menuExpanded = true
                        }
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = textlanguage,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_more_options),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        DropdownMenu(expanded = menuExpanded, onDismissRequest = {menuExpanded = false}) {
                            DropdownMenuItem(onClick = {
                                textlanguage = textportugues
                                menuExpanded = false
                            }) {
                                Text(text = stringResource(R.string.portugues), fontSize = 12.sp)
                            }
                            DropdownMenuItem(onClick = {
                                textlanguage = textingles
                                menuExpanded = false
                            }) {
                                Text(text = stringResource(R.string.ingles), fontSize = 12.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}