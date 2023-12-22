package com.silvy.subjetpack.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silvy.subjetpack.ui.theme.SubJetpackTheme

@Composable
fun ProductCounter(
    modifier: Modifier = Modifier,
    orderId: Long,
    orderCount: Int,
    onProductIncreased: (Long) -> Unit,
    onProductDecreased: (Long) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        FilledIconButton(
            onClick = { onProductDecreased(orderId) },
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "Minus",
                modifier = Modifier.testTag("counterMinus")
            )
        }
        Text(
            text = orderCount.toString(),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .width(30.dp)
                .align(Alignment.CenterVertically)
                .testTag("productCounter")
        )
        FilledIconButton(
            onClick = { onProductIncreased(orderId) },
        ) {
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Add",
                modifier = Modifier.testTag("counterAdd")
            )
        }
    }
}

@Preview
@Composable
fun ProductCounterPreview() {
    SubJetpackTheme {
        ProductCounter(
            orderId = 1,
            orderCount = 0,
            onProductIncreased = { }
        ) { }
    }
}
