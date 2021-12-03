package com.example.todokotlinandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@OptIn(ExperimentalUnitApi::class)
@Preview
@Composable

fun AddCategoriesScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 38.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "")

            Text(
                text = "Create category",
                fontSize = TextUnit(16f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 17.dp)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(
                    top = 49.dp
                )
        ) {
            Text(
                text = "Title",
                color = MediumGray,
                fontSize = TextUnit(24f, TextUnitType.Sp),
                modifier = Modifier
                    .padding(start = 16.dp)

            )
            Button(
                onClick = { TODO() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = HeavenBlue,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(
                        start = dimensionResource(id = R.dimen.default_margin),
                        bottom = dimensionResource(id = R.dimen.default_margin),
                        end = dimensionResource(id = R.dimen.default_margin)
                    )

            ){
                Text(
                    text = "Save",
                    fontSize = 16.sp,
                )
            }
        }

    }

}