package crystalrockcoffee.store.app.data.repository

import crystalrockcoffee.store.app.data.datastore.RSRKCOnboardingPrefs
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RSRKCOnboardingRepo(
    private val rsrkcOnboardingStoreManager: RSRKCOnboardingPrefs,
    private val coroutineDispatcher: CoroutineDispatcher,
) {

    fun observeOnboardingState(): Flow<Boolean?> {
        return rsrkcOnboardingStoreManager.onboardedStateFlow
    }

    suspend fun setOnboardingState(state: Boolean) {
        withContext(coroutineDispatcher) {
            rsrkcOnboardingStoreManager.setOnboardedState(state)
        }
    }
}