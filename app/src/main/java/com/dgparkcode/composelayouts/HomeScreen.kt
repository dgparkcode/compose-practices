package com.dgparkcode.composelayouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dgparkcode.composelayouts.ui.theme.LayoutsTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val alignYourBodyData by remember {
        val data = listOf(
            AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
            AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
            AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
            AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions)
        )
        mutableStateOf(data)
    }

    val favoriteCollectionsData by remember {
        val data = listOf(
            FavoriteCollectionsData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
            FavoriteCollectionsData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
            FavoriteCollectionsData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
            FavoriteCollectionsData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
        )
        mutableStateOf(data)
    }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow(alignYourBodyData = alignYourBodyData)
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid(favoriteCollectionsData = favoriteCollectionsData)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, heightDp = 180)
@Composable
fun HomeScreenPreview() {
    LayoutsTheme {
        HomeScreen()
    }
}