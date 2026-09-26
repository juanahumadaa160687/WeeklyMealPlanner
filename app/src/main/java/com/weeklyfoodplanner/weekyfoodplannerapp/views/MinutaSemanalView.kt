package com.weeklyfoodplanner.weekyfoodplannerapp.views

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.BottomAppBarState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldState
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldValue
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.weeklyfoodplanner.weekyfoodplannerapp.R
import com.weeklyfoodplanner.weekyfoodplannerapp.components.AppTopBar
import com.weeklyfoodplanner.weekyfoodplannerapp.components.AppUserMenuCard
import com.weeklyfoodplanner.weekyfoodplannerapp.data.minutaSemanal
import com.weeklyfoodplanner.weekyfoodplannerapp.data.recetas
import com.weeklyfoodplanner.weekyfoodplannerapp.models.Comidas
import com.weeklyfoodplanner.weekyfoodplannerapp.models.Minuta
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MinutaSemanalView(navController: NavController, userId: Int) {

    val userId = userId

    val minutaUsuario = minutaSemanal.filter { it.id_usuario == userId }

    val navItems = listOf(
        NavItem("Mi Minuta", "sign-in", R.drawable.ic_menu_food),
        NavItem("Recetas", "recetas?user={id}", R.drawable.ic_recipe),
        NavItem("Cerrar Sesión", "index", R.drawable.ic_logout),
    )

    val state = rememberNavigationSuiteScaffoldState()

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
                        currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> Modifier.padding(top = 8.dp)
                        else -> Modifier.padding(top = 4.dp, bottom = 4.dp)
                    }
                )
            }
        }
    ) {
        Scaffold(

        ){

            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                stickyHeader {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Card(
                            modifier = Modifier.fillMaxWidth().height(
                                when {
                                    currentWindowAdaptiveInfoV2().windowSizeClass.minWidthDp <= 800 -> 150.dp
                                    else -> 100.dp
                                }
                            ),
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
                                        text = "Minuta Semanal",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.background,
                                        modifier = Modifier.padding(start = 16.dp)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Planifica tus comidas de la semana",
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.background,
                                        modifier = Modifier.padding(start = 16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                if (minutaUsuario.isEmpty()) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AppMinutaButton(userId)
                        }
                    }

                    item {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically

                        ) { AppMinutaButton(userId) }

                    }

                } else {
                    minutaUsuario.forEach { minuta ->
                        item {
                            Surface(
                                modifier = Modifier.fillMaxSize().padding(top = 12.dp),
                                color = MaterialTheme.colorScheme.tertiary
                            ) {
                                Text(
                                    text = minuta.dia,
                                    modifier = Modifier.padding(8.dp),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.background
                                )
                            }
                        }

                        item{
                            Column(
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                minuta.recetas.forEach { receta ->
                                    AppUserMenuCard(
                                        nombre = receta.nombre,
                                        imagen = receta.imagen,
                                        horario = receta.tipo_comida,
                                        navController = navController,
                                        user = userId,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AppMinutaButton(userId: Int){

    var minuta1: Minuta
    var minuta2: Minuta
    var minuta3: Minuta
    var minuta4: Minuta
    var minuta5: Minuta
    var minuta6: Minuta
    var minuta7: Minuta


    Button(
        onClick = {

            minuta1 = Minuta(id = 1, id_usuario = userId, dia = "Lunes", recetas = recetas.filter { it.tipo_comida == Comidas.DESAYUNO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.ALMUERZO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.CENA }.shuffled().take(1))
            minuta2 = Minuta(id = 2, id_usuario = userId, dia = "Martes", recetas = recetas.filter { it.tipo_comida == Comidas.DESAYUNO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.ALMUERZO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.CENA }.shuffled().take(1))
            minuta3 = Minuta(id = 3, id_usuario = userId, dia = "Miércoles", recetas = recetas.filter { it.tipo_comida == Comidas.DESAYUNO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.ALMUERZO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.CENA }.shuffled().take(1))
            minuta4 = Minuta(id = 4, id_usuario = userId, dia = "Jueves", recetas = recetas.filter { it.tipo_comida == Comidas.DESAYUNO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.ALMUERZO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.CENA }.shuffled().take(1))
            minuta5 = Minuta(id = 5, id_usuario = userId, dia = "Viernes", recetas = recetas.filter { it.tipo_comida == Comidas.DESAYUNO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.ALMUERZO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.CENA }.shuffled().take(1))
            minuta6 = Minuta(id = 6, id_usuario = userId, dia = "Sábado", recetas = recetas.filter { it.tipo_comida == Comidas.DESAYUNO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.ALMUERZO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.CENA }.shuffled().take(1))
            minuta7 = Minuta(id = 7, id_usuario = userId, dia = "Domingo", recetas = recetas.filter { it.tipo_comida == Comidas.DESAYUNO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.ALMUERZO }.shuffled().take(1) + recetas.filter { it.tipo_comida == Comidas.CENA }.shuffled().take(1))

            minutaSemanal.add(minuta1)
            minutaSemanal.add(minuta2)
            minutaSemanal.add(minuta3)
            minutaSemanal.add(minuta4)
            minutaSemanal.add(minuta5)
            minutaSemanal.add(minuta6)
            minutaSemanal.add(minuta7)

        },
        modifier = Modifier.padding(16.dp).height(65.dp).width(300.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )

    ) {
        Text(
            text = "Crea Mi Minuta",
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}