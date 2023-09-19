package com.example.myapplication.ui.helpers

import com.example.myapplication.network.model.ApiResponse
import com.example.myapplication.network.model.Character
import com.example.myapplication.ui.models.UICharacter

class Helpers {

    fun mapApiResponseToUi(apiResponse: ApiResponse): List<UICharacter> {
        return apiResponse?.results?.map { character ->
            UICharacter(
                id = character.id ?: 0,
                name = character.name.orEmpty(),
                imageUrl = character.image.orEmpty()
            )
        }?: emptyList()
    }
}