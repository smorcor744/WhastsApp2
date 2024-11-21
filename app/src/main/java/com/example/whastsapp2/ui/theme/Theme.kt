package com.example.whatsapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val colors = lightColorScheme(
    primary = WhatsAppGreen,
    secondary = WhatsAppDarkGray,
    background = WhatsAppBackgroundGray,
    surface = WhatsAppLightGray
)

val typography = Typography(
    TextStyle(
        fontSize = 16.sp
    )
)

@Composable
fun WhatsAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        content = content
    )
}