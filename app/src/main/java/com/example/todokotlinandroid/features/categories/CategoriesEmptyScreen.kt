package com.example.todokotlinandroid.features.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.todokotlinandroid.*
import com.example.todokotlinandroid.R
import com.example.todokotlinandroid.colors.HeavenBlue
import com.example.todokotlinandroid.colors.LighterGray
import com.example.todokotlinandroid.features.categories.CategoriesViewModel
import com.example.todokotlinandroid.features.categories.CategoryIntent
import kotlinx.coroutines.channels.Channel

@OptIn(ExperimentalUnitApi::class)
@Composable

fun CategoriesEmptyScreen(intentChannel: Channel<CategoryIntent>) {

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
                onClick = {
                          intentChannel.trySend(CategoryIntent.AddCategoryClicked)
                },
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
                    text = "Add Category",
                    fontSize = 16.sp,
                    )
            }
        }
    }

}

@Composable
@Preview("CategoriesEmptyScreen")
fun CategoriesEmptyView() {
    MaterialTheme() {
        CategoriesEmptyScreen(Channel())
    }
}