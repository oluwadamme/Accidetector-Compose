package com.example.accidetector.utils.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomRouter(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val inactiveIcon: ImageVector
) {
    object Home : BottomRouter(
        route = Routes.HomeScreen.name,
        label = "Home",
        icon = Icons.Default.Home,
        inactiveIcon = Icons.Outlined.Home
    )

    object Library : BottomRouter(
        route = Routes.SensorScreen.name,
        label = "Sensor",
        icon = Icons.Default.Settings,
        inactiveIcon = Icons.Outlined.Settings
    )

    object Settings : BottomRouter(
        route = Routes.UserInfoScreen.name,
        label = "Profile",
        icon = Icons.Default.Person,
        inactiveIcon = Icons.Outlined.Person
    )
}

val bottomNavItems = listOf(
    BottomRouter.Home,
    BottomRouter.Library,
    BottomRouter.Settings
)
