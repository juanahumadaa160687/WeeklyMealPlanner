package com.weeklyfoodplanner.weekyfoodplannerapp.models

class Receta (

    val id: Int,
    val nombre: String,
    val descripcion: String,
    val ingredientes: List<String>,
    val pasos: List<String>,
    val tiempoPreparacion: Int,
    val dificultad: String,
    val imagen: Int,
    val calorias: Int,
    val tipo_dieta: String,
    val alergenos: List<String>,
    val porciones: Int,
    val tipo_comida: Comidas,

) {
    fun getIngredientesAsString(): String {
        return ingredientes.joinToString("\n -", prefix = " -")
    }

    fun getPasosAsString(): String {
        return pasos.joinToString("\n -", prefix = " -")
    }

    fun getAlergenosAsString(): String {
        return alergenos.joinToString(", ")}

    fun getTiempoPreparacionAsString(): String {
        return "$tiempoPreparacion minutos"}

    fun getCaloriasAsString(): String {
        return "$calorias kcal"}

    fun getPorcionesAsString(): String {
        return "$porciones porciones"
    }
}