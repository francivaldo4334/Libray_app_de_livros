package br.com.francivaldo.libray.presentation.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import br.com.francivaldo.libray.presentation.Common

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = primary,
    primaryVariant = primary,
    secondary = primary,
    background = backgroud_dark,
    surface = surface_dark,
    onPrimary = on_primary,
    onSecondary = on_dark,
    onBackground = on_dark,
    onSurface = on_dark,
)
@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = primary,
    secondary = primary,
    background = backgroud_light,
    surface = surface_light,
    onPrimary = on_primary,
    onSecondary = on_light,
    onBackground = on_light,
    onSurface = on_light,
)

@Composable
fun LibrayTheme(darkTheme: Boolean = Common.isDark, content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}