package com.tricakrawala.batikpedia.screen.provinsi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.batikpedia.data.BatikRepository
import com.tricakrawala.batikpedia.model.Nusantara
import com.tricakrawala.batikpedia.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProvinsiViewModel(private val repository: BatikRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Nusantara>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Nusantara>>> get() = _uiState


    fun getAllNusantara() {
        viewModelScope.launch {
            repository.getAllNusantara()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { nusantara ->
                    _uiState.value = UiState.Success(nusantara)
                }
        }
    }
}