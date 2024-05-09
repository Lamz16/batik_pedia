package com.tricakrawala.batikpedia.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.batikpedia.data.BatikRepository
import com.tricakrawala.batikpedia.model.Nusantara
import com.tricakrawala.batikpedia.model.Rekomendasi
import com.tricakrawala.batikpedia.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: BatikRepository) : ViewModel() {

    private val _uiStateNusantara: MutableStateFlow<UiState<List<Nusantara>>> =
        MutableStateFlow(UiState.Loading)
    val uiStateNusantara: StateFlow<UiState<List<Nusantara>>> get() = _uiStateNusantara


    private val _uiStateRekomendasi: MutableStateFlow<UiState<List<Rekomendasi>>> =
        MutableStateFlow(UiState.Loading)
    val uiStateRekomendasi: StateFlow<UiState<List<Rekomendasi>>> get() = _uiStateRekomendasi

    fun getAllNusantara() {
        viewModelScope.launch {
            repository.getAllNusantara()
                .catch {
                    _uiStateNusantara.value = UiState.Error(it.message.toString())
                }
                .collect { nusantara ->
                    _uiStateNusantara.value = UiState.Success(nusantara)
                }
        }
    }


    fun getAllRekomendasi() {
        viewModelScope.launch {
            repository.getAllRekomendasi()
                .catch {
                    _uiStateRekomendasi.value = UiState.Error(it.message.toString())
                }
                .collect { rekomendasi ->
                    _uiStateRekomendasi.value = UiState.Success(rekomendasi)
                }
        }
    }


}