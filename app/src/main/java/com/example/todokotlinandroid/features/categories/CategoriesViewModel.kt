package com.example.todokotlinandroid.features.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class CategoriesViewModel(
    onAddCategory: () -> Unit
) : ViewModel() {

    private val _viewState = MutableStateFlow(CategoriesViewState())
    val viewState = _viewState.asStateFlow()

    private val _intentChannel = Channel<CategoryIntent>()
    val intentChannel = _intentChannel

    init {
        viewModelScope.launch {
            launch {
                _intentChannel.consumeAsFlow().collect { intent ->
                    when (intent) {
                        CategoryIntent.AddCategoryClicked -> {

                        }
                        is CategoryIntent.CategoryClicked -> {

                        }
                    }

                }
            }
        }

    }
}