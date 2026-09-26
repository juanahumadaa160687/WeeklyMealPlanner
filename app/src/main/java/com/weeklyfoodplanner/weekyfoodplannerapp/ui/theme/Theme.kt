package com.weeklyfoodplanner.weekyfoodplannerapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlin.time.Clock
import kotlinx.datetime.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime


private val DarkColorScheme = darkColorScheme(

    primary = primary_dark_a0,
    secondary = primary_dark_a10,
    tertiary = primary_dark_a20,

    surfaceBright = accent_dark,

    background = surface_dark_a0,
    surface = surface_dark_a10,
    onPrimary = primary_dark_a0,
    onSecondary = primary_dark_a10,
    onTertiary = primary_dark_a20,
    onBackground = primary_dark_a0,
    onSurface = primary_dark_a0,
    surfaceContainer = tonal_dark_a0,
    surfaceContainerLow = tonal_dark_a10,
    surfaceContainerLowest = tonal_dark_a20,
    surfaceContainerHigh = tonal_dark_a30,
    surfaceVariant = tonal_dark_a40,
    surfaceContainerHighest = tonal_dark_a50,

    )

private val LightColorScheme = lightColorScheme(

    primary = primary_light_a0,
    secondary = primary_light_a10,
    tertiary = primary_light_a20,

    background = surface_light_a0,
    surface = surface_light_a10,
    onPrimary = primary_light_a20,
    onSecondary = primary_light_a10,
    onTertiary = primary_light_a0,
    onBackground = primary_light_a20,
    onSurface = primary_light_a20,

    surfaceContainer = tonal_a0,
    surfaceContainerLow = tonal_a10,
    surfaceContainerLowest = tonal_a20,
    surfaceContainerHigh = tonal_a30,
    surfaceVariant = tonal_a40,
    surfaceContainerHighest = tonal_a50,

    )


@OptIn(ExperimentalTime::class)
@Composable
fun WeekyFoodPlannerAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit
) {

    var darkTheme by remember { mutableStateOf(darkTheme) }

    var currentDateTime by remember { mutableStateOf(Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())) }

    LaunchedEffect(Unit) {

        while (true) {
            currentDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            delay(1800000.milliseconds) // Update every 30 minutes

            if (currentDateTime.hour in 8..19 && darkTheme) {
                // Switch to light theme during daytime
                darkTheme = false
            } else if (currentDateTime.hour !in 8..19 && !darkTheme) {
                // Switch to dark theme during nighttime
                darkTheme = true
            }
        }
    }

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme


    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}