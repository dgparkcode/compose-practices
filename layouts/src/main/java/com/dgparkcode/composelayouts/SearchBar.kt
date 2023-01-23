package com.dgparkcode.composelayouts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dgparkcode.composelayouts.ui.theme.LayoutsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
                      Icon(
                          imageVector = Icons.Default.Search,
                          contentDescription = null
                      )
        },
        placeholder = {
                      Text(text = "placeholder")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    LayoutsTheme {
        SearchBar()
    }
}