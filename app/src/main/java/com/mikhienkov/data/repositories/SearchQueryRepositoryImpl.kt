package com.mikhienkov.data.repositories

import com.google.firebase.firestore.FirebaseFirestore
import com.mikhienkov.data.database.searchquery.FirestoreSearchQueryConfig
import com.mikhienkov.data.database.searchquery.SearchQueryDocument
import com.mikhienkov.domain.entities.SearchQuery
import com.mikhienkov.domain.repositories.SearchQueryRepository
import com.mikhienkov.domain.repositories.UserRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SearchQueryRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val userRepository: UserRepository
) : SearchQueryRepository {
    private val uid get() = userRepository.currentUser!!.uid

    override fun getSearchQueries(): Flow<List<SearchQuery>> {
        val ref = firestore.collection(FirestoreSearchQueryConfig.Collections.SearchQueries.ROOT)
            .document(uid)
            .collection(FirestoreSearchQueryConfig.Collections.SearchQueries.USER_SEARCH_QUERIES)

        return callbackFlow {
            val listener = ref.addSnapshotListener { value, _ ->
                val data = value
                    ?.toObjects(SearchQueryDocument::class.java)
                    ?.map { it.toDomain() }
                    ?: emptyList()

                trySend(data)
            }

            awaitClose {
                listener.remove()
            }
        }

    }

    override suspend fun deleteSearchQuery(id: String) {
        firestore.collection(FirestoreSearchQueryConfig.Collections.SearchQueries.ROOT)
            .document(uid)
            .collection(FirestoreSearchQueryConfig.Collections.SearchQueries.USER_SEARCH_QUERIES)
            .document(id)
            .delete()
            .await()
    }

    override suspend fun addSearchQuery(query: String) {
        val ref = firestore.collection(FirestoreSearchQueryConfig.Collections.SearchQueries.ROOT)
            .document(uid)
            .collection(FirestoreSearchQueryConfig.Collections.SearchQueries.USER_SEARCH_QUERIES)
            .document()

        val data = SearchQueryDocument(id = ref.id, text = query)

        ref
            .set(data)
            .await()
    }
}