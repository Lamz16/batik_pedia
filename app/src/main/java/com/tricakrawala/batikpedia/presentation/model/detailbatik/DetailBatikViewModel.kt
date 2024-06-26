package com.tricakrawala.batikpedia.presentation.model.detailbatik

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.batikpedia.data.resource.remote.response.KatalogId
import com.tricakrawala.batikpedia.domain.usecase.BatikPediaUseCase
import com.tricakrawala.batikpedia.presentation.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailBatikViewModel @Inject constructor(private val batik : BatikPediaUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<KatalogId>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<KatalogId>> get() = _uiState

    fun getDetailBatik(idBatik : Int) {
        viewModelScope.launch {
            batik.getBatikById(idBatik).catch {
                _uiState.value = UiState.Error(it.message ?: "Unknown Error")
            }
                .collect{
                _uiState.value = it
            }
        }
    }
}