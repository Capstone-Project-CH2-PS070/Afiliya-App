package com.silvy.subjetpack.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvy.subjetpack.data.ItemsRepository
import com.silvy.subjetpack.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: ItemsRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrderItems() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderItems()
                .collect { orderReward ->
                    val totalRequiredPoint =
                        orderReward.sumOf { it.items.requiredPoint * it.count }
                    _uiState.value = UiState.Success(CartState(orderReward, totalRequiredPoint))
                }
        }
    }

    fun updateOrderItems(itemsId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateOrderItems(itemsId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderItems()
                    }
                }
        }
    }
}