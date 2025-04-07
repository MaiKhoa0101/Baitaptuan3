package com.example.baitapmobile.tuan4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitapmobile.R

@Composable
fun TaskDetailScreen1(navController3: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Back button and title
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
        ) {
            IconButton(onClick = { navController3.navigate("list1") }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrowback),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(30.dp) // Adjust size as needed
                        .background(Color.Transparent),
                    tint = Color.Unspecified // Ensures the original colors of the drawable are used
                )
            }
            Text(
                text = "Detail",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.Cyan,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Task Title and Description
        Text(
            text = "“The only way to do great work \n" +
                    "is to love what you do”",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 4.dp).fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            lineHeight = 30.sp
        )
        Spacer(modifier = Modifier.weight(1f))

        Image(painter = painterResource(id = R.drawable.quote),
            contentDescription = "anhquote" ,
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Back to root button
        Button(
            onClick = { navController3.navigate("root1") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(50)
        ) {
            Text(
                text = "BACK TO ROOT",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
