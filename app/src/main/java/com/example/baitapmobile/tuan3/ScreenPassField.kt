package com.example.baitapmobile.tuan3
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController

@Composable
fun PassFieldScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Button at the start
            IconButton(
                onClick = { navController.navigate("home") }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack, // Arrow icon
                    contentDescription = "Navigate",
                    tint = Color.Red, // Make the arrow red
                    modifier = Modifier.size(30.dp)
                )
            }

            // Text centered within the row
            Text(
                text = "TextField",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                modifier = Modifier
                    .weight(1f) // Makes text take up available space
                    .wrapContentWidth(Alignment.CenterHorizontally) // Centers text inside its column
            )
        }
        var pass by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        TextField(
            value = pass,
            onValueChange = {pass = it},
            label = { "Password" },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation('*'),

            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.ArrowBack else Icons.Default.ArrowForward,
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            },

        )

    }
}

