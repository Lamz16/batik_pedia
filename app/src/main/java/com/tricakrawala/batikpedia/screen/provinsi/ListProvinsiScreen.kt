package com.tricakrawala.batikpedia.screen.provinsi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.batikpedia.R
import com.tricakrawala.batikpedia.model.Nusantara
import com.tricakrawala.batikpedia.ui.common.UiState
import com.tricakrawala.batikpedia.ui.components.ProvinsiItemRow
import com.tricakrawala.batikpedia.ui.components.SearchBarKatalog
import com.tricakrawala.batikpedia.ui.theme.BatikPediaTheme
import com.tricakrawala.batikpedia.ui.theme.background2
import com.tricakrawala.batikpedia.ui.theme.poppinsFontFamily
import com.tricakrawala.batikpedia.ui.theme.textColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListProvinsiScreen(
    modifier: Modifier = Modifier,
    viewModel: ProvinsiViewModel= koinViewModel(),
    navigateToDetail : () -> Unit,
){

    val uiState by viewModel.uiState.collectAsState(initial = UiState.Loading)
    LaunchedEffect(true) {
        if (uiState is UiState.Loading) {
            viewModel.getAllNusantara()
        }
    }

    when (val nusantara = uiState) {
        is UiState.Success -> {
            ListProvinsiContent( navigateToDetail = navigateToDetail, listProvinsi = nusantara.data)
        }

        is UiState.Error -> {}
        else -> {

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListProvinsiContent(
    modifier: Modifier = Modifier,
    listProvinsi : List<Nusantara>,
    navigateToDetail: () -> Unit,
){
    var query by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .background(background2)
            .fillMaxSize()
            .statusBarsPadding()

    ) {
        Image(
            painter = painterResource(id = R.drawable.ornamen_batik_beranda),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(180.dp)

        )

        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.menu_provinsi),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = textColor,
                    fontSize = 16.sp
                )
            },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.Transparent)
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 88.dp, start = 24.dp, end = 24.dp)


        ) {
            SearchBarKatalog(
                query = query,
                onQueryChange = { newQuery -> query = newQuery },
                modifier = Modifier
                    .fillMaxWidth()
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp).navigationBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(end = 4.dp, start = 4.dp, bottom = 4.dp),
            ) {
                items(listProvinsi){data ->
                    ProvinsiItemRow(image = data.image, provinsi = data.provinsi)
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun preview(){
    val dummyProvinsi = listOf(
        Nusantara(1, R.drawable.yogyakarta, "Yogyakarta"),
        Nusantara(2, R.drawable.yogyakarta, "Yogyakarta"),
        Nusantara(3, R.drawable.yogyakarta, "Yogyakarta"),
        Nusantara(4, R.drawable.yogyakarta, "Yogyakarta"),
        Nusantara(5, R.drawable.yogyakarta, "Yogyakarta"),
        Nusantara(6, R.drawable.yogyakarta, "Yogyakarta"),
        Nusantara(7, R.drawable.yogyakarta, "Yogyakarta"),
        Nusantara(8, R.drawable.yogyakarta, "Yogyakarta"),
        Nusantara(9, R.drawable.yogyakarta, "Yogyakarta"),
    )
    BatikPediaTheme {

        ListProvinsiContent(listProvinsi = dummyProvinsi) {
        }
    }
}