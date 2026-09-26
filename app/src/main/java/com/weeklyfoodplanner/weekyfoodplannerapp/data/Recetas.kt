package com.weeklyfoodplanner.weekyfoodplannerapp.data

import com.weeklyfoodplanner.weekyfoodplannerapp.R
import com.weeklyfoodplanner.weekyfoodplannerapp.models.Comidas
import com.weeklyfoodplanner.weekyfoodplannerapp.models.Receta

val receta1 = Receta(
    id = 1,
    nombre = "Smoothie Verde",
    descripcion = "Un delicioso smoothie verde lleno de nutrientes y vitaminas.",
    imagen = R.mipmap.recipe1,
    ingredientes = listOf(
        "1 taza de espinacas frescas",
        "1 plátano maduro",
        "1/2 taza de piña en trozos",
        "1/2 taza de leche de almendras",
        "1 cucharadita de miel (opcional)"
    ),
    pasos = listOf(
        "Coloca las espinacas, el plátano, la piña, la leche de almendras y la miel en una licuadora.",
        "Licúa hasta obtener una mezcla suave y homogénea.",
        "Vierte el smoothie en un vaso y disfruta de inmediato."
    ),
    calorias = 200,
    tiempoPreparacion = 10,
    dificultad = "Fácil",
    porciones = 1,
    tipo_comida = Comidas.DESAYUNO,
    alergenos = listOf("Ninguno"),
    tipo_dieta = "Vegetariana"
)

val receta2 = Receta(

    id = 2,
    nombre = "Tostadas de Aguacate",
    descripcion = "Tostadas crujientes con aguacate, tomate y huevo pochado.",
    imagen = R.mipmap.recipe2,
    ingredientes = listOf(
        "2 rebanadas de pan integral",
        "1 aguacate maduro",
        "1 tomate en rodajas",
        "1 huevo",
        "Sal y pimienta al gusto"
    ),
    pasos = listOf(
        "Tuesta las rebanadas de pan integral.",
        "Aplasta el aguacate y úntalo sobre las tostadas.",
        "Coloca las rodajas de tomate y el huevo pochado encima.",
        "Sazona con sal y pimienta al gusto."
    ),
    calorias = 300,
    tiempoPreparacion = 15,
    dificultad = "Fácil",
    porciones = 1,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.DESAYUNO,
    alergenos = listOf("Ninguno")

)

val receta3 = Receta(

    id = 3,
    nombre = "Avena con Frutas",
    descripcion = "Un desayuno nutritivo y delicioso con avena, frutas frescas y miel.",
    imagen = R.mipmap.recipe3,
    ingredientes = listOf(
        "1/2 taza de avena",
        "1 taza de leche o agua",
        "1/2 plátano en rodajas",
        "1/4 taza de fresas en rodajas",
        "1 cucharadita de miel"
    ),
    pasos = listOf(
        "Cocina la avena con la leche o agua según las instrucciones del paquete.",
        "Sirve la avena en un tazón y agrega las rodajas de plátano y fresas.",
        "Endulza con miel al gusto y disfruta."
    ),
    calorias = 250,
    tiempoPreparacion = 10,
    dificultad = "Fácil",
    porciones = 1,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.DESAYUNO,
    alergenos = listOf("Ninguno")

)


val receta4 = Receta(
    id = 4,
    nombre= "Huevos Revueltos con Espinacas",
    descripcion = "Huevos revueltos con espinacas frescas y un toque de queso rallado.",
    imagen = R.mipmap.recipe4,
    ingredientes= listOf(
        "2 huevos",
        "1 taza de espinacas frescas",
        "1 cucharada de queso rallado",
        "Sal y pimienta al gusto"
    ),
    pasos= listOf(
        "Bate los huevos en un tazón y sazona con sal y pimienta.",
        "En una sartén, cocina las espinacas hasta que se marchiten.",
        "Agrega los huevos batidos a la sartén y revuelve hasta que estén cocidos.",
        "Espolvorea con queso rallado antes de servir."
    ),
    calorias = 220,
    tiempoPreparacion = 10,
    dificultad = "Fácil",
    porciones = 1,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.DESAYUNO,
    alergenos = listOf("Ninguno")
)

val receta5 = Receta(
    id = 5,
    nombre= "Batido de Frutas",
    descripcion = "Un batido refrescante y nutritivo con frutas frescas y yogur.",
    imagen = R.mipmap.recipe5,
    ingredientes =  listOf(
        "1/2 taza de fresas",
        "1/2 taza de plátano",
        "1/2 taza de yogur",
        "1/2 taza de leche",
        "1 cucharadita de miel"
    ),
    pasos = listOf(
        "Coloca todas las frutas en una licuadora.",
        "Agrega el yogur, la leche y la miel.",
        "Licúa hasta obtener una mezcla suave y homogénea.",
        "Sirve en un vaso y disfruta."
    ),
    calorias = 200,
    tiempoPreparacion = 5,
    dificultad = "Fácil",
    porciones = 1,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.DESAYUNO,
    alergenos = listOf("Ninguno")
)


