package com.example.todokotlinandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

@Preview
@Composable

fun CategoriesEmptyScreen() {

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
                    top = dimensionResource(id = R.dimen.default_margin)
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Nothing here",
                color = Color.LightGray,

            )
        }

        Button(onClick = {
            //TODO: navigate to next screen
        },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(HeavenBlue)
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius)))
                .padding(
                    start = dimensionResource(id = R.dimen.default_margin),
                    bottom = dimensionResource(id = R.dimen.default_margin),
                    end = dimensionResource(id = R.dimen.default_margin),
                )
        ) {
            Text(
                text = "Add Category",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }

}