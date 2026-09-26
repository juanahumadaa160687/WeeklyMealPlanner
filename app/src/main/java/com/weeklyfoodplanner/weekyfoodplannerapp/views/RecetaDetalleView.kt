package com.weeklyfoodplanner.weekyfoodplannerapp.views

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationItemColors
import androidx.compose.material3.Scaffold
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.weeklyfoodplanner.weekyfoodplannerapp.R
import com.weeklyfoodplanner.weekyfoodplannerapp.data.recetas
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecetaDetalleView(navController: NavController, recetaId: Int, userId: Int) {

    val receta = recetas.find { it.id == recetaId }

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
        Scaffold()
        {
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
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

                item {

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(350.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.BottomStart
                            ) {
                                Image(
                                    painter = painterResource(id = receta?.imagen ?: 0),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .drawWithCache {
                                            val gradient = Brush.verticalGradient(
                                                colors = listOf(Color.Transparent, Color.Black),
                                                startY = size.height * 1f,
                                                endY = size.height * 0.6f
                                            )
                                            onDrawWithContent {
                                                drawContent()
                                                drawRect(gradient, blendMode = BlendMode.DstIn)
                                            }
                                        },
                                    contentScale = ContentScale.Crop
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = receta?.tipo_dieta.toString(),
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .border(
                                                width = 2.dp,
                                                color = Color.White,
                                                shape = MaterialTheme.shapes.large
                                            )
                                            .background(
                                                color = Color.White.copy(alpha = 0.2f),
                                                shape = MaterialTheme.shapes.large
                                            )
                                            .padding(horizontal = 16.dp, vertical = 8.dp)

                                    )
                                    Text(
                                        text = receta?.calorias.toString() + " kcal",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .border(
                                                width = 2.dp,
                                                color = Color.White,
                                                shape = MaterialTheme.shapes.large
                                            )
                                            .background(
                                                color = Color.White.copy(alpha = 0.2f),
                                                shape = MaterialTheme.shapes.large
                                            )
                                            .padding(horizontal = 16.dp, vertical = 8.dp)

                                    )
                                }
                            }
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Preparación:\n" + receta?.tiempoPreparacion.toString() + " min",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    textAlign = TextAlign.Center
                                )

                                VerticalDivider(
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .height(24.dp)
                                        .width(1.dp)
                                        .background(MaterialTheme.colorScheme.primary),
                                    color = MaterialTheme.colorScheme.primary
                                )

                                Text(
                                    text = receta?.porciones.toString() + " porcion(es)",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    textAlign = TextAlign.Center
                                )

                                VerticalDivider(
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .height(24.dp)
                                        .width(1.dp)
                                        .background(MaterialTheme.colorScheme.primary),
                                    color = MaterialTheme.colorScheme.primary
                                )

                                Text(
                                    text = "Dificultad:\n" + receta?.dificultad.toString(),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Text(
                                text = "Alérgenos: " + receta?.alergenos?.joinToString(", "),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.Start
                            ) {

                                Text(
                                    text = receta?.nombre.toString(),
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(
                                        top = 8.dp,
                                        bottom = 8.dp,
                                        start = 16.dp,
                                        end = 16.dp
                                    )
                                )

                                Text(
                                    text = receta?.descripcion.toString(),
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .padding(top = 16.dp, bottom = 16.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = "Ingredientes",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(16.dp)
                                )

                                receta?.ingredientes?.forEach { ingrediente ->
                                    Text(
                                        text = "- $ingrediente \n",
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.padding(horizontal = 16.dp)
                                    )
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = "Preparación",
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(16.dp)
                                )

                                receta?.pasos?.forEachIndexed { index, paso ->
                                    Text(
                                        text = "${index + 1}. $paso \n",
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.padding(horizontal = 16.dp)
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
