package com.example.todokotlinandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Category(val id: Int, val name: String,)

@Composable
fun CategoriesView(
    categoriesList: List<Category>,
    onCategoryClick: () -> Unit
) {
    if (categoriesList.isEmpty()) {
        CategoriesEmptyScreen()
    } else {
        CategoriesScreen(categoriesList = categoriesList, onCategoryClick = onCategoryClick)

        }
    }

@Composable
internal fun CategoriesScreen(
    categoriesList: List<Category>,
    onCategoryClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.default_margin),
                    top = 30.dp,
                    end = 31.dp
                )
        ) {
            Text(
                text = "Categories",
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = "+",
                fontWeight = FontWeight.Bold
                )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(categoriesList.size) { index ->
                val category = categoriesList[index]
                CategoryItemView(category)
            }

        }
    }
}

@Composable
private fun CategoryItemView(category: Category) {
    Box(
        modifier = Modifier
            .clickable { }
            .fillMaxSize()
            .background(LightRed)
            .height(123.dp)
            .defaultMinSize(251.dp)
            .padding(
                end = 0.dp,
                top = 41.dp
            ),
    ) {
        Text(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.default_margin),
                    top = dimensionResource(id = R.dimen.default_margin)),
            text = category.name,
            color = Color.White
        )

        Text(
            modifier = Modifier
                .padding(
                    bottom = dimensionResource(id = R.dimen.default_margin),
                    end = dimensionResource(id = R.dimen.default_margin)
                ),
            text = "Add item +",
            color = Color.White)

    }
}

@Preview(" CategoriesScreen Preview")
@Composable
fun CategoriesScreenPreview() {
    MaterialTheme {
        CategoriesScreen(
            categoriesList = listOf(Category(1, "Nesto"), Category(2, "Nesto")),
            onCategoryClick = {}
        )
    }
}


@Preview(" CategoriesEmptyScreen Preview")
@Composable
fun CategoriesEmptyScreenPreview() {
    MaterialTheme {
        CategoriesEmptyScreen()
    }
}