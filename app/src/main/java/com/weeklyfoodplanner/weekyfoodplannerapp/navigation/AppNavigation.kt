package com.weeklyfoodplanner.weekyfoodplannerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.weeklyfoodplanner.weekyfoodplannerapp.views.ChangePasswordView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.IndexScreen
import com.weeklyfoodplanner.weekyfoodplannerapp.views.MinutaSemanalView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.PasswordRecoveryView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.RecetaDetalleView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.RecetasView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.SignInView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.SignUpView

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "index") {
        composable("index") {
            IndexScreen(navController)
        }
        composable("sign-in") {
            SignInView(navController)
        }
        composable("sign-up") {
            SignUpView(navController)
        }

        composable("password-recovery")
        { PasswordRecoveryView(navController) }

        composable("change-password?user={email}",
            arguments = listOf(navArgument("email")
            {
                type = NavType.StringType
                defaultValue = ""
            })
        ) {
                backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""

            ChangePasswordView(navController, email)
        }

        composable("minuta-semanal?user={id}",
            arguments = listOf(navArgument("id")
            {
                type = NavType.IntType
                defaultValue = 0
            })
        ) {
                backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("id") ?: 0

            MinutaSemanalView(navController, userId)
        }
        composable("recetas?user={id}",
            arguments = listOf(navArgument("id")
            {
                type = NavType.IntType
                defaultValue = 0
            })
        ) {
                backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("id") ?: 0

            RecetasView(navController, userId)
        }
        composable("receta-detalle?user={userId}&receta={id}",
            arguments = listOf(navArgument("id")
            {
                type = NavType.IntType
                defaultValue = 0
            },
                navArgument("userId")
                {
                    type = NavType.IntType
                    defaultValue = 0
                })
        ) {
                backStackEntry ->
            val recetaId = backStackEntry.arguments?.getInt("id") ?: 0
            val userId = backStackEntry.arguments?.getInt("userId") ?: 0

            RecetaDetalleView(navController, recetaId, userId)
        }
    }

}