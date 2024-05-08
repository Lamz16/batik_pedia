package com.tricakrawala.batikpedia.screen.katalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tricakrawala.batikpedia.ui.theme.BatikPediaTheme
import com.tricakrawala.batikpedia.ui.theme.background2

@Composable
fun KatalogScreen(
    modifier: Modifier = Modifier,
){
        KatalogContent()
}


@Composable
fun KatalogContent(
    modifier: Modifier = Modifier,
){
    Column(
        modifier
            .fillMaxSize()
            .background(background2)
    ) {
    }

}

@Preview
@Composable
private fun preview(){
    BatikPediaTheme {
        KatalogScreen()
    }
}