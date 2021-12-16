package com.example.todokotlinandroid.features.categories

import com.example.todokotlinandroid.models.Category

data class CategoriesViewState(
    val categories: List<Category> = emptyList(),
    val loading: Boolean = true,
    val showErrorDialog: Boolean = false
)

sealed class CategoryIntent {
    object AddCategoryClicked: CategoryIntent()
    data class CategoryClicked(val id: Int): CategoryIntent()
}