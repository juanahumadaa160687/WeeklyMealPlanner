package com.weeklyfoodplanner.weekyfoodplannerapp.models

class Minuta
    (
        val id: Int,
        val id_usuario: Int,
        val dia: String,
        val recetas: List<Receta>
    ){}
