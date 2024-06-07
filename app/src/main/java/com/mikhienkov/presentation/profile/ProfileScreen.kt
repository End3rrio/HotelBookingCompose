package com.mikhienkov.presentation.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mikhienkov.R
import com.mikhienkov.presentation.designsystem.components.Avatar
import com.mikhienkov.presentation.designsystem.components.AvatarType
import com.mikhienkov.presentation.designsystem.components.Dialog
import com.mikhienkov.presentation.designsystem.components.Divider
import com.mikhienkov.presentation.designsystem.components.PrimaryButton
import com.mikhienkov.presentation.designsystem.components.SecondaryButton
import com.mikhienkov.presentation.designsystem.components.Toggle
import com.mikhienkov.presentation.designsystem.components.TopDestinationNavbar
import com.mikhienkov.presentation.designsystem.theme.BookingTheme

@Composable
fun ProfileScreen(
    onEditProfileClick: () -> Unit,
    onSecurityClick: () -> Unit,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val photoPickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                viewModel.handleIntent(ProfileIntent.UpdatePhoto(uri))
            }
        }
    var isLogoutDialogOpen by rememberSaveable { mutableStateOf(false) }

    ProfileScreenContent(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp),
        state = state,
        onEditPhotoClick = {
            photoPickerLauncher.launch(PickVisualMediaRequest((ActivityResultContracts.PickVisualMedia.ImageOnly)))
        },
        onDeletePhoto = { viewModel.handleIntent(ProfileIntent.UpdatePhoto(null)) },
        onEditProfileClick = onEditProfileClick,
        onPaymentClick = { /*TODO*/ },
        onNotificationsClick = { /*TODO*/ },
        onSecurityClick = onSecurityClick,
        onHelpClick = { /*TODO*/ },
        onDarkThemeCheckedChanged = {
            viewModel.handleIntent(ProfileIntent.ToggleDarkTheme(it))
        },
        onLogoutClick = { isLogoutDialogOpen = true }
    )

    LogoutDialog(
        open = isLogoutDialogOpen,
        onLogout = {
            isLogoutDialogOpen = false
            viewModel.handleIntent(ProfileIntent.Logout)
        },
        onDismiss = { isLogoutDialogOpen = false }
    )


}

@Composable
private fun ProfileScreenContent(
    state: ProfileScreenUiState,
    onEditPhotoClick: () -> Unit,
    onDeletePhoto: () -> Unit,
    onEditProfileClick: () -> Unit,
    onPaymentClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onSecurityClick: () -> Unit,
    onHelpClick: () -> Unit,
    onDarkThemeCheckedChanged: (Boolean) -> Unit,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        TopDestinationNavbar(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .statusBarsPadding(),
            title = stringResource(R.string.profile_screen_title)
        ) {
            if (state.isPhotoUploading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = BookingTheme.colors.primary500
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Profile(
                modifier = Modifier.padding(horizontal = 24.dp),
                isUserLoading = state.isUserLoading,
                photoUri = state.photoUri,
                name = state.name,
                email = state.email,
                onEditPhotoClick = onEditPhotoClick,
                onDeletePhoto = onDeletePhoto
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            )
            SettingCategories(
                spacing = 24.dp,
                darkTheme = state.darkTheme,
                onEditProfileClick = onEditProfileClick,
                onPaymentClick = onPaymentClick,
                onNotificationsClick = onNotificationsClick,
                onSecurityClick = onSecurityClick,
                onHelpClick = onHelpClick,
                onDarkThemeCheckedChanged = onDarkThemeCheckedChanged,
                onLogoutClick = onLogoutClick
            )
        }
    }
}


@Composable
private fun ColumnScope.Profile(
    isUserLoading: Boolean,
    photoUri: Uri?,
    name: String?,
    email: String,
    onEditPhotoClick: () -> Unit,
    onDeletePhoto: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textColor =
        if (BookingTheme.theme.isDark) BookingTheme.colors.white else BookingTheme.colors.greyscale900

    Avatar(
        modifier = modifier
            .size(100.dp)
            .align(Alignment.CenterHorizontally),
        uri = photoUri,
        onEditClick = onEditPhotoClick,
        onDeletePhoto = onDeletePhoto,
        type = AvatarType.EDIT
    )

    Spacer(modifier = Modifier.height(12.dp))


    AnimatedContent(
        modifier = modifier
            .align(Alignment.CenterHorizontally)
            .animateContentSize(),
        targetState = isUserLoading,
        label = "AnimatedContent",
        contentAlignment = Alignment.Center
    ) { loading ->
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = BookingTheme.colors.primary500,
            )
        } else {
            Column {
                if (name != null) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = name,
                        style = BookingTheme.typography.heading4,
                        color = textColor,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = email,
                    style = BookingTheme.typography.bodyMediumSemiBold,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
            }

        }
    }

}

