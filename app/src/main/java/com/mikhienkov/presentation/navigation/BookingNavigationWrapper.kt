package com.mikhienkov.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mikhienkov.designsystem.components.BottomNavigation
import com.mikhienkov.designsystem.theme.BookingTheme
import com.mikhienkov.presentation.booking.BookingNavigation
import com.mikhienkov.presentation.home.HomeNavigation
import com.mikhienkov.presentation.profile.ProfileNavigation
import com.mikhienkov.presentation.search.SearchNavigation

@Composable
fun BookingNavigationWrapper(
    startDestination: String,
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()
    val destinationAction = rememberTopLevelDestinationNavigationAction(navController)
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    Scaffold(
        modifier = modifier,
        containerColor = BookingTheme.backgroundColor,
        topBar = {},
        bottomBar = {
            if (currentDestination.isBottomBarVisible()) {
                BottomNavigation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(vertical = 8.dp),
                    destinations = TopLevelDestination.values().toList(),
                    onNavigateToDestination = destinationAction::navigate,
                    currentDestination = currentDestination
                )
            }
        },
        content = { scaffoldPadding ->
            BookingNavHost(
                modifier = Modifier.padding(bottom = scaffoldPadding.calculateBottomPadding()),
                navController = navController,
                startDestination = startDestination
            )
        }
    )
}


private fun NavDestination?.isBottomBarVisible(): Boolean {
    return this?.route in listOf(
        HomeNavigation.route,
        SearchNavigation.route,
        BookingNavigation.route,
        ProfileNavigation.route
    )
}