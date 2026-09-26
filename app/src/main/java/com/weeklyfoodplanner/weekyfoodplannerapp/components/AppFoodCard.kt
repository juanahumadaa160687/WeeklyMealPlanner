package com.weeklyfoodplanner.weekyfoodplannerapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.weeklyfoodplanner.weekyfoodplannerapp.R
import com.weeklyfoodplanner.weekyfoodplannerapp.data.recetas
import com.weeklyfoodplanner.weekyfoodplannerapp.models.Comidas
import com.weeklyfoodplanner.weekyfoodplannerapp.models.Minuta

@Composable
fun AppUserMenuCard(nombre: String, imagen: Int, horario: Comidas, navController: NavController, user: Int) {

    val recetaID = recetas.find { it.nombre == nombre }?.id ?: 0

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .combinedClickable(onClick = { navController.navigate("receta-detalle?user=$user&receta=$recetaID") }),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(end = 16.dp).fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = imagen),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = Modifier.weight(1f).padding(top = 12.dp, bottom = 12.dp).fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = horario.name,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.secondary,
                )

                Text(
                    text = nombre,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id= R.drawable.ic_arrow_forward),
                    contentDescription = "Haz clic para ver la receta",
                    modifier = Modifier.requiredSize(24.dp)
                )
            }
        }
    }

}