package com.tricakrawala.batikpedia.screen.detailbatik

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.batikpedia.data.BatikRepository
import com.tricakrawala.batikpedia.model.KatalogBatik
import com.tricakrawala.batikpedia.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailBatikViewModel(private val repository: BatikRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<KatalogBatik>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<KatalogBatik>> get() = _uiState

    fun getAllWisata(idBatik : Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getBatikById(idBatik))
        }
    }
}