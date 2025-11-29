package com.example.upay.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.upay.ui.components.NumericKeypad
import com.example.upay.ui.components.PinInputField

val UpayYellow = Color(0xFFFDD835)

@Composable
fun PinInputScreen(
    onPinVerified: () -> Unit
) {
    var pinValue by remember { mutableStateOf("") }
    val maxPinLength = 4

    fun onKeyClick(key: String) {
        if (key == "DEL") {
            if(pinValue.isNotEmpty()) pinValue = pinValue.dropLast(1)
        }
        else if (pinValue.length < maxPinLength) {
            pinValue += key
        }

        if (pinValue.length == maxPinLength) {
            onPinVerified()
        }
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "আপনার ৪ ডিজিটের পিন প্রদান করুন",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                PinInputField(pinValue, maxPinLength)

                Spacer(modifier = Modifier.width(16.dp))

                Surface(
                    shape = CircleShape,
                    color = if (pinValue.length == maxPinLength) UpayYellow else Color.Gray,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            NumericKeypad(onKeyClick = { key -> onKeyClick(key) })
        }
    }
}