package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DevotionalColorScheme =
  darkColorScheme(
    primary = SaffronPrimary,
    onPrimary = SacredIvory,
    primaryContainer = SaffronDark,
    onPrimaryContainer = GoldLight,
    secondary = GoldAccent,
    onSecondary = MaroonDarkest,
    secondaryContainer = MaroonCard,
    onSecondaryContainer = GoldAccent,
    tertiary = SaffronLight,
    background = MaroonDeep,
    onBackground = SacredIvory,
    surface = MaroonCard,
    onSurface = SacredIvory,
    surfaceVariant = MaroonSurface,
    onSurfaceVariant = SacredIvoryMuted,
    outline = GoldDark,
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colorScheme = DevotionalColorScheme,
    typography = Typography,
    content = content,
  )
}

