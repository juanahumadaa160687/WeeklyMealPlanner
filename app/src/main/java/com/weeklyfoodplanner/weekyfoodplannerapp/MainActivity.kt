package com.weeklyfoodplanner.weekyfoodplannerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldValue
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.weeklyfoodplanner.weekyfoodplannerapp.navigation.AppNavigation
import com.weeklyfoodplanner.weekyfoodplannerapp.ui.theme.WeekyFoodPlannerAppTheme
import com.weeklyfoodplanner.weekyfoodplannerapp.views.ChangePasswordView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.IndexScreen
import com.weeklyfoodplanner.weekyfoodplannerapp.views.MinutaSemanalView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.PasswordRecoveryView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.RecetaDetalleView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.RecetasView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.SignInView
import com.weeklyfoodplanner.weekyfoodplannerapp.views.SignUpView
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3AdaptiveApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            WeekyFoodPlannerAppTheme {
                FirebaseApp.initializeApp(this)
                AppNavigation()

            }
        }
    }
}
