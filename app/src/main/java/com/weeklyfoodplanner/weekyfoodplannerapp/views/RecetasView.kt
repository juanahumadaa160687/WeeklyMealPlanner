package com.weeklyfoodplanner.weekyfoodplannerapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldState
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.weeklyfoodplanner.weekyfoodplannerapp.R
import com.weeklyfoodplanner.weekyfoodplannerapp.components.AppRecetaCard
import com.weeklyfoodplanner.weekyfoodplannerapp.data.recetas
import com.weeklyfoodplanner.weekyfoodplannerapp.models.Comidas
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecetasView(navController: NavController, userId: Int) {

    var userId = userId
    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection).fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,


    )
    {innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = innerPadding,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )  {
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Desayunos",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.background
                    )
                }
            }

            item{
                LazyRow(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    recetas.forEach { receta ->

                        if (receta.tipo_comida == Comidas.DESAYUNO) {
                            item {
                                AppRecetaCard(
                                    nombre = receta.nombre,
                                    imagen = receta.imagen,
                                    onClick = { navController.navigate("receta-detalle/user=$userId&receta=$receta.id") }
                                )
                            }
                        }
                    }
                }
            }
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Almuerzos",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.background
                    )
                }
            }
            item{
                LazyRow(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    recetas.forEach { receta ->

                        if (receta.tipo_comida == Comidas.ALMUERZO) {
                            item {
                                AppRecetaCard(
                                    nombre = receta.nombre,
                                    imagen = receta.imagen,
                                    onClick = { navController.navigate("receta-detalle/${receta.id}") }
                                )
                            }
                        }
                    }
                }
            }
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Cenas",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.background
                    )
                }
            }
            item{
                LazyRow(
                    modifier = Modifier
                        .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    recetas.forEach { receta ->

                        if (receta.tipo_comida == Comidas.CENA) {
                            item {
                                AppRecetaCard(
                                    nombre = receta.nombre,
                                    imagen = receta.imagen,
                                    onClick = { navController.navigate("receta-detalle/${receta.id}") }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
