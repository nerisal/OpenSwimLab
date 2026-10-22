package com.nerisal.openswimlab.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.UploadFile
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nerisal.openswimlab.navigation.AnalyticsRoute
import com.nerisal.openswimlab.navigation.DebugRoute
import com.nerisal.openswimlab.navigation.PlansRoute
import com.nerisal.openswimlab.navigation.SettingsRoute
import com.nerisal.openswimlab.navigation.WorkoutsRoute
import com.nerisal.openswimlab.navigation.navigateToTab
import com.nerisal.openswimlab.ui.theme.flow.FlowShapesDefaults
import com.nerisal.openswimlab.ui.theme.flow.FlowSizes
import com.nerisal.openswimlab.ui.theme.flow.FlowSpacing

data class TopBarConfig(
    val title: String,
    val subtitle: String? = null,
    val actions: List<TopBarAction> = emptyList(),
    val showBackButton: Boolean = false
)

data class TopBarAction(
    val icon: ImageVector,
    val contentDescription: String,
    val onClick: () -> Unit
)

@Composable
fun TopBar(
    name: String,
    navController: NavHostController
) {
    val backStackEntry by
    navController.currentBackStackEntryAsState()

    val destination = backStackEntry?.destination

    val topBarConfig = when {
        destination?.hasRoute<WorkoutsRoute>() == true ->
            TopBarConfig(
                title = "Hi, $name",
                subtitle = "Your workouts",
                actions = listOf(
                    TopBarAction(
                        icon = Icons.Outlined.UploadFile,
                        contentDescription = "Import a workout",
                        onClick = {

                        }
                    ),
                    TopBarAction(
                        icon = Icons.Outlined.Settings,
                        contentDescription = "Settings",
                        onClick = {
                            navController.navigateToTab(SettingsRoute)
                        }
                    )
                )
            )

        destination?.hasRoute<PlansRoute>() == true ->
            TopBarConfig(
                title = "Workout Plans",
                subtitle = null,
                actions = listOf(
                    TopBarAction(
                        icon = Icons.Outlined.Add,
                        contentDescription = "Import a workout",
                        onClick = {

                        }
                    ),
                    TopBarAction(
                        icon = Icons.Outlined.Settings,
                        contentDescription = "Settings",
                        onClick = {
                            navController.navigateToTab(SettingsRoute)
                        }
                    )
                )
            )

        destination?.hasRoute<AnalyticsRoute>() == true ->
            TopBarConfig(
                title = "Your progress",
                subtitle = null,
                actions = listOf(
                    TopBarAction(
                        icon = Icons.Outlined.Settings,
                        contentDescription = "Settings",
                        onClick = {
                            navController.navigateToTab(SettingsRoute)
                        }
                    )
                )
            )

        destination?.hasRoute<SettingsRoute>() == true ->
            TopBarConfig(
                title = "Settings",
                showBackButton = true
            )

        destination?.hasRoute<DebugRoute>() == true ->
            TopBarConfig(
                title = "Debug",
                showBackButton = true
            )

        else ->
            TopBarConfig(
                title = "OpenSwimLab"
            )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                end = FlowSpacing.Medium,
                start = FlowSpacing.Medium,
                top = FlowSpacing.Large + 10.dp,
                bottom = 0.dp
            )
            .heightIn(min = 64.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (topBarConfig.showBackButton) {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Go Back"
                    )
                }
            }

            Column {
                Text(
                    text = topBarConfig.title,
                    style = MaterialTheme.typography.headlineSmall
                )

                topBarConfig.subtitle?.let { subtitle ->
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1
                    )
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            topBarConfig.actions.forEach { action ->
                IconButton(
                    onClick = action.onClick
                ) {
                    Icon(
                        imageVector = action.icon,
                        contentDescription = action.contentDescription
                    )
                }
            }
        }
    }
}