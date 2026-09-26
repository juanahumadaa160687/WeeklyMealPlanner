package com.weeklyfoodplanner.weekyfoodplannerapp.models

class Usuario(

    val id: Int,
    val nombre: String,
    val apellido: String,
    val email: String,
    val edad: Int,
    var password: String,
    val alergias: List<String>

    ) {}