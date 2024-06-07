package com.mikhienkov.di

import com.mikhienkov.domain.usecases.AddSearchQueryUseCase
import com.mikhienkov.domain.usecases.AddSearchQueryUseCaseImpl
import com.mikhienkov.domain.usecases.BookHotelUseCase
import com.mikhienkov.domain.usecases.BookHotelUseCaseImpl
import com.mikhienkov.domain.usecases.BookmarkHotelUseCase
import com.mikhienkov.domain.usecases.BookmarkHotelUseCaseImpl
import com.mikhienkov.domain.usecases.CancelBookingUseCase
import com.mikhienkov.domain.usecases.CancelBookingUseCaseImpl
import com.mikhienkov.domain.usecases.ChangePasswordUseCase
import com.mikhienkov.domain.usecases.ChangePasswordUseCaseImpl
import com.mikhienkov.domain.usecases.DeleteProfileUseCase
import com.mikhienkov.domain.usecases.DeleteProfileUseCaseImpl
import com.mikhienkov.domain.usecases.DeleteSearchQueryUseCase
import com.mikhienkov.domain.usecases.DeleteSearchQueryUseCaseImpl
import com.mikhienkov.domain.usecases.FinishOnboardingUseCase
import com.mikhienkov.domain.usecases.FinishOnboardingUseCaseImpl
import com.mikhienkov.domain.usecases.GetAppPreferencesUseCase
import com.mikhienkov.domain.usecases.GetAppPreferencesUseCaseImpl
import com.mikhienkov.domain.usecases.GetBookedHotelsUseCase
import com.mikhienkov.domain.usecases.GetBookedHotelsUseCaseImpl
import com.mikhienkov.domain.usecases.GetBookingPriceUseCase
import com.mikhienkov.domain.usecases.GetBookingPriceUseCaseImpl
import com.mikhienkov.domain.usecases.GetBookmarkedHotelsUseCase
import com.mikhienkov.domain.usecases.GetBookmarkedHotelsUseCaseImpl
import com.mikhienkov.domain.usecases.GetHotelCountriesUseCase
import com.mikhienkov.domain.usecases.GetHotelCountriesUseCaseImpl
import com.mikhienkov.domain.usecases.GetHotelDetailsUseCase
import com.mikhienkov.domain.usecases.GetHotelDetailsUseCaseImpl
import com.mikhienkov.domain.usecases.GetHotelImagesUseCase
import com.mikhienkov.domain.usecases.GetHotelImagesUseCaseImpl
import com.mikhienkov.domain.usecases.GetHotelReviewsUseCase
import com.mikhienkov.domain.usecases.GetHotelReviewsUseCaseImpl
import com.mikhienkov.domain.usecases.GetRecentlyBookedHotelsUseCase
import com.mikhienkov.domain.usecases.GetRecentlyBookedHotelsUseCaseImpl
import com.mikhienkov.domain.usecases.GetHotelsByCategoryUseCase
import com.mikhienkov.domain.usecases.GetHotelsByCategoryUseCaseImpl
import com.mikhienkov.domain.usecases.GetSearchQueriesUseCase
import com.mikhienkov.domain.usecases.GetSearchQueriesUseCaseImpl
import com.mikhienkov.domain.usecases.GetUserPhotoUseCaseImpl
import com.mikhienkov.domain.usecases.GetUserPhotoUseCase
import com.mikhienkov.domain.usecases.GetUserUseCase
import com.mikhienkov.domain.usecases.GetUserUseCaseImpl
import com.mikhienkov.domain.usecases.IsPasswordChangeAvailableUseCase
import com.mikhienkov.domain.usecases.IsPasswordChangeAvailableUseCaseImpl
import com.mikhienkov.domain.usecases.ObserveUserUseCase
import com.mikhienkov.domain.usecases.ObserveUserUseCaseImpl
import com.mikhienkov.domain.usecases.SearchHotelsUseCase
import com.mikhienkov.domain.usecases.SearchHotelsUseCaseImpl
import com.mikhienkov.domain.usecases.SignInWithEmailAndPasswordUseCase
import com.mikhienkov.domain.usecases.SignInWithEmailAndPasswordUseCaseImpl
import com.mikhienkov.domain.usecases.SignInWithGoogleUseCase
import com.mikhienkov.domain.usecases.SignInWithGoogleUseCaseImpl
import com.mikhienkov.domain.usecases.SignOutUseCase
import com.mikhienkov.domain.usecases.SignOutUseCaseImpl
import com.mikhienkov.domain.usecases.SignUpWithEmailAndPasswordUseCase
import com.mikhienkov.domain.usecases.SignUpWithEmailAndPasswordUseCaseImpl
import com.mikhienkov.domain.usecases.UpdateProfileUseCase
import com.mikhienkov.domain.usecases.UpdateProfileUseCaseImpl
import com.mikhienkov.domain.usecases.UpdateRememberMeUseCase
import com.mikhienkov.domain.usecases.UpdateRememberMeUseCaseImpl
import com.mikhienkov.domain.usecases.UpdateThemePreferenceUseCase
import com.mikhienkov.domain.usecases.UpdateThemePreferenceUseCaseImpl
import com.mikhienkov.domain.usecases.UpdateUserPhotoUseCase
import com.mikhienkov.domain.usecases.UpdateUserPhotoUseCaseImpl
import com.mikhienkov.domain.usecases.ValidateEmailUseCase
import com.mikhienkov.domain.usecases.ValidateEmailUseCaseImpl
import com.mikhienkov.domain.usecases.ValidatePasswordUseCase
import com.mikhienkov.domain.usecases.ValidatePasswordUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsFinishOnboardingUseCase(impl: FinishOnboardingUseCaseImpl): FinishOnboardingUseCase

    @Binds
    fun bindsUpdateThemePreferenceUseCase(impl: UpdateThemePreferenceUseCaseImpl): UpdateThemePreferenceUseCase

    @Binds
    fun bindsGetAppPreferencesUseCase(impl: GetAppPreferencesUseCaseImpl): GetAppPreferencesUseCase

    @Binds
    fun bindsSignInWithGoogleUseCase(impl: SignInWithGoogleUseCaseImpl): SignInWithGoogleUseCase

    @Binds
    fun bindsSignInWithEmailAndPasswordUseCase(impl: SignInWithEmailAndPasswordUseCaseImpl): SignInWithEmailAndPasswordUseCase

    @Binds
    fun bindsSignUpWithEmailAndPasswordUseCase(impl: SignUpWithEmailAndPasswordUseCaseImpl): SignUpWithEmailAndPasswordUseCase

    @Binds
    fun bindsValidateEmailUseCase(impl: ValidateEmailUseCaseImpl): ValidateEmailUseCase

    @Binds
    fun bindsValidatePasswordUseCase(impl: ValidatePasswordUseCaseImpl): ValidatePasswordUseCase

    @Binds
    fun bindsSignOutUseCase(impl: SignOutUseCaseImpl): SignOutUseCase

    @Binds
    fun bindsUpdateProfileUseCase(impl: UpdateProfileUseCaseImpl): UpdateProfileUseCase

    @Binds
    fun bindsUpdateUserPhotoUseCase(impl: UpdateUserPhotoUseCaseImpl): UpdateUserPhotoUseCase

    @Binds
    fun bindsGetUserPhotoUseCase(impl: GetUserPhotoUseCaseImpl): GetUserPhotoUseCase

    @Binds
    fun bindsGetUserUseCase(impl: GetUserUseCaseImpl): GetUserUseCase

    @Binds
    fun bindsObserveUserUseCase(impl: ObserveUserUseCaseImpl): ObserveUserUseCase

    @Binds
    fun bindsUpdateRememberMeUseCase(impl: UpdateRememberMeUseCaseImpl): UpdateRememberMeUseCase

    @Binds
    fun bindsDeleteProfileUseCase(impl: DeleteProfileUseCaseImpl): DeleteProfileUseCase

    @Binds
    fun bindsChangePasswordUseCase(impl: ChangePasswordUseCaseImpl): ChangePasswordUseCase

    @Binds
    fun bindsIsPasswordChangeAvailableUseCase(impl: IsPasswordChangeAvailableUseCaseImpl): IsPasswordChangeAvailableUseCase

    @Binds
    fun bindsGetHotelsByCategoryUseCase(impl: GetHotelsByCategoryUseCaseImpl): GetHotelsByCategoryUseCase

    @Binds
    fun bindsBookmarkHotelUseCase(impl: BookmarkHotelUseCaseImpl): BookmarkHotelUseCase

    @Binds
    fun bindsGetRecentlyBookedHotelsUseCase(impl: GetRecentlyBookedHotelsUseCaseImpl): GetRecentlyBookedHotelsUseCase

    @Binds
    fun bindsGetBookmarkedHotelsUseCase(impl: GetBookmarkedHotelsUseCaseImpl): GetBookmarkedHotelsUseCase

    @Binds
    fun bindsDeleteSearchQueryUseCase(impl: DeleteSearchQueryUseCaseImpl): DeleteSearchQueryUseCase

    @Binds
    fun bindsGetSearchQueriesUseCase(impl: GetSearchQueriesUseCaseImpl): GetSearchQueriesUseCase

    @Binds
    fun bindsAddSearchQueryUseCase(impl: AddSearchQueryUseCaseImpl): AddSearchQueryUseCase

    @Binds
    fun bindsSearchHotelsUseCase(impl: SearchHotelsUseCaseImpl): SearchHotelsUseCase

    @Binds
    fun bindsGetHotelCountriesUseCase(impl: GetHotelCountriesUseCaseImpl): GetHotelCountriesUseCase

    @Binds
    fun bindsGetHotelDetailsUseCase(impl: GetHotelDetailsUseCaseImpl): GetHotelDetailsUseCase

    @Binds
    fun bindsGetHotelReviewsUseCase(impl: GetHotelReviewsUseCaseImpl): GetHotelReviewsUseCase

    @Binds
    fun bindsGetHotelImagesUseCase(impl: GetHotelImagesUseCaseImpl): GetHotelImagesUseCase

    @Binds
    fun bindsGetBookingPriceUseCase(impl: GetBookingPriceUseCaseImpl): GetBookingPriceUseCase

    @Binds
    fun bindsBookHotelUseCase(impl: BookHotelUseCaseImpl): BookHotelUseCase

    @Binds
    fun bindsGetBookedHotelsUseCase(impl: GetBookedHotelsUseCaseImpl): GetBookedHotelsUseCase

    @Binds
    fun bindsCancelBookingUseCase(impl: CancelBookingUseCaseImpl): CancelBookingUseCase
}