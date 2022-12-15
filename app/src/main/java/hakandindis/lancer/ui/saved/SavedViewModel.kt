package hakandindis.lancer.ui.saved

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hakandindis.lancer.data.repository.SavedRepository
import javax.inject.Inject


@HiltViewModel
class SavedViewModel @Inject constructor(private val savedRepository: SavedRepository) : ViewModel() {
}