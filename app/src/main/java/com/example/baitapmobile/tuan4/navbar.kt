package com.example.baitapmobile.tuan4
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.baitapmobile.R

@Composable
fun BottomNavigationBar(navController: NavController, onFabClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(bottom = 20.dp)
            .background(Color.Transparent), // Add padding to raise it slightly above the bottom
        contentAlignment = Alignment.BottomCenter,

        ) {
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(40.dp))
                .height(60.dp),
            containerColor = Color.Cyan,
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            // Navigation items
            IconButton(onClick = {  navController.navigate("list") }) {
                Icon(
                    painter = painterResource(id = R.drawable.homebtn), // Replace with your home icon
                    contentDescription = "Home",
                    tint = Color.Blue,
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = { /* Navigate to calendar */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.calendarbtn), // Replace with your calendar icon
                    contentDescription = "Calendar",
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)

                )
            }
            Spacer(modifier = Modifier.weight(1f)) // Spacer for FAB alignment
            IconButton(onClick = { /* Navigate to documents */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.docbtn), // Replace with your document icon
                    contentDescription = "Documents",
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)

                )
            }
            IconButton(onClick = { /* Navigate to settings */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.settingbtn), // Replace with your settings icon
                    contentDescription = "Settings",
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)

                )
            }
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = onFabClick,
            containerColor = Color.Transparent,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = -5.dp), // Offset to place FAB above the BottomAppBar
            contentColor = Color.Transparent,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.plusbtn), // Replace with your add icon
                contentDescription = "Add",
                tint = Color.Unspecified,
                modifier = Modifier.size(100.dp) // Set desired size for the icon
            )
        }
    }
}
