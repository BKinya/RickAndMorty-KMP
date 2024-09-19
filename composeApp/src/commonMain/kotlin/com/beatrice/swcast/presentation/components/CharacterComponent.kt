package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.beatrice.swcast.domain.models.Character
import com.beatrice.swcast.presentation.theme.black
import com.beatrice.swcast.presentation.theme.lightYellow

@Composable
fun CharacterComponent(
    modifier: Modifier = Modifier,
    character: Character,
    onItemClicked: (Character) -> Unit
) {
    Box(
        modifier = modifier
            .width(200.dp)
            .height(247.dp)
            .clickable(onClick = {onItemClicked(character)})
            .border(
                shape = RoundedCornerShape(20.dp),
                color = lightYellow,
                width = 1.dp
            )
            .clip(shape = RoundedCornerShape(20.dp) )
            .background(color = black)

    ) {
        Column(modifier = Modifier) {
            ImageComponent(
                imageUrl = character.imageUrl,
                modifier = Modifier.height(200.dp)

            )
            Spacer(Modifier.height(8.dp))
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                RegularText(
                    text = if (character.name.length <= 12) {
                        character.name
                    }else{
                        "${character.name.take(8)} ..."
                    },
                    modifier = Modifier.align(Alignment.Center))
            }
            Spacer(Modifier.height(8.dp))
        }
    }

}