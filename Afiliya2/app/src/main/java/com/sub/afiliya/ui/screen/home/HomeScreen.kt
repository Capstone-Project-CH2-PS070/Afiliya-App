package com.silvy.subjetpack.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.silvy.subjetpack.R
import com.silvy.subjetpack.di.Injection
import com.silvy.subjetpack.model.OrderItems
import com.silvy.subjetpack.ui.ViewModelFactory
import com.silvy.subjetpack.ui.common.UiState
import com.silvy.subjetpack.ui.components.SellItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit
) {
    var search by remember { mutableStateOf("") }

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllItems()
            }
            is UiState.Success -> {
                HomeContent(
                    orderItems = uiState.data,
                    modifier = modifier,
                    search = search,
                    onSearchQueryChanged = { newQuery ->
                        search = newQuery
                        viewModel.search(newQuery)
                    },
                    navigateToDetail = navigateToDetail,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    orderItems: List<OrderItems>,
    search: String,
    onSearchQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                actions = {
                    SearchBar(
                        query = search,
                        onQueryChange = onSearchQueryChanged,
                    )
                },
            )
        },
    ){ innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = innerPadding,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.padding(16.dp).testTag("homeScreen")
        ) {
            items(orderItems) { data ->
                SellItem(
                    image = data.items.image,
                    title = data.items.title,
                    requiredPoint = data.items.requiredPoint,
                    modifier = modifier.clickable {
                        navigateToDetail(data.items.id)
                    }.testTag("item${data.items.id}")
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier.padding(bottom = 16.dp)
) {
    SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )
        },
        placeholder = {
            Text(stringResource(R.string.search), color = MaterialTheme.colorScheme.onBackground)
        },
        shape = MaterialTheme.shapes.large,
        colors = SearchBarDefaults.colors(MaterialTheme.colorScheme.secondaryContainer),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    ) {
    }
}