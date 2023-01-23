package com.dgparkcode.composelayouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dgparkcode.composelayouts.ui.theme.LayoutsTheme

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
    favoriteCollectionsData: List<FavoriteCollectionsData> = emptyList(),
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.height(120.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(56.dp)
            )
        }
    }
}

data class FavoriteCollectionsData(
    val drawable: Int,
    val text: Int,
)

@Preview(showBackground = true)
@Composable
fun FavoriteCollectionsGridPreview() {
    LayoutsTheme {
        FavoriteCollectionsGrid()
    }
}