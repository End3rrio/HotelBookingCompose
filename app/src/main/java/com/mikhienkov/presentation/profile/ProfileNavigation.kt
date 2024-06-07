package com.mikhienkov.presentation.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

object ProfileNavigation {
    const val route = "profile"
}

fun NavGraphBuilder.profileRoute(
    onEditProfileClick: () -> Unit,
    onSecurityClick: () -> Unit
) {
    composable(route = ProfileNavigation.route) {
        ProfileScreen(
            onEditProfileClick = onEditProfileClick,
            onSecurityClick = onSecurityClick
        )
    }
}

fun NavHostController.navigateToProfileRoute(navOptions: NavOptions? = null) {
    navigate(route = ProfileNavigation.route, navOptions = navOptions)
}