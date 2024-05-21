package com.bush.littlelemoncappro.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bush.littlelemoncappro.R

@Composable
fun AppHeader() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.little_lemon_logo_trans_bg),
            contentDescription = "Logo",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(50.dp)
                .align(Alignment.Center)
                .padding(vertical = 10.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Pic",
            modifier = Modifier
                .height(30.dp)
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        )
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    AppHeader()
}