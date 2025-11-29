package com.example.upay.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.upay.ui.screens.UpayYellow

@Composable
fun PinInputField(pin: String, lenght: Int) {
    Row {
        repeat(lenght) {index ->
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        color = if (index < pin.length) UpayYellow else Color.LightGray,
                        shape = CircleShape
                    )
            )
            if(index < pin.length - 1) {
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}