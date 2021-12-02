package com.example.todokotlinandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@OptIn(ExperimentalUnitApi::class)
@Preview
@Composable

fun CategoriesEmptyScreen() {

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
                    start = dimensionResource(id = R.dimen.default_margin),
                    top = dimensionResource(id = R.dimen.default_margin)
                )
        ) {
            Text(
                text = "Categories",
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(32f, TextUnitType.Sp)
            )

            Text(
                modifier = Modifier
                    .padding(end = 42.dp),
                text = "+",
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(14f, TextUnitType.Sp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Text(
                text = "Nothing here",
                color = LighterGray,
                fontSize = TextUnit(32f, TextUnitType.Sp),
                modifier = Modifier
                    .align(Alignment.Center)

            )
            Button(
                onClick = { TODO() },
                colors = ButtonDefaults.buttonColors(
                  backgroundColor = HeavenBlue,
                  contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(HeavenBlue)
                    .align(Alignment.BottomCenter)
                    .padding(
                        start = dimensionResource(id = R.dimen.default_margin),
                        bottom = dimensionResource(id = R.dimen.default_margin),
                        end = dimensionResource(id = R.dimen.default_margin)
                    )

            ){
                Text(
                    text = "Add Category",
                    fontSize = 16.sp,
                    )
            }
        }
    }

}