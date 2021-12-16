package com.example.todokotlinandroid.features.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.todokotlinandroid.*
import com.example.todokotlinandroid.R
import com.example.todokotlinandroid.colors.LightRed
import com.example.todokotlinandroid.models.Category
import kotlinx.coroutines.channels.Channel


@Composable
fun CategoriesScreen(viewModel: CategoriesViewModel) {
    val viewState = viewModel.viewState.collectAsState().value
    val intentChannel = viewModel.intentChannel

    if (viewState.categories.isEmpty()) {
        CategoriesEmptyScreen(intentChannel)
    } else {
        CategoriesScreen(intentChannel, viewState)
        }
    }

@OptIn(ExperimentalUnitApi::class)
@Composable
internal fun CategoriesScreen(intentChannel: Channel<CategoryIntent>, viewState: CategoriesViewState) {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.default_margin ),
                    top = 30.dp,
                    end = 31.dp
                )
        ) {
            Text(
                text = "Categories",
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(32f, TextUnitType.Sp)
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
            items(viewState.categories.size) { index ->
                val category = viewState.categories[index]
                CategoryItemView(intentChannel, category)
            }

        }
    }
}

@Composable
private fun CategoryItemView(intentChannel: Channel<CategoryIntent>, category: Category) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        bottomStart = 10.dp,
                        topStart = dimensionResource(id = R.dimen.corner_radius)
                    )
                )
                .background(LightRed)
                .width(251.dp)
                .clickable { intentChannel.trySend(CategoryIntent.CategoryClicked(category.id)) }

        ) {
            Text(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.default_margin),
                        top = dimensionResource(id = R.dimen.default_margin)),
                text = "${category.name} (${category.totalItems})",
                color = Color.White
            )

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 57.dp,
                        end = dimensionResource(id = R.dimen.default_margin),
                        bottom = dimensionResource(id = R.dimen.default_margin)
                    )
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            end = dimensionResource(id = R.dimen.default_margin)
                        ),
                    text = "Add item +",
                    color = Color.White)

            }
        }
    }

}

@Preview(" CategoriesScreen Preview")
@Composable
fun CategoriesScreenPreview() {
    MaterialTheme {
        CategoriesScreen(Channel(), CategoriesViewState())
    }
}


@Preview(" CategoriesEmptyScreen Preview")
@Composable
fun CategoriesEmptyScreenPreview() {
    MaterialTheme {
        CategoriesEmptyScreen(Channel())
    }
}