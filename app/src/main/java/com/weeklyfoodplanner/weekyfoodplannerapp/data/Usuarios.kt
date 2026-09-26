package com.weeklyfoodplanner.weekyfoodplannerapp.data

import com.weeklyfoodplanner.weekyfoodplannerapp.models.Usuario

var usuarios = mutableListOf(
    Usuario(
        id = 1,
        nombre = "Jhon",
        apellido = "Doe",
        email = "jhon.doe@example.com",
        password = "password123",
        edad = 30,
        alergias = listOf("Gluten", "Lactosa"),
    ),

    Usuario(
        id = 2,
        nombre = "Jane",
        apellido = "Smith",
        email = "jane.smith@example.com",
        password = "password456",
        edad = 25,
        alergias = listOf("Pescado"),
    ),

    Usuario(
        id = 3,
        nombre = "Alice",
        apellido = "Johnson",
        email = "alice.johnson@example.com",
        password = "password789",
        edad = 28,
        alergias = listOf("Huevo", "Soja"),
    ),

    Usuario(
        id = 4,
        nombre = "Bob",
        apellido = "Williams",
        email = "bob.williams@example.com",
        password = "password101",
        edad = 32,
        alergias = listOf("Frutos secos"),
    ),

    Usuario(
        id = 5,
        nombre = "Charlie",
        apellido = "Brown",
        email = "charlie.brown@example.com",
        password = "password202",
        edad = 29,
        alergias = listOf("Mariscos")
    )
)