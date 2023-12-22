package com.sub.afiliya.data

import com.sub.afiliya.model.ItemsDataSource
import com.sub.afiliya.model.OrderItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class ItemsRepository {

    private val orderItems = mutableListOf<OrderItems>()

    init {
        if (orderItems.isEmpty()) {
            ItemsDataSource.dummyItems.forEach {
                orderItems.add(OrderItems(it, 0))
            }
        }
    }

    fun getAllItems(): Flow<List<OrderItems>> {
        return flowOf(orderItems)
    }

    fun getOrderItemsById(itemsId: Long): OrderItems {
        return orderItems.first {
            it.items.id == itemsId
        }
    }

    fun updateOrderItems(itemsId: Long, newCountValue: Int): Flow<Boolean> {
        val index = orderItems.indexOfFirst { it.items.id == itemsId }
        val result = if (index >= 0) {
            val orderReward = orderItems[index]
            orderItems[index] =
                orderReward.copy(items = orderReward.items, count = newCountValue)
            true
        } else {
            false
        }
        return flowOf(result)
    }

    fun getAddedOrderItems(): Flow<List<OrderItems>> {
        return getAllItems()
            .map { orderRewards ->
                orderRewards.filter { orderReward ->
                    orderReward.count != 0
                }
            }
    }

    fun search(query: String): Flow<List<OrderItems>> {
        return getAllItems()
            .map { orderRewards ->
                orderRewards.filter { orderReward ->
                    orderReward.items.title.contains(query, ignoreCase = true)
                }
            }
    }

    companion object {
        @Volatile
        private var instance: ItemsRepository? = null

        fun getInstance(): ItemsRepository =
            instance ?: synchronized(this) {
                ItemsRepository().apply {
                    instance = this
                }
            }
    }
}