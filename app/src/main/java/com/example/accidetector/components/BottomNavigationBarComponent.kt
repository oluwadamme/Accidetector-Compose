package com.example.accidetector.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.accidetector.utils.route.Routes
import com.example.accidetector.utils.route.bottomNavItems
import com.example.accidetector.utils.route.parentRoute

@Composable
fun BottomNavigationBarComponent(
   parentRoute: MutableState<String>
) {
    NavigationBar {

        bottomNavItems.forEach { screen ->
            val selected = parentRoute.value == screen.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    parentRoute.value = screen.route
                },
                icon = {if(selected) Icon(imageVector = screen.icon,  contentDescription = screen.label) else  Icon(imageVector = screen.inactiveIcon,  contentDescription = screen.label)},
                alwaysShowLabel = true,
                label = { Text(text = screen.label)}
            )
        }
    }
}