@Composable
private fun SettingCategories(
    spacing: Dp,
    onEditProfileClick: () -> Unit,
    onPaymentClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onSecurityClick: () -> Unit,
    onHelpClick: () -> Unit,
    darkTheme: Boolean,
    onDarkThemeCheckedChanged: (Boolean) -> Unit,
    onLogoutClick: () -> Unit
) {
    SettingCategory(
        modifier = Modifier.fillMaxWidth(),
        icon = painterResource(id = R.drawable.ic_profile_border),
        text = stringResource(R.string.setting_category_edit_profile),
        onClick = onEditProfileClick
    )
    SettingCategory(
        modifier = Modifier.fillMaxWidth(),
        icon = painterResource(id = R.drawable.ic_wallet_border),
        text = stringResource(R.string.setting_category_payment),
        onClick = onPaymentClick
    )
    SettingCategory(
        modifier = Modifier.fillMaxWidth(),
        icon = painterResource(id = R.drawable.ic_notification_border),
        text = stringResource(R.string.setting_category_notifications),
        onClick = onNotificationsClick
    )
    SettingCategory(
        modifier = Modifier.fillMaxWidth(),
        icon = painterResource(id = R.drawable.ic_shield_done_border),
        text = stringResource(R.string.setting_category_security),
        onClick = onSecurityClick
    )
    SettingCategory(
        modifier = Modifier.fillMaxWidth(),
        icon = painterResource(id = R.drawable.ic_info_square_border),
        text = stringResource(R.string.setting_category_help),
        onClick = onHelpClick
    )
    SettingThemeCategory(
        modifier = Modifier.fillMaxWidth(),
        checked = darkTheme,
        onCheckedChange = onDarkThemeCheckedChanged
    )
    SettingLogoutCategory(
        modifier = Modifier.fillMaxWidth(),
        onClick = onLogoutClick
    )
}

@Composable
private fun SettingCategory(
    icon: Painter,
    text: String,
    modifier: Modifier = Modifier,
    color: Color = if (BookingTheme.theme.isDark) BookingTheme.colors.white else BookingTheme.colors.greyscale800,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(28.dp),
            painter = icon,
            contentDescription = null,
            tint = color
        )
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = text,
            style = BookingTheme.typography.bodyXLargeSemiBold,
            color = color
        )
    }
}

@Composable
private fun SettingThemeCategory(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(end = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SettingCategory(
            icon = painterResource(id = R.drawable.ic_show_border),
            text = stringResource(R.string.setting_category_dark_theme)
        )
        Toggle(checked = checked, onCheckedChange = onCheckedChange)
    }
}


@Composable
private fun SettingLogoutCategory(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SettingCategory(
        modifier = modifier,
        icon = painterResource(id = R.drawable.ic_logout_border),
        text = stringResource(R.string.setting_category_logout),
        onClick = onClick,
        color = BookingTheme.colors.error
    )
}


@Composable
private fun LogoutDialog(
    open: Boolean,
    onLogout: () -> Unit,
    onDismiss: () -> Unit
) {
    if (open) {
        Dialog(
            onDismissRequest = onDismiss
        ) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.logout_dialog_heading),
                    color = BookingTheme.colors.error,
                    style = BookingTheme.typography.heading4
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                )

                Text(
                    text = stringResource(R.string.logout_dialog_body),
                    style = BookingTheme.typography.heading6,
                    color = if (BookingTheme.theme.isDark) BookingTheme.colors.white else BookingTheme.colors.greyscale800,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.logout_dialog_positive_button),
                    onClick = onLogout
                )
                Spacer(modifier = Modifier.height(16.dp))
                SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.cancel),
                    onClick = onDismiss
                )

            }
        }
    }
}