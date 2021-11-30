package com.example.todokotlinandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable

internal fun CategoriesView() {

}


@Preview
@Composable

internal fun CategoriesScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.default_margin),
                    top  = dimensionResource(id = R.dimen.default_margin)
                )
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Categories",
                fontWeight = FontWeight.Bold
            )
            
            Text(
                modifier = Modifier
                    .fillMaxSize(),
                text = "+",
                fontWeight = FontWeight.Bold
                )
        }

        Box(
            modifier = Modifier
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
                text = "HomeList",
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GreenColor)
                .height(123.dp)
                .defaultMinSize(251.dp)
                .padding(
                    end = 0.dp,
                    top = 8.dp
                ),
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.default_margin),
                        top = dimensionResource(id = R.dimen.default_margin)),
                text = "Bussiness list",
                color = Color.White
            )

            Text(
                modifier = Modifier
                    .padding(
                        bottom = dimensionResource(id = R.dimen.default_margin),
                        end = dimensionResource(id = R.dimen.default_margin)),
                text = "Add item +",
                color = Color.White)

        }
    }

}