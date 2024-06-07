package com.mikhienkov.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.mikhienkov.presentation.auth.authentication.AuthenticationNavigation
import com.mikhienkov.presentation.auth.authentication.authenticationRoute
import com.mikhienkov.presentation.auth.authentication.navigateToAuthenticationRoute
import com.mikhienkov.presentation.auth.signin.navigateToSignInRoute
import com.mikhienkov.presentation.auth.signin.signInRoute
import com.mikhienkov.presentation.auth.fillprofile.navigateToFillProfileRoute
import com.mikhienkov.presentation.auth.fillprofile.fillProfileRoute
import com.mikhienkov.presentation.auth.signup.navigateToSignUpRoute
import com.mikhienkov.presentation.auth.signup.signUpRoute
import com.mikhienkov.presentation.booking.bookingRoute
import com.mikhienkov.presentation.home.homeRoute
import com.mikhienkov.presentation.home.mybookmark.myBookmarkRoute
import com.mikhienkov.presentation.home.mybookmark.navigateToMyBookmarkRoute
import com.mikhienkov.presentation.home.navigateToHomeRoute
import com.mikhienkov.presentation.home.recentlybooked.navigateToRecentlyBookedRoute
import com.mikhienkov.presentation.home.recentlybooked.recentlyBookedRoute
import com.mikhienkov.presentation.hoteldetails.gallery.hotelGalleryRoute
import com.mikhienkov.presentation.hoteldetails.gallery.navigateToHotelGallery
import com.mikhienkov.presentation.hoteldetails.hotelDetailsRoute
import com.mikhienkov.presentation.hoteldetails.navigateToHotelDetailsRoute
import com.mikhienkov.presentation.hoteldetails.review.hotelReviewsRoute
import com.mikhienkov.presentation.hoteldetails.review.navigateToHotelReviews
import com.mikhienkov.presentation.profile.edit.editProfileRoute
import com.mikhienkov.presentation.profile.edit.navigateToEditProfileRoute
import com.mikhienkov.presentation.profile.profileRoute
import com.mikhienkov.presentation.profile.security.changepassword.changePasswordRoute
import com.mikhienkov.presentation.profile.security.changepassword.navigateToChangePasswordRoute
import com.mikhienkov.presentation.profile.security.navigateToProfileSecurityRoute
import com.mikhienkov.presentation.profile.security.profileSecurityRoute
import com.mikhienkov.presentation.search.navigateToSearchRoute
import com.mikhienkov.presentation.search.searchRoute
import com.mikhienkov.presentation.welcome.carousel.carouselRoute
import com.mikhienkov.presentation.welcome.carousel.navigateToCarouselRoute
import com.mikhienkov.presentation.welcome.welcomeRoute

@Composable
fun BookingNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        welcomeRoute(onNavigateFurther = navController::navigateToCarouselRoute)
        carouselRoute(onNavigateFurther = navController::navigateToAuthenticationRoute)
        authenticationRoute(
            onSignIn = navController::navigateToSignInRoute,
            onSignUn = navController::navigateToSignUpRoute,
//            onNavigateToFillProfile = navController::navigateToSignUpFillProfileRoute
            onNavigateToFillProfile = {
                navController.navigateToFillProfileRoute(navOptions {
                    popUpTo(AuthenticationNavigation.route) {
                        inclusive = true
                    }
                })
            }
        )

        signInRoute(
            onNavigateClick = navController::navigateUp,
            onSignUp = {
                navController.navigateToSignUpRoute(navOptions = navOptions {
                    popUpTo(AuthenticationNavigation.route)
                })
            },
            onForgotPassword = {},
            onNavigateToHome = navController::navigateToHomeRoute
        )
        signUpRoute(
            onNavigateClick = navController::navigateUp,
            onFillProfile = navController::navigateToFillProfileRoute,
            onSignIn = {
                navController.navigateToSignInRoute(navOptions = navOptions {
                    popUpTo(AuthenticationNavigation.route)
                })
            }
        )
        fillProfileRoute(
            onNavigateClick = navController::navigateUp
//            onNavigateClick = {
//                navController.navigateToHomeRoute(
//                    TopLevelDestinationNavigationAction.navOptions(navController)
//                )
//            }
        )

        homeRoute(
            onBookmarksClick = navController::navigateToMyBookmarkRoute,
            onNotificationsClick = {},
            onSearchClick = navController::navigateToSearchRoute,
            onSeeAllBookedHotelsClick = navController::navigateToRecentlyBookedRoute,
            onHotelClick = navController::navigateToHotelDetailsRoute
        )
        recentlyBookedRoute(
            onNavigateClick = navController::navigateUp,
            onHotelClick = navController::navigateToHotelDetailsRoute
        )
        myBookmarkRoute(
            onNavigateClick = navController::navigateUp,
            onHotelClick = navController::navigateToHotelDetailsRoute
        )


        searchRoute(onHotelClick = navController::navigateToHotelDetailsRoute)
        bookingRoute()

        profileRoute(
            onEditProfileClick = navController::navigateToEditProfileRoute,
            onSecurityClick = navController::navigateToProfileSecurityRoute
        )
        // Profile top level destination
        editProfileRoute(onNavigateClick = navController::navigateUp)
        profileSecurityRoute(
            onNavigateClick = navController::navigateUp,
            onChangePasswordClick = navController::navigateToChangePasswordRoute
        )
        changePasswordRoute(onNavigateUp = navController::navigateUp)


        hotelDetailsRoute(
            onNavigationClick = navController::navigateUp,
            onGalleryClick = navController::navigateToHotelGallery,
            onMapClick = {},
            onReviewsClick = navController::navigateToHotelReviews
        )

        hotelReviewsRoute(onNavigationClick = navController::navigateUp)
        hotelGalleryRoute(onNavigationClick = navController::navigateUp)
    }
}