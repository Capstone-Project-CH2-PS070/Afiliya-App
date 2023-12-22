package com.silvy.subjetpack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silvy.subjetpack.R
import com.silvy.subjetpack.ui.theme.Shapes
import com.silvy.subjetpack.ui.theme.SubJetpackTheme
import com.silvy.subjetpack.ui.theme.fontFamily

@Composable
fun SellItem(
    image: Int,
    title: String,
    requiredPoint: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "Sell Items",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .clip(Shapes.medium)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        )
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
            text = stringResource(R.string.required_point, requiredPoint),
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall.copy(
                fontFamily = fontFamily
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SellItemPreview() {
    SubJetpackTheme {
        SellItem(R.drawable.razer_cobra_pro, "Razer Cobra Pro", 129)
    }
}