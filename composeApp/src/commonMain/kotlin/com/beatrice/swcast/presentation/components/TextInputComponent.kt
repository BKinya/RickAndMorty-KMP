package com.beatrice.swcast.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatrice.swcast.presentation.theme.gold
import com.beatrice.swcast.presentation.theme.gold0
import com.beatrice.swcast.presentation.theme.lightYellow
import com.beatrice.swcast.presentation.theme.smokeWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputComponent(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChanged: (String) -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember {
        mutableStateOf(false)
    }
    BasicTextField(
        modifier = modifier.height(64.dp)
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused

            }.border(
                width = 2.dp,
                shape = RoundedCornerShape(40.dp),
                color = if (isFocused) gold else gold0
            ),
        value = query,
        onValueChange = onQueryChanged,
        textStyle = TextStyle(
            color = lightYellow,
            fontSize = 24.sp,
            fontWeight = FontWeight.Light
        ),
        cursorBrush = SolidColor(smokeWhite),
        decorationBox = @Composable { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = query,
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                placeholder = {
                    Text(
                        "Enter a character's name",
                        style = TextStyle(
                            color = smokeWhite,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Thin
                        )
                    )
                },
                singleLine = true,
                enabled = true,
                isError = false,
                interactionSource = interactionSource,
                container = {
                    ContainerBox(
                        enabled = true,
                        isError = false,
                        interactionSource,
                        colors = OutlinedTextFieldDefaults.colors(),
                        shape = RoundedCornerShape(40.dp)
                    )
                }
            )
        }
    )
}