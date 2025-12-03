package com.example.upay.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.upay.R
import com.example.upay.ui.components.PinInputField

val UpayYellow = Color(0xFFFDD835)

@Composable
fun PinInputScreen(
    onPinVerified: () -> Unit
) {
    var pinValue by remember { mutableStateOf("") }
    val maxPinLength = 4

    fun onKeyClick(key: String) {
        when (key) {
            "DEL" -> if (pinValue.isNotEmpty()) pinValue = pinValue.dropLast(1)
            "OK" -> if (pinValue.length == maxPinLength) onPinVerified()
            else -> if (pinValue.length < maxPinLength) pinValue += key
        }
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween // Space to push keypad to bottom
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Logo + language
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Upay Logo",
                        modifier = Modifier.size(60.dp)
                    )
                    Text(
                        text = "বাংলা",
                        color = UpayYellow,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { /* Language change */ }
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Instruction text
                Text(
                    text = "আপনার ৪ ডিজিটের\n   পিন প্রদান করুন",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    lineHeight = 32.sp
                )

                Spacer(modifier = Modifier.height(32.dp))

                // PIN input field
                PinInputField(pinValue, maxPinLength)

                Spacer(modifier = Modifier.height(42.dp))

                // Biometric icons with labels
                Row(
                    horizontalArrangement = Arrangement.spacedBy(48.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.Face,
                            contentDescription = "Face ID",
                            tint = UpayYellow,
                            modifier = Modifier
                                .size(48.dp)
                                .clickable { /* Face ID */ }
                        )
                        Text(text = "Face", fontWeight = FontWeight.Bold, color = Color.Black)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.Fingerprint,
                            contentDescription = "Fingerprint",
                            tint = UpayYellow,
                            modifier = Modifier
                                .size(48.dp)
                                .clickable { /* Fingerprint */ }
                        )
                        Text(text = "Fingerprint", fontWeight = FontWeight.Bold, color = Color.Black)
                    }
                }

                Spacer(modifier = Modifier.height(100.dp))

                // Forgot PIN
                Text(
                    text = "পিন ভুলে গিয়েছেন?",
                    color = UpayYellow,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { /* Forgot PIN */ }
                )
            }

            // Keypad at bottom
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val keys = listOf(
                        listOf("1", "2", "3"),
                        listOf("4", "5", "6"),
                        listOf("7", "8", "9"),
                        listOf("DEL", "0", "OK")
                    )

                    keys.forEach { row ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp)
                        ) {
                            row.forEach { key ->
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp)
                                        .background(
                                            color = if (key == "DEL" || key == "OK") UpayYellow else Color.White,
                                            shape = CircleShape
                                        )
                                        .clickable { onKeyClick(key) }
                                ) {
                                    val icon = when (key) {
                                        "DEL" -> Icons.Filled.ArrowBack
                                        "OK" -> Icons.Filled.Check
                                        else -> null
                                    }
                                    if (icon != null) {
                                        Icon(
                                            imageVector = icon,
                                            contentDescription = key,
                                            tint = Color.White
                                        )
                                    } else {
                                        Text(
                                            text = key,
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
