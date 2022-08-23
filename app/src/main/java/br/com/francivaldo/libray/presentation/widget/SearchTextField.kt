package br.com.francivaldo.libray.presentation.widget

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import br.com.francivaldo.libray.R
import br.com.francivaldo.libray.presentation.Common
import br.com.francivaldo.libray.presentation.bloc.SearchResultActivity

@Composable
fun SearchTextField(onclick:()-> Unit = {}){
    var textfieldValue by remember {
        mutableStateOf("")
    }
    TextField(
        value = textfieldValue,
        onValueChange ={ textfieldValue = it },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.onPrimary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.Black
        ),
        shape = RoundedCornerShape(16.dp),
        trailingIcon = {
            IconButton(onClick = {
                if(!(textfieldValue.isEmpty() || textfieldValue.isBlank())) {
                    Common.getMyViewModel().search(textfieldValue)
                }
                onclick.invoke()
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null,tint = Color.Black)
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            if(!(textfieldValue.isEmpty() || textfieldValue.isBlank())) {
                Common.getMyViewModel().search(textfieldValue)
            }
            onclick.invoke()
        }),
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp)
    )
}