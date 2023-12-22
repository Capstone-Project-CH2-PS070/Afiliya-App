package com.silvy.subjetpack.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvy.subjetpack.data.ItemsRepository
import com.silvy.subjetpack.model.OrderItems
import com.silvy.subjetpack.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ItemsRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderItems>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderItems>>>
        get() = _uiState

    fun getAllItems() {
        viewModelScope.launch {
            repository.getAllItems()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            repository.search(query)
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderItems ->
                    _uiState.value = UiState.Success(orderItems)
                }
        }
    }
}