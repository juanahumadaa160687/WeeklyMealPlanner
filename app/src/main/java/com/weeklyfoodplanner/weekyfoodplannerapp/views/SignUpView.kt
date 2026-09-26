package com.weeklyfoodplanner.weekyfoodplannerapp.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.clearText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.weeklyfoodplanner.weekyfoodplannerapp.R
import com.weeklyfoodplanner.weekyfoodplannerapp.components.AppPrimaryButton
import com.weeklyfoodplanner.weekyfoodplannerapp.data.usuarios
import com.weeklyfoodplanner.weekyfoodplannerapp.models.Usuario
import kotlinx.coroutines.launch

data class OptionItem(val name: String, var isSelected: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpView(navController: NavController) {

    val nombreFieldState = TextFieldState()
    val apellidoFieldState = TextFieldState()
    val emailFieldState = TextFieldState()
    val edadFieldState = TextFieldState()
    val passwordFieldState = TextFieldState()
    val confirmpasswordFieldState = TextFieldState()
    val otrosState = TextFieldState()

    val alergias = remember {mutableStateListOf(
        OptionItem("Ninguna", false),
        OptionItem("Gluten", false),
        OptionItem("Lactosa", false),
        OptionItem("Huevo", false),
        OptionItem("Soja", false),
        OptionItem("Otra", false)
    )}

    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    val navItems = listOf(
        NavItem("Iniciar\nSesión", "sign-in", R.drawable.ic_login),
        NavItem("Registrarse", "sign-up", R.drawable.ic_register),
        NavItem("Recuperar\nContraseña", "password-recovery", R.drawable.ic_forgot_password),
    )

    val state = rememberNavigationSuiteScaffoldState()

    val snackbarScope = rememberCoroutineScope()

    val snackbarHostState = remember { SnackbarHostState() }

    NavigationSuiteScaffold(
        modifier = Modifier.fillMaxSize(),
        navigationSuiteType = when {
            currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> NavigationSuiteType.NavigationBar
            else -> NavigationSuiteType.NavigationRail
        },
        state = state,
        primaryActionContentHorizontalAlignment = Alignment.Start,
        navigationItemVerticalArrangement = Arrangement.Center,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = MaterialTheme.colorScheme.primary,
            navigationRailContainerColor = MaterialTheme.colorScheme.primary,
        ),
        navigationItems = {
            navItems.forEach { item ->
                NavigationSuiteItem(
                    label = {
                        Text(
                            text = item.label,
                            textAlign = TextAlign.Center,
                            style =
                                when {
                                    currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> MaterialTheme.typography.labelLarge
                                    else -> MaterialTheme.typography.labelMedium
                                }
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.iconResId),
                            contentDescription = item.label,
                            modifier = when {
                                currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> Modifier.size(24.dp)
                                else -> Modifier.size(20.dp)
                            },
                        )
                    },
                    onClick = {
                        navController.navigate(item.route)
                    },
                    selected = navController.currentDestination?.route == item.route,
                    colors = NavigationItemColors(
                        selectedTextColor = when {
                            currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> MaterialTheme.colorScheme.background
                            else -> MaterialTheme.colorScheme.primary
                        },
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedTextColor = MaterialTheme.colorScheme.background,
                        unselectedIconColor = MaterialTheme.colorScheme.background,
                        selectedIndicatorColor = MaterialTheme.colorScheme.background,
                        disabledTextColor = MaterialTheme.colorScheme.background,
                        disabledIconColor = MaterialTheme.colorScheme.background,
                    ),
                    modifier = when {
                        currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> Modifier.padding(top = 12.dp)
                        else -> Modifier.padding(top = 4.dp, bottom = 4.dp)
                    }
                )
            }
        }
    ) {
        Scaffold(

            snackbarHost = { SnackbarHost(hostState = snackbarHostState,
                snackbar = { data ->
                    Snackbar(
                        data,
                        actionOnNewLine = true,
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        actionContentColor = MaterialTheme.colorScheme.onPrimary,
                    )
                },
            )},

            ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth().height(when{
                        currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> 200.dp
                        else -> 100.dp
                    }),
                    shape = RoundedCornerShape(bottomEnd = 110.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize().padding(bottom = 16.dp, top = 16.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Bienvenido",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.background,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                            Spacer(modifier = Modifier.size(4.dp))

                            Text(
                                text = "Registrate para empezar a usar la\naplicación",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.background,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    item {
                        Box(
                            modifier = Modifier.padding(top = 16.dp).fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            TextField(
                                state = nombreFieldState,
                                placeholder = { Text(text = "Ingrese su nombre") },
                                label = {
                                    Text(
                                        text = "Nombre",
                                        fontStyle = MaterialTheme.typography.bodySmall.fontStyle
                                    )
                                },
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .width(350.dp)
                                    .height(56.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,

                                    focusedLabelColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,

                                    focusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),
                                    unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),

                                    focusedTextColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                ),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_clear),
                                        contentDescription = "Limpiar campo de texto",
                                        modifier = Modifier
                                            .requiredSize(20.dp)
                                            .clickable { nombreFieldState.clearText() },
                                        tint = MaterialTheme.colorScheme.tertiary
                                    )
                                }
                            )
                        }
                    }
                    item {
                        Box(modifier = Modifier.padding(top = 16.dp)) {
                            TextField(
                                state = apellidoFieldState,
                                placeholder = { Text(text = "Ingrese su Apellido") },
                                label = {
                                    Text(
                                        text = "Apellido",
                                        fontStyle = MaterialTheme.typography.bodySmall.fontStyle
                                    )
                                },
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .width(350.dp)
                                    .height(56.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,

                                    focusedLabelColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,

                                    focusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),
                                    unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),

                                    focusedTextColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                ),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_clear),
                                        contentDescription = "Limpiar campo de texto",
                                        modifier = Modifier
                                            .requiredSize(20.dp)
                                            .clickable { apellidoFieldState.clearText() },
                                        tint = MaterialTheme.colorScheme.tertiary
                                    )
                                }
                            )
                        }
                    }
                    item {
                        Box(modifier = Modifier.padding(top = 16.dp)) {
                            TextField(
                                state = emailFieldState,
                                placeholder = { Text(text = "Ingrese su correo electrónico") },
                                label = {
                                    Text(
                                        text = "Correo electrónico",
                                        fontStyle = MaterialTheme.typography.bodySmall.fontStyle
                                    )
                                },
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .width(350.dp)
                                    .height(56.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,

                                    focusedLabelColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,

                                    focusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),
                                    unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),

                                    focusedTextColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                ),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_clear),
                                        contentDescription = "Limpiar campo de texto",
                                        modifier = Modifier
                                            .requiredSize(20.dp)
                                            .clickable { emailFieldState.clearText() },
                                        tint = MaterialTheme.colorScheme.tertiary
                                    )
                                }
                            )
                        }
                    }
                    item {
                        Box(modifier = Modifier.padding(top = 16.dp)) {
                            TextField(
                                state = edadFieldState,
                                placeholder = { Text(text = "Ingrese su edad") },
                                label = {
                                    Text(
                                        text = "Edad",
                                        fontStyle = MaterialTheme.typography.bodySmall.fontStyle
                                    )
                                },
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .width(350.dp)
                                    .height(56.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,

                                    focusedLabelColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,

                                    focusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),
                                    unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),

                                    focusedTextColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                ),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_clear),
                                        contentDescription = "Limpiar campo de texto",
                                        modifier = Modifier
                                            .requiredSize(20.dp)
                                            .clickable { edadFieldState.clearText() },
                                        tint = MaterialTheme.colorScheme.tertiary
                                    )
                                }
                            )
                        }
                    }

                    item {
                        Box(modifier = Modifier.padding(top = 16.dp)) {
                            SecureTextField(
                                state = passwordFieldState,
                                label = { Text(text = "Contraseña") },
                                placeholder = { Text(text = "Ingresa tu contraseña") },
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .width(350.dp)
                                    .height(56.dp),

                                colors = TextFieldDefaults.colors(

                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,

                                    focusedLabelColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,

                                    focusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),
                                    unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),

                                    focusedTextColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                ),

                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = if (showPassword) R.drawable.ic_visibility else R.drawable.ic_visibility_off),
                                        contentDescription = if (showPassword) "Ocultar contraseña" else "Mostrar contraseña",
                                        modifier = Modifier
                                            .requiredSize(20.dp)
                                            .clickable { showPassword = !showPassword },
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                },
                                textObfuscationMode = if (showPassword) TextObfuscationMode.Visible else TextObfuscationMode.RevealLastTyped,
                            )
                        }
                    }
                    item {

                        Box(modifier = Modifier.padding(top = 16.dp)) {

                            SecureTextField(
                                state = confirmpasswordFieldState,
                                label = { Text(text = "Confirmar Contraseña") },
                                placeholder = { Text(text = "Confirma tu contraseña") },
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                                modifier = Modifier
                                    .padding(top = 16.dp, bottom = 16.dp)
                                    .width(350.dp)
                                    .height(56.dp),

                                colors = TextFieldDefaults.colors(

                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,

                                    focusedLabelColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,

                                    focusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),
                                    unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),

                                    focusedTextColor = MaterialTheme.colorScheme.tertiary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                ),

                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = if (showConfirmPassword) R.drawable.ic_visibility else R.drawable.ic_visibility_off),
                                        contentDescription = if (showConfirmPassword) "Ocultar contraseña" else "Mostrar contraseña",
                                        modifier = Modifier
                                            .requiredSize(20.dp)
                                            .clickable { showConfirmPassword = !showConfirmPassword },
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                },
                                textObfuscationMode = if (showConfirmPassword) TextObfuscationMode.Visible else TextObfuscationMode.RevealLastTyped,
                            )
                        }
                    }
                    item{

                        Column (
                            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Alergias Alimentarias",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(start = 8.dp)
                            )

                            alergias.forEachIndexed { index, item ->
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = item.isSelected,
                                        onCheckedChange = { isChecked ->
                                            alergias[index] = item.copy(isSelected = isChecked)
                                        },
                                        modifier = Modifier.padding(end = 8.dp),
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = MaterialTheme.colorScheme.primary,
                                            uncheckedColor = MaterialTheme.colorScheme.primary,
                                            checkmarkColor = MaterialTheme.colorScheme.background
                                        )
                                    )
                                    Text(
                                        text = item.name,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }

                                if (item.name == "Otra" && item.isSelected){
                                    Spacer(modifier = Modifier.size(8.dp))

                                    TextField(
                                        state = otrosState,
                                        label = { Text(text = "¿Cuál?") },
                                        textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                                        modifier = Modifier
                                            .padding(top = 16.dp)
                                            .width(350.dp)
                                            .height(56.dp),
                                        colors = TextFieldDefaults.colors(
                                            focusedContainerColor = Color.Transparent,
                                            unfocusedContainerColor = Color.Transparent,
                                            focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                                            unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,

                                            focusedLabelColor = MaterialTheme.colorScheme.tertiary,
                                            unfocusedLabelColor = MaterialTheme.colorScheme.primary,

                                            focusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),
                                            unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.6f),

                                            focusedTextColor = MaterialTheme.colorScheme.tertiary,
                                            unfocusedTextColor = MaterialTheme.colorScheme.primary,
                                        ),
                                        trailingIcon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_add_circle),
                                                contentDescription = "Agregar alergia",
                                                modifier = Modifier
                                                    .requiredSize(24.dp)
                                                    .clickable {
                                                        alergias.add(OptionItem(otrosState.toString(), false))
                                                    },
                                                tint = MaterialTheme.colorScheme.tertiary
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(top = 16.dp, bottom = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            AppPrimaryButton(text = "Enviar", onClick = {

                                snackbarScope.launch {
                                    if (nombreFieldState.text.isBlank() || apellidoFieldState.text.isBlank() || emailFieldState.text.isBlank() || edadFieldState.text.isBlank() || passwordFieldState.text.isBlank() || confirmpasswordFieldState.text.isBlank()) {
                                        snackbarHostState.showSnackbar("Por favor, completa todos los campos.", actionLabel = "OK", withDismissAction = false, duration = SnackbarDuration.Short)
                                    } else if (passwordFieldState.text != confirmpasswordFieldState.text) {
                                        snackbarHostState.showSnackbar("Las contraseñas no coinciden.", actionLabel = "OK", withDismissAction = false, duration = SnackbarDuration.Short)
                                    } else {


                                        val nuevoUsuario = Usuario(
                                            id = usuarios.size + 1,
                                            nombre = nombreFieldState.text as String,
                                            apellido = apellidoFieldState.text as String,
                                            email = emailFieldState.text as String,
                                            edad = edadFieldState.text.toString().toIntOrNull() ?: 0,
                                            password = passwordFieldState.text as String,
                                            alergias = alergias.filter { it.isSelected }.map { it.name } as MutableList<String>
                                        )
                                        usuarios.add(nuevoUsuario)

                                        snackbarHostState.showSnackbar(
                                            message = "Registro exitoso. ¡Bienvenido, ${nuevoUsuario.nombre}!",
                                            actionLabel = "OK",
                                            withDismissAction = false,
                                            duration = SnackbarDuration.Short
                                        )
                                    }
                                }
                            })
                        }
                    }
                }
            }
        }
    }
}