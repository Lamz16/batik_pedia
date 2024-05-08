package com.tricakrawala.batikpedia.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tricakrawala.batikpedia.ui.theme.background2

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: () -> Unit,
){
    Box(modifier.fillMaxSize().background(background2)
    ){
        HomeContent(navigateToDetail = navigateToDetail)
    }
}


@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    navigateToDetail: () -> Unit,
){
    Column(Modifier.background(background2)) {
        Text(text = "Halooo")
    }

}