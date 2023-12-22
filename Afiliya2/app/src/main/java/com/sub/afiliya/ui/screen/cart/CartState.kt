package com.silvy.subjetpack.ui.screen.cart

import com.silvy.subjetpack.model.OrderItems

data class CartState(
    val orderItems: List<OrderItems>,
    val totalRequiredPoint: Int
)