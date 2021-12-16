package com.example.todokotlinandroid.add_category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AddCategoryViewModel(
    onSaveButtonTapped: () -> Unit
): ViewModel() {

    private val _viewState = MutableStateFlow(AddCategoryViewState())
    val viewState = _viewState.asStateFlow()

    private val _intentChannel = Channel<AddCategoryIntent>()
    val intentChannel = _intentChannel

    init {
        viewModelScope.launch {
            launch {
                _intentChannel.consumeAsFlow().collect { intent ->
                    when (intent) {
                        AddCategoryIntent.OnSaveButtonClicked -> {

                        }
                        is AddCategoryIntent.TitleChanged -> {
                            _viewState.update {
                                it.copy(title = intent.title)
                            }
                        }
                    }

                }


            }
        }
    }
}