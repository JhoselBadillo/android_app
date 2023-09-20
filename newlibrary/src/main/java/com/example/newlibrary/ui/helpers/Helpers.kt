package com.example.newlibrary.ui.helpers

import com.example.newlibrary.ui.models.UICharacter

class Helpers {

    fun mapApiResponseToUi(apiResponse: com.example.newlibrary.network.model.ApiResponse): List<UICharacter> {
        return apiResponse?.results?.map { character ->
            com.example.newlibrary.ui.models.UICharacter(
                id = character.id ?: 0,
                name = character.name.orEmpty(),
                imageUrl = character.image.orEmpty()
            )
        } ?: emptyList()
    }
}