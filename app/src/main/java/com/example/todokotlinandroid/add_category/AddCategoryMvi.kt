package com.example.todokotlinandroid.add_category


data class AddCategoryViewState( // samo podatci koji se prikazuju na ekranu
    val title: String = ""
)

sealed class AddCategoryIntent { // podatci koji se salju na view model sa ekrana
    object OnSaveButtonClicked: AddCategoryIntent()
    data class TitleChanged(val title: String): AddCategoryIntent()
}