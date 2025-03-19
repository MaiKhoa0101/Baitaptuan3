package com.example.baitap.tuan2
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun TextFieldScreen(navController: NavController) {
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
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {text = it},
            label = { Text("Label") }
        )

    }
}

