package com.example.baitap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController : NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Illustration
        Image(
            painter = painterResource(id = R.drawable.getstart3), // Replace with your image
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(20.dp),
            //            contentScale = ContentScale.Fit
        )

        Text(
            text = "UTH SmartTask",
            color = Color.Cyan,
            fontSize = 60.sp, // Use sp for text size
            fontWeight = FontWeight.Bold, // Use FontWeight.Bold instead of "bold"
            textAlign = TextAlign.Center,
        )
        // Automatically navigate after 3 seconds
        LaunchedEffect(Unit) {
            delay(3000) // 3-second delay
            navController.navigate("getstarted1") // Navigate to GetStarted screen
        }
    }
}

@Composable
fun GetStarted1(navController : NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Cyan, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )

            }
            TextButton(onClick = { navController.navigate("getstarted3") }) {
                Text(text = "Skip", color = Color.Cyan, fontSize = 16.sp)
            }
        }

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.getstart1), // Replace with your image
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
//            contentScale = ContentScale.Fit
        )

        // Title
        Text(
            text = "Easy Time Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Description
        Text(
            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Next Button
        Button(
            onClick = { navController.navigate("getstarted2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text(text = "Next", color = Color.White, fontSize = 16.sp)
        }
    }
}




@Composable
fun GetStarted2(navController : NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Cyan, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )

            }
            TextButton(onClick = { navController.navigate("getstarted3") }) {
                Text(text = "Skip", color = Color.Cyan, fontSize = 16.sp)
            }
        }

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.getstart2), // Replace with your actual image
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        // Title
        Text(
            text = "Increase Work Effectiveness",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Description
        Text(
            text = "Time management and the determination of more important tasks will give your job statistics better and always improve.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f)) // Push buttons to bottom

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back Button (Circular Icon)
            IconButton(
                onClick = {navController.navigate("getstarted1")},
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Cyan, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            // Next Button (Rounded Rectangle)
            Button(
                onClick = {navController.navigate("getstarted3")},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .height(50.dp)
                    .width(220.dp)
            ) {
                Text(text = "Next", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}




@Composable
fun GetStarted3(navController : NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Cyan, shape = CircleShape)
                        .padding(30.dp)
                )

            }
            TextButton(onClick = { navController.navigate("getstarted3") }) {
                Text(text = "Skip", color = Color.Cyan, fontSize = 16.sp)
            }
        }

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.getstart3), // Replace with your image
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
//            contentScale = ContentScale.Fit
        )

        // Title
        Text(
            text = "Easy Time Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Description
        Text(
            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back Button (Circular Icon)
            IconButton(
                onClick = {navController.navigate("getstarted2")},
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Cyan, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            // Next Button (Rounded Rectangle)
            Button(
                onClick = {navController.navigate("splash")},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .height(50.dp)
                    .width(220.dp)
            ) {
                Text(text = "Next", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

