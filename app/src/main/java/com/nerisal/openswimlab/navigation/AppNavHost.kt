package com.nerisal.openswimlab.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nerisal.openswimlab.ui.settings.DebugScreen
import com.nerisal.openswimlab.ui.workouts.WorkoutsScreen
import com.nerisal.openswimlab.ui.settings.SettingsScreen
import com.nerisal.openswimlab.ui.theme.flow.FlowBackground
import com.nerisal.openswimlab.ui.widgets.NavigationBar
import com.nerisal.openswimlab.ui.widgets.TopBar
import com.nerisal.openswimlab.ui.workouts.PlansScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = { TopBar( "User", navController) },
        bottomBar = { NavigationBar(navController) },
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            FlowBackground(
                modifier = Modifier.fillMaxSize()
            )
            NavHost(
                navController = navController,
                startDestination = WorkoutsRoute,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable<WorkoutsRoute> {
                    WorkoutsScreen()
                }
                composable<PlansRoute> {
                    PlansScreen()
                }
                composable<AnalyticsRoute> {
                    PlansScreen()
                }
                composable<SettingsRoute> {
                    SettingsScreen(
                        onDebugClick = { navController.navigate(DebugRoute)},
                        onBack = { navController.popBackStack() }
                    )
                }
                composable<DebugRoute> {
                    DebugScreen()
                }
            }
        }
    }
}

fun NavHostController.navigateToTab(route: Any) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = false
        }
        launchSingleTop = true
        restoreState = false
    }
}
