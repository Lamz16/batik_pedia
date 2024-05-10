package com.tricakrawala.batikpedia.screen.beritaacara

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.batikpedia.data.BatikRepository
import com.tricakrawala.batikpedia.model.Berita
import com.tricakrawala.batikpedia.model.KatalogBatik
import com.tricakrawala.batikpedia.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class BeritaViewModel(private val repository: BatikRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Berita>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Berita>>> get() = _uiState

    fun getAllBerita() {
        viewModelScope.launch {
            repository.getAllBerita()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { berita ->
                    _uiState.value = UiState.Success(berita)
                }
        }
    }

}