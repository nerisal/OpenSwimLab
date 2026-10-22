package com.nerisal.openswimlab.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Analytics
import androidx.compose.material.icons.sharp.CalendarMonth
import androidx.compose.material.icons.sharp.Pool
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nerisal.openswimlab.navigation.AnalyticsRoute
import com.nerisal.openswimlab.navigation.PlansRoute
import com.nerisal.openswimlab.navigation.SettingsRoute
import com.nerisal.openswimlab.navigation.WorkoutsRoute
import com.nerisal.openswimlab.navigation.navigateToTab
import com.nerisal.openswimlab.ui.theme.flow.FlowNavigationButton
import com.nerisal.openswimlab.ui.workouts.PlansScreen

@Composable
fun NavigationBar(
    navController: NavHostController
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination


    BottomAppBar(
        containerColor = Color.Transparent,
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                FlowNavigationButton(
                    onClick = { navController.navigateToTab(WorkoutsRoute) },
                    text = "Workouts",
                    imageVector = Icons.Sharp.Pool,
                    selected = currentDestination?.hasRoute<WorkoutsRoute>() == true
                )

                FlowNavigationButton(
                    onClick = { navController.navigateToTab(PlansRoute) },
                    text = "Plans",
                    imageVector = Icons.Sharp.CalendarMonth,
                    selected = currentDestination?.hasRoute<PlansRoute>() == true
                )

                FlowNavigationButton(
                    onClick = { navController.navigateToTab(AnalyticsRoute)},
                    text = "Analytics",
                    imageVector = Icons.Sharp.Analytics,
                    selected = currentDestination?.hasRoute<AnalyticsRoute>() == true
                )
            }
        }
    )
}


