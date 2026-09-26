package com.weeklyfoodplanner.weekyfoodplannerapp.views

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.clearText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldState
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldValue
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.weeklyfoodplanner.weekyfoodplannerapp.R
import com.weeklyfoodplanner.weekyfoodplannerapp.components.AppPrimaryButton
import com.weeklyfoodplanner.weekyfoodplannerapp.data.usuarios
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePasswordView(navController: NavController, email: String){

    val passwordFieldState = TextFieldState()
    val confirmpasswordFieldState = TextFieldState()

    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    val userEmail = email

    val user = usuarios.find { it.email == userEmail }

    val navItems = listOf(
        NavItem("Iniciar\nSesión", "sign-in", R.drawable.ic_login),
        NavItem("Registrarse", "sign-up", R.drawable.ic_register),
        NavItem("Recuperar\nContraseña", "password-recovery", R.drawable.ic_forgot_password),
    )

    val state = rememberNavigationSuiteScaffoldState()

    val snackbarHostState = remember { SnackbarHostState() }

    val snackbarScope = rememberCoroutineScope()

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
                        else -> Modifier.padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                    }
                )
            }
        }
    ) {
        Scaffold(

            snackbarHost = { SnackbarHost(snackbarHostState) },

            ){
            Column(modifier = Modifier
                .fillMaxSize()
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
                                text = "Recuperar Contraseña",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.background,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                            Spacer(modifier = Modifier.size(8.dp))

                            Text(
                                text = "Por favor ingrese su correo electrónico para restablecer su contraseña.",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.background,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        SecureTextField(
                            state = passwordFieldState,
                            label = { Text(text = "Contraseña") },
                            placeholder = { Text(text = "Ingresa tu contraseña") },
                            textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                            modifier = Modifier
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

                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        SecureTextField(
                            state = confirmpasswordFieldState,
                            label = { Text(text = "Confirmar Contraseña") },
                            placeholder = { Text(text = "Ingresa tu contraseña nuevamente") },
                            textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
                            modifier = Modifier
                                .padding(top = 20.dp)
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

                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AppPrimaryButton(
                            text = "Enviar",
                            onClick = {

                                if (passwordFieldState.text == confirmpasswordFieldState.text) {
                                    user?.password = passwordFieldState.text.toString()
                                    snackbarScope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "Contraseña cambiada exitosamente",
                                            duration = SnackbarDuration.Short,
                                            actionLabel = "OK",
                                        )
                                        when (snackbarHostState.showSnackbar(
                                            message = "Contraseña cambiada exitosamente",
                                            duration = SnackbarDuration.Short,
                                            actionLabel = "OK"
                                        )) {
                                            SnackbarResult.ActionPerformed -> {
                                                navController.navigate("sign-in")
                                            }

                                            SnackbarResult.Dismissed -> {
                                                snackbarHostState.currentSnackbarData?.dismiss()
                                            }
                                        }
                                    }
                                } else {

                                    snackbarScope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "Las contraseñas no coinciden",
                                            duration = SnackbarDuration.Short,
                                            actionLabel = "OK",
                                            withDismissAction = true
                                        )
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
