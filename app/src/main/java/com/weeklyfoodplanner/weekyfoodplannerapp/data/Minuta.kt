package com.weeklyfoodplanner.weekyfoodplannerapp.data

import com.weeklyfoodplanner.weekyfoodplannerapp.models.Minuta

val minuta1 = Minuta(id = 1, id_usuario = 1, dia = "Lunes", recetas = listOf(receta1, receta6, receta11))

val minuta2 = Minuta(id = 2, id_usuario = 1, dia = "Martes", recetas = listOf( receta2, receta7, receta12))

val minuta3 = Minuta(id = 3, id_usuario = 1, dia = "Miércoles", recetas = listOf( receta3, receta8, receta13))

val minuta4 = Minuta(id = 4, id_usuario = 1, dia = "Jueves", recetas = listOf( receta4, receta9, receta14))

val minuta5 = Minuta(id = 5, id_usuario = 1, dia = "Viernes", recetas = listOf( receta5, receta10, receta15))

val minuta6 = Minuta(id = 6, id_usuario = 1, dia = "Sábado", recetas = listOf( receta1, receta6, receta11))

val minuta7 = Minuta(id = 7, id_usuario = 1, dia = "Domingo", recetas = listOf( receta2, receta7, receta12))

val minutaSemanal = mutableListOf<Minuta>(minuta1, minuta2, minuta3, minuta4, minuta5, minuta6, minuta7)
