package com.example.baitapmobile.tuan3
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
@Composable
fun LayoutScreen(navController: NavController) {
    var tempLayout by remember { mutableStateOf<String?>(null) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Row with Back Button and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Navigate",
                        tint = Color.Red,
                        modifier = Modifier.size(30.dp)
                    )
                }

                Text(
                    text = "Column",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }

            // Buttons Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { tempLayout = "Column" }) {
                    Text(text = "Column", fontSize = 16.sp)
                }
                Button(onClick = { tempLayout = "Row" }) {
                    Text(text = "Row", fontSize = 16.sp)
                }
                Button(onClick = { tempLayout = "Box" }) {
                    Text(text = "Box", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display example based on selected layout
            when (tempLayout) {
                "Column" -> ExampleColumnLayout()
                "Row" -> ExampleRowLayout()
                "Box" -> ExampleBoxLayout()
            }
        }
    }


    @Composable
    fun ExampleColumnLayout() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Column Example", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }
    }

    @Composable
    fun ExampleRowLayout() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Row Example", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }
    }

    @Composable
    fun ExampleBoxLayout() {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.LightGray)
                .border(1.dp, Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text("Box Example", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Cyan)
                    .border(1.dp, Color.Red),
                contentAlignment = Alignment.Center
            )   {
                Icon(
                    imageVector = Icons.Default.ArrowBack, // Arrow icon
                    contentDescription = "Navigate",
                    tint = Color.Red, // Make the arrow red
                    modifier = Modifier.size(30.dp)
                    )
                }
            }


    }






