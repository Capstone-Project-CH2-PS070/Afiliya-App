package com.silvy.subjetpack.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.silvy.subjetpack.R
import com.silvy.subjetpack.di.Injection
import com.silvy.subjetpack.ui.ViewModelFactory
import com.silvy.subjetpack.ui.common.UiState
import com.silvy.subjetpack.ui.components.OrderButton
import com.silvy.subjetpack.ui.components.ProductCounter
import com.silvy.subjetpack.ui.theme.Shapes
import com.silvy.subjetpack.ui.theme.SubJetpackTheme
import com.silvy.subjetpack.ui.theme.fontFamily

@Composable
fun DetailScreen(
    rewardId: Long,
    viewModel: DetailItemViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit,
    navigateToCart: () -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getItemsById(rewardId)
            }

            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.items.image,
                    data.items.title,
                    data.items.desc,
                    data.items.requiredPoint,
                    data.count,
                    onBackClick = navigateBack,
                    onAddToCart = { count ->
                        viewModel.addToCart(data.items, count)
                        navigateToCart()
                    }
                )
            }

            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    @DrawableRes image: Int,
    title: String,
    desc: String,
    basePoint: Int,
    count: Int,
    onBackClick: () -> Unit,
    onAddToCart: (count: Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    var totalPoint by rememberSaveable { mutableIntStateOf(0) }
    var orderCount by rememberSaveable { mutableIntStateOf(count) }

    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .testTag("detailScreen")
        ) {
            Box {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(400.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                )
                IconButton(
                    onClick = { onBackClick() },
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Icon Back"
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = fontFamily
                    ),
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = stringResource(R.string.required_point, basePoint),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = fontFamily
                    ),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = desc,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = fontFamily
                    ),
                    textAlign = TextAlign.Justify,
                    maxLines = 7,
                )
            }
        }
        Box(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .clip(Shapes.extraLarge)
                .height(4.dp)
                .background(MaterialTheme.colorScheme.secondaryContainer))
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            ProductCounter(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                1,
                orderCount,
                onProductIncreased = { orderCount++ }
            )
            { if (orderCount > 0) orderCount-- }
            totalPoint = basePoint * orderCount
            OrderButton(
                text = stringResource(R.string.add_to_cart, totalPoint),
                enabled = orderCount > 0,
                onClick = {
                    onAddToCart(orderCount)
                }
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    SubJetpackTheme {
        DetailContent(
            R.drawable.razer_cobra_pro,
            "Razer Cobra Pro",
            "The Razer BlackShark V2 is a premium gaming headset designed to elevate your gaming experience with cutting-edge audio technology. Engineered by Razer, a renowned brand in gaming peripherals, this headset delivers immersive sound quality, crystal-clear communication, and exceptional comfort during extended gaming sessions.",
            129,
            1,
            onBackClick = {},
            onAddToCart = {}
        )
    }
}