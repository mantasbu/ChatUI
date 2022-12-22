package com.kotlisoft.chatui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.kotlisoft.chatui.R
import com.kotlisoft.chatui.presentation.ui.theme.LightRed
import com.kotlisoft.chatui.presentation.ui.theme.LightRedDisabled

@Composable
fun BottomBar(
    onFocusTextField: () -> Unit,
    onSendMessage: (String) -> Unit
) {
    var message by rememberSaveable { mutableStateOf("") }
    BottomAppBar {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = message,
                placeholder = {
                    Text(
                        text = stringResource(R.string.message_placeholder),
                        color = Color.Gray
                    )
                },
                onValueChange = {
                    message = it
                },
                shape =  RoundedCornerShape(32.dp),
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .weight(1F)
                    .onFocusEvent { event ->
                        if (event.isFocused) {
                            onFocusTextField()
                        }
                    },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(
                    onSend = {
                        if (message.isNotBlank()) {
                            onSendMessage(message)
                            message = ""
                        }
                    },
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = stringResource(R.string.send),
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(if (message.isBlank()) LightRedDisabled else LightRed)
                    .padding(8.dp)
                    .clickable {
                        if (message.isNotBlank()) {
                            onSendMessage(message)
                            message = ""
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}