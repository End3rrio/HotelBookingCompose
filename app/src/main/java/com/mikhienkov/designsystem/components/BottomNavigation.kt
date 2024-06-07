package com.mikhienkov.designsystem.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mikhienkov.designsystem.clickableWithoutIndication
import com.mikhienkov.designsystem.theme.BookingTheme
import com.mikhienkov.presentation.navigation.TopLevelDestination
import com.mikhienkov.presentation.navigation.isTopLevelDestinationInHierarchy
import com.mikhienkov.presentation.navigation.rememberTopLevelDestinationNavigationAction

@Composable
fun BottomNavigation(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    val background =
        if (BookingTheme.theme.isDark) BookingTheme.colors.dark1.copy(alpha = 0.85f) else BookingTheme.colors.white

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(background, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 32.dp)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        destinations.forEachIndexed { index, destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NavigationItem(
                modifier = Modifier.weight(1f),
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                label = stringResource(destination.labelResId),
                selectedIconResId = destination.selectedIconResId,
                unselectedIconResId = destination.unselectedIconResId
            )
        }
    }
}

@Composable
private fun NavigationItem(
    label: String,
    @DrawableRes selectedIconResId: Int,
    @DrawableRes unselectedIconResId: Int,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val color = if (selected) BookingTheme.colors.primary500 else BookingTheme.colors.greyscale500

    Column(
        modifier = modifier.clickableWithoutIndication(onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(if (selected) selectedIconResId else unselectedIconResId),
            contentDescription = label,
            tint = color
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = label,
            style = BookingTheme.typography.bodyXSmallMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = color
        )
    }
}

@Preview
@Composable
fun previewBootomNav(){
    val navController = rememberNavController()
    val destinationAction = rememberTopLevelDestinationNavigationAction(navController)
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    BottomNavigation(destinations = TopLevelDestination.values().toList(),
        onNavigateToDestination = destinationAction::navigate,
        currentDestination = currentDestination)
}

