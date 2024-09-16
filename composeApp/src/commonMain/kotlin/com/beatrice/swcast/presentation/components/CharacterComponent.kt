package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beatrice.swcast.domain.models.Character

@Composable
fun CharacterComponent(modifier: Modifier = Modifier,
                       character: Character) {
   Box(modifier = modifier){
       ImageComponent(
           imageUrl = character.imageUrl
       )
       RegularText(text = character.name, modifier = Modifier.align(Alignment.BottomCenter))
   }

}