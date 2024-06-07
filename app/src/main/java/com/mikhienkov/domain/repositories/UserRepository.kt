package com.mikhienkov.domain.repositories

import android.net.Uri
import com.google.firebase.auth.FirebaseUser
import com.mikhienkov.domain.entities.User
import com.mikhienkov.domain.usecases.SignInWithGoogleResult
import com.mikhienkov.domain.valueobjects.Gender
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface UserRepository {
    val currentUser: FirebaseUser?
    suspend fun getUser(): User
    fun observeUser(): Flow<User>

    suspend fun authenticateWithGoogle(token: String): SignInWithGoogleResult?

    suspend fun signInWithEmailAndPassword(email: String, password: String)
    suspend fun signUpWithEmailAndPassword(email: String, password: String)

    suspend fun signOut()
    suspend fun getSignInMethodsForEmail(email: String): List<String>
    suspend fun uploadPhoto(uri: Uri): Uri
    suspend fun deletePhoto()
    suspend fun updateUser(fullName: String?, dateOfBirth: LocalDate?, gender: Gender?)
    suspend fun setNameAndEmailFromCurrentUser()

    suspend fun updateUserPhoto(photoUri: Uri?)
    fun observeUserPhoto(): Flow<Uri?>
    suspend fun deleteProfile()
    suspend fun updatePassword(currentPassword: String, password: String)
}