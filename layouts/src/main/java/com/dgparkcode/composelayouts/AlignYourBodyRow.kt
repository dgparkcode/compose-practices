package com.dgparkcode.composelayouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dgparkcode.composelayouts.ui.theme.LayoutsTheme

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
    alignYourBodyData: List<AlignYourBodyData> = emptyList(),
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyRowPreview() {
    LayoutsTheme {
        AlignYourBodyRow()
    }
}

data class AlignYourBodyData(
    val drawable: Int,
    val text: Int,
)