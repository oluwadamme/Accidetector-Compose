package com.example.accidetector.presentation.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.accidetector.components.BottomNavigationBarComponent
import com.example.accidetector.components.CustomScaffold
import com.example.accidetector.utils.route.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(

) {
    val parentRoute = remember {
        mutableStateOf(Routes.HomeScreen.name)
    }
    CustomScaffold(
        bottomBar = {
            BottomNavigationBarComponent(
                parentRoute
            )
        },

      appBarTitle = parentRoute.value
    ) { padding ->
        Box(modifier = Modifier.padding(top = padding.calculateTopPadding())) {
            if (parentRoute.value == Routes.SensorScreen.name)
                SensorScreen()
            if (parentRoute.value == Routes.UserInfoScreen.name)
                UserInfoScreen()
            if (parentRoute.value == Routes.HomeScreen.name)
                HomeScreen()
        }
    }
}