//Recetas de ejemplo Almuerzo
val receta6 = Receta(
    id = 6,
    nombre= "Ensalada de Quinoa",
    descripcion = "Una ensalada fresca y saludable con quinoa, vegetales y aderezo de limón.",
    imagen = R.mipmap.recipe6,
    ingredientes= listOf(
        "1 taza de quinoa cocida",
        "1 tomate picado",
        "1 pepino picado",
        "2 cucharadas de aceite de oliva",
        "Jugo de 1 limón"
    ),
    pasos= listOf(
        "Cocina la quinoa según las instrucciones del paquete.",
        "En un tazón grande, mezcla la quinoa cocida, el tomate y el pepino.",
        "Agrega el aceite de oliva y el jugo de limón. Mezcla bien y sirve."
    ),
    calorias = 250,
    tiempoPreparacion = 15,
    dificultad = "Fácil",
    porciones = 2,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.ALMUERZO,
    alergenos = listOf("Ninguno")
)

val receta7 = Receta(
    id = 7,
    nombre= "Pasta Integral con Verduras",
    descripcion = "Una pasta saludable con verduras frescas y salsa de tomate casera.",
    imagen = R.mipmap.recipe7,
    ingredientes= listOf(
        "200 g de pasta integral",
        "1 calabacín picado",
        "1 pimiento rojo picado",
        "2 tomates picados",
        "2 dientes de ajo picados"
    ),
    pasos= listOf(
        "Cocina la pasta integral según las instrucciones del paquete.",
        "En una sartén grande, saltea el calabacín, el pimiento rojo, los tomates y el ajo hasta que estén tiernos.",
        "Agrega la pasta cocida a la sartén y mezcla bien. Sirve caliente."
    ),
    calorias = 350,
    tiempoPreparacion = 20,
    dificultad = "Media",
    porciones = 2,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.ALMUERZO,
    alergenos = listOf("Ninguno")
)

val receta8 = Receta(
    id = 8,
    nombre= "Tacos de Pollo",
    descripcion = "Deliciosos tacos de pollo con salsa de aguacate y vegetales frescos.",
    imagen = R.mipmap.recipe8,
    ingredientes= listOf(
        "4 tortillas de maíz",
        "200 g de pechuga de pollo cocida y desmenuzada",
        "1 aguacate en rodajas",
        "1/2 taza de lechuga picada",
        "1/2 taza de tomate picado"
    ),
    pasos= listOf(
        "Calienta las tortillas en una sartén.",
        "Rellena cada tortilla con pollo desmenuzado, rodajas de aguacate, lechuga y tomate.",
        "Sirve los tacos calientes y disfruta."
    ),
    calorias = 400,
    tiempoPreparacion = 15,
    dificultad = "Fácil",
    porciones = 2,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.ALMUERZO,
    alergenos = listOf("Ninguno")
)

val receta9 = Receta(
    id = 9,
    nombre= "Sopa de Verduras",
    descripcion = "Una sopa ligera y nutritiva con una variedad de verduras frescas.",
    imagen = R.mipmap.recipe9,
    ingredientes= listOf(
        "1 zanahoria picada",
        "1 calabacín picado",
        "1 pimiento rojo picado",
        "1 litro de caldo de verduras",
        "Sal y pimienta al gusto"
    ),
    pasos= listOf(
        "En una olla grande, agrega el caldo de verduras y lleva a ebullición.",
        "Agrega las verduras picadas y cocina hasta que estén tiernas.",
        "Sazona con sal y pimienta al gusto. Sirve caliente."
    ),
    calorias = 150,
    tiempoPreparacion = 25,
    dificultad = "Fácil",
    porciones = 4,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.ALMUERZO,
    alergenos = listOf("Ninguno")
)

val receta10 = Receta(
    id = 10,
    nombre= "Ensalada de Pollo a la Parrilla",
    descripcion = "Una ensalada fresca y deliciosa con pollo a la parrilla, vegetales y aderezo ligero.",
    imagen = R.mipmap.recipe10,
    ingredientes= listOf(
        "200 g de pechuga de pollo a la parrilla",
        "2 tazas de lechuga mixta",
        "1/2 taza de tomates cherry",
        "1/4 taza de pepino en rodajas",
        "2 cucharadas de aderezo ligero"
    ),
    pasos= listOf(
        "Corta el pollo a la parrilla en tiras.",
        "En un tazón grande, mezcla la lechuga, los tomates cherry y el pepino.",
        "Agrega el pollo a la ensalada y rocía con el aderezo ligero. Mezcla bien y sirve."
    ),
    calorias = 300,
    tiempoPreparacion = 20,
    dificultad = "Fácil",
    porciones = 2,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.ALMUERZO,
    alergenos = listOf("Ninguno")
)

