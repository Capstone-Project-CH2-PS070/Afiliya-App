package com.silvy.subjetpack.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvy.subjetpack.data.ItemsRepository
import com.silvy.subjetpack.model.OrderItems
import com.silvy.subjetpack.model.Items
import com.silvy.subjetpack.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailItemViewModel(
    private val repository: ItemsRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderItems>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderItems>>
        get() = _uiState

    fun getItemsById(itemId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderItemsById(itemId))
        }
    }

    fun addToCart(items: Items, count: Int) {
        viewModelScope.launch {
            repository.updateOrderItems(items.id, count)
        }
    }
}