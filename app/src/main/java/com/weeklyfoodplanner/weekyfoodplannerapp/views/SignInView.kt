package com.weeklyfoodplanner.weekyfoodplannerapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationItemColors
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.res.painterResource
import com.weeklyfoodplanner.weekyfoodplannerapp.R
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weeklyfoodplanner.weekyfoodplannerapp.components.AppPrimaryButton
import com.weeklyfoodplanner.weekyfoodplannerapp.data.usuarios
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInView(navController: NavController) {

    val emailTextFieldState = rememberTextFieldState("")
    val passwordTextFieldState = remember { TextFieldState() }
    var showPassword by remember { mutableStateOf(false) }

    val navItems = listOf(
        NavItem("Iniciar Sesión", "sign-in", R.drawable.ic_login),
        NavItem("Registrarse", "sign-up", R.drawable.ic_register),
        NavItem("Recuperar Contraseña", "password-recovery", R.drawable.ic_forgot_password),
    )

    val state = rememberNavigationSuiteScaffoldState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


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
                        contentColor = MaterialTheme.colorScheme.background,
                        actionContentColor = MaterialTheme.colorScheme.background,
                    )
                },
            )},


            ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            when {
                                currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> 200.dp
                                else -> 100.dp
                            }
                        ),
                    shape = RoundedCornerShape(bottomEnd = 110.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 16.dp, top = 16.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.white_logo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .padding(start = 8.dp),
                            tint = MaterialTheme.colorScheme.background
                        )

                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Bienvenido de nuevo",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.background,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                            Spacer(modifier = Modifier.size(4.dp))

                            Text(
                                text = "Inicia sesión para continuar",
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item{
                        Spacer(modifier = Modifier.height(24.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(24.dp))

                            TextField(
                                state = emailTextFieldState,
                                placeholder = { Text(text = "Ingrese su correo electrónico") },
                                label = {
                                    Text(
                                        text = "Correo electrónico",
                                        fontStyle = MaterialTheme.typography.bodySmall.fontStyle
                                    )
                                },
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
                                        painter = painterResource(id = R.drawable.ic_clear),
                                        contentDescription = "Limpiar campo de texto",
                                        modifier = Modifier
                                            .requiredSize(20.dp)
                                            .clickable { emailTextFieldState.clearText() },
                                        tint = MaterialTheme.colorScheme.tertiary
                                    )
                                }
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            SecureTextField(
                                state = passwordTextFieldState,
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

                            Spacer(modifier = Modifier.height(24.dp))

                            AppPrimaryButton(text = "Iniciar sesión", onClick = {

                                val email = "jhon.doe@example.com" //emailTextFieldState.text
                                val password = "password123" //passwordTextFieldState.text

                                val usuario =
                                    usuarios.find { it.email == email && it.password == password }


                                scope.launch {
                                    when (usuario != null) {
                                        true -> {
                                            //navController.navigate("minuta-semanal?user=${usuario.id}")
                                        }

                                        false -> {
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "Correo electrónico o contraseña incorrectos",
                                                    duration = SnackbarDuration.Short,
                                                    actionLabel = "OK",
                                                    withDismissAction = false,
                                                )
                                            }
                                        }
                                    }
                                }
                            })
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                    }
                    item{
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            HorizontalDivider(
                                thickness = 1.dp,
                                color = Color.Gray.copy(alpha = 0.6f),
                                modifier = Modifier.width(120.dp)
                            )
                            Text(
                                text = "O",
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(16.dp)
                            )
                            HorizontalDivider(
                                thickness = 1.dp,
                                color = Color.Gray.copy(alpha = 0.6f),
                                modifier = Modifier.width(120.dp)
                            )
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            ),
                            modifier = Modifier
                                .width(300.dp)
                                .height(65.dp)
                                .padding(8.dp)
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.ic_google),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(24.dp)
                            )

                            Text(
                                text = "Continuar con Google",
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 16.dp)
                            )

                        }
                    }
                }
            }
        }
    }
}

data class NavItem(
    val label: String,
    val route: String,
    val iconResId: Int
)

