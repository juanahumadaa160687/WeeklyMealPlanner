package com.weeklyfoodplanner.weekyfoodplannerapp.components

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopSearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.weeklyfoodplanner.weekyfoodplannerapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(navController: NavController) {

    val label = when (navController.currentDestination?.route) {
        "sign-in" -> "Iniciar Sesión"
        "sign-up" -> "Registro de Usuario"
        "password-recovery" -> "Recuperar Contraseña"
        "minuta-semanal?user={id}" -> "Mi Minuta"
        "recetas?user={id}" -> "Recetas"
        "receta-detalle?user={userId}&receta={id}" -> "Detalles"
        "change-password?user={email}" -> "Cambiar Contraseña"
        else -> ""
    }

}