//Recetas de ejemplo Cena
val receta11 = Receta(
    id = 11,
    nombre= "Sopa de Lentejas",
    descripcion = "Una sopa reconfortante y nutritiva hecha con lentejas, verduras y especias.",
    imagen = R.mipmap.recipe11,
    ingredientes= listOf(
        "1 taza de lentejas",
        "1 zanahoria picada",
        "1 cebolla picada",
        "2 dientes de ajo picados",
        "4 tazas de caldo de verduras"
    ),
    pasos= listOf(
        "En una olla grande, sofríe la cebolla, la zanahoria y el ajo hasta que estén tiernos.",
        "Agrega las lentejas y el caldo de verduras. Cocina a fuego medio hasta que las lentejas estén tiernas.",
        "Sirve caliente y disfruta."
    ),
    calorias = 300,
    tiempoPreparacion = 30,
    dificultad = "Media",
    porciones = 4,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.CENA,
    alergenos = listOf("Ninguno")
)

val receta12 = Receta(
    id = 12,
    nombre= "Pasta al Pesto",
    descripcion = "Una deliciosa pasta con salsa pesto casera, ideal para una cena rápida.",
    imagen = R.mipmap.recipe12,
    ingredientes= listOf(
        "200 g de pasta",
        "1/4 taza de pesto",
        "2 cucharadas de queso parmesano rallado",
        "Sal y pimienta al gusto"
    ),
    pasos= listOf(
        "Cocina la pasta según las instrucciones del paquete.",
        "Escurre la pasta y mezcla con el pesto.",
        "Sirve con queso parmesano rallado y sazona con sal y pimienta al gusto."
    ),
    calorias = 400,
    tiempoPreparacion = 20,
    dificultad = "Fácil",
    porciones = 2,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.CENA,
    alergenos = listOf("Ninguno")
)

val receta13 = Receta(
    id = 13,
    nombre= "Salmón al Horno con Verduras",
    descripcion = "Un plato saludable y delicioso con salmón al horno y verduras asadas.",
    imagen = R.mipmap.recipe13,
    ingredientes= listOf(
        "2 filetes de salmón",
        "1 calabacín en rodajas",
        "1 pimiento rojo en tiras",
        "2 cucharadas de aceite de oliva",
        "Sal y pimienta al gusto"
    ),
    pasos= listOf(
        "Precalienta el horno a 200°C.",
        "Coloca los filetes de salmón y las verduras en una bandeja para hornear.",
        "Rocía con aceite de oliva, sazona con sal y pimienta, y hornea durante 15-20 minutos.",
        "Sirve caliente y disfruta."
    ),
    calorias = 350,
    tiempoPreparacion = 25,
    dificultad = "Media",
    porciones = 2,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.CENA,
    alergenos = listOf("Ninguno")
)

val receta14 = Receta(
    id = 14,
    nombre= "Ensalada de Garbanzos",
    descripcion = "Una ensalada fresca y nutritiva con garbanzos, vegetales y aderezo de limón.",
    imagen = R.mipmap.recipe14,
    ingredientes= listOf(
        "1 taza de garbanzos cocidos",
        "1 tomate picado",
        "1 pepino picado",
        "2 cucharadas de aceite de oliva",
        "Jugo de 1 limón"
    ),
    pasos= listOf(
        "En un tazón grande, mezcla los garbanzos cocidos, el tomate y el pepino.",
        "Agrega el aceite de oliva y el jugo de limón. Mezcla bien y sirve."
    ),
    calorias = 250,
    tiempoPreparacion = 10,
    dificultad = "Fácil",
    porciones = 2,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.CENA,
    alergenos = listOf("Ninguno")
)

val receta15 = Receta(
    id = 15,
    nombre = "Pollo al Curry con Arroz",
    descripcion = "Un plato delicioso y aromático con pollo al curry y arroz basmati.",
    imagen = R.mipmap.recipe15,
    ingredientes = listOf(
        "200 g de pechuga de pollo en cubos",
        "1 cebolla picada",
        "2 dientes de ajo picados",
        "1 cucharada de curry en polvo",
        "1 taza de arroz basmati cocido"
    ),
    pasos = listOf(
        "En una sartén grande, sofríe la cebolla y el ajo hasta que estén tiernos.",
        "Agrega el pollo y cocina hasta que esté dorado.",
        "Añade el curry en polvo y mezcla bien. Cocina por unos minutos más.",
        "Sirve el pollo al curry sobre el arroz basmati cocido."
    ),
    calorias = 450,
    tiempoPreparacion = 30,
    dificultad = "Media",
    porciones = 2,
    tipo_dieta = "Vegetariana",
    tipo_comida = Comidas.CENA,
    alergenos = listOf("Ninguno")
)

val recetas = listOf(
    receta1, receta2, receta3, receta4, receta5,
    receta6, receta7, receta8, receta9, receta10,
    receta11, receta12, receta13, receta14, receta15
)