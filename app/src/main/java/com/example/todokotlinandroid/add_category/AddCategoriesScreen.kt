package com.example.todokotlinandroid.add_category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.todokotlinandroid.*
import com.example.todokotlinandroid.R
import com.example.todokotlinandroid.colors.HeavenBlue
import com.example.todokotlinandroid.features.categories.CategoryIntent

@OptIn(ExperimentalUnitApi::class)
@Composable
fun AddCategoriesScreen(viewModel: AddCategoryViewModel) {

    val viewState = viewModel.viewState.collectAsState().value
    val intentChannel = viewModel.intentChannel

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 38.dp
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = ""
            )

            Text(
                text = stringResource(id = R.string.create_category),
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
            TextField(
                value = viewState.title,
                label = { Text(text = "Title") },
                onValueChange = { title ->
                    intentChannel.trySend(AddCategoryIntent.TitleChanged(title))
                },
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)

            )
            Button(
                onClick = { intentChannel.trySend(AddCategoryIntent.OnSaveButtonClicked) },
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

            ) {
                Text(
                    text = "Save",
                    fontSize = 16.sp,
                )
            }
        }

    }

}

