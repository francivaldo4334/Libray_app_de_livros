package br.com.francivaldo.libray.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun layout_library(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D7E5B))
    )
}