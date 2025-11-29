package com.example.upay.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumericKeypad(onKeyClick: (String) -> Unit) {
    val keys = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("DEL", "0", ""),
    )

    Column {
        keys.forEach { row ->
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { key ->
                    KeyButton(key = key, onClick = onKeyClick)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun RowScope.KeyButton(key: String, onClick: (String) -> Unit) {
    Surface(
        modifier = Modifier
            .weight(1f)
            .height(60.dp)
            .clickable { if (key.isNotEmpty()) onClick(key)},
        color = androidx.compose.ui.graphics.Color.White
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = if (key == "DEL") "×" else key, fontSize = 24.sp)
        }
    }
}