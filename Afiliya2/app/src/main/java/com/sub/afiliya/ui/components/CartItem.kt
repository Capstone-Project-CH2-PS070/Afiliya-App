package com.silvy.subjetpack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silvy.subjetpack.ui.theme.SubJetpackTheme
import com.silvy.subjetpack.ui.theme.Shapes
import com.silvy.subjetpack.R
import com.silvy.subjetpack.ui.theme.fontFamily

@Composable
fun CartItem(
    rewardId: Long,
    image: Int,
    title: String,
    totalPoint: Int,
    count: Int,
    onProductCountChanged: (id: Long, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth().testTag("cartScreen")
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(Shapes.small)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1.0f)
        ) {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = fontFamily
                )
            )
            Text(
                text = stringResource(
                    R.string.required_point,
                    totalPoint
                ),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontFamily = fontFamily
                )
            )
        }
        ProductCounter(
            modifier = Modifier.align(Alignment.CenterVertically),
            orderId = rewardId,
            orderCount = count,
            onProductIncreased = { onProductCountChanged(rewardId, count + 1) }
        ) { onProductCountChanged(rewardId, count - 1) }
    }
}

@Composable
@Preview(showBackground = true)
fun CartItemPreview() {
    SubJetpackTheme {
        CartItem(
            4, R.drawable.razer_cobra_pro, "Razer Cobra Pro", 129, 0,
            onProductCountChanged = { _, _ -> },
        )
    }
}