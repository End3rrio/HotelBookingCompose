package com.mikhienkov.presentation.welcome.carousel

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mikhienkov.presentation.welcome.WelcomeNavigation

object CarouselNavigation {
    const val route = "carousel"
}

fun NavGraphBuilder.carouselRoute(
    onNavigateFurther: () -> Unit
) {
    composable(route = CarouselNavigation.route) {
        CarouselScreen(onNavigateFurther = onNavigateFurther)
    }
}

fun NavHostController.navigateToCarouselRoute() {
    navigate(CarouselNavigation.route) {
        popUpTo(WelcomeNavigation.route) {
            inclusive = true
        }
    }
}