package com.tricakrawala.batikpedia.screen.katalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.batikpedia.data.BatikRepository
import com.tricakrawala.batikpedia.model.KatalogBatik
import com.tricakrawala.batikpedia.model.Nusantara
import com.tricakrawala.batikpedia.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class KatalogViewModel(private val repository: BatikRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<KatalogBatik>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<KatalogBatik>>> get() = _uiState

    fun getAllBatik() {
        viewModelScope.launch {
            repository.getAllBatik()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { batik ->
                    _uiState.value = UiState.Success(batik)
                }
        }
    }

}