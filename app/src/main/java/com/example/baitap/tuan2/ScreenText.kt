package com.example.baitap.tuan2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.navigation.NavController

@Composable
    fun TextScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
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
                    text = "Text Detail",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    modifier = Modifier
                        .weight(1f) // Makes text take up available space
                        .wrapContentWidth(Alignment.CenterHorizontally) // Centers text inside its column
                )
            }
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 18.sp)) {
                        append("The ")
                    }
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.LineThrough,
                            fontSize = 18.sp
                        )
                    ) {
                        append("quick ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF8000), // Orange
                            fontSize = 22.sp
                        )
                    ) {
                        append("Brown")
                    }
                    append("\n")

                    withStyle(style = SpanStyle(fontSize = 18.sp)) {
                        append("fox j u m p s ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    ) {
                        append("over")
                    }
                    append("\n")

                    withStyle(style = SpanStyle(fontSize = 18.sp)) {
                        append("the ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontStyle = FontStyle.Italic,
                            fontSize = 18.sp
                        )
                    ) {
                        append("lazy")
                    }
                    append(" dog.")
                },
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(top = 4.dp)
                    .background(Color.Gray)
            )
        }
